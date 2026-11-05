package com.momiouo.naturequiz.ui.screens.aiquiz

import android.app.Activity
import androidx.compose.ui.text.intl.Locale
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.momiouo.naturequiz.data.billing.BillingManager
import com.momiouo.naturequiz.domain.model.ArticleItem
import com.momiouo.naturequiz.domain.model.GeneratedAiQuiz
import com.momiouo.naturequiz.domain.model.SavedAiQuiz
import com.momiouo.naturequiz.domain.repository.QuestionRepository
import com.momiouo.naturequiz.tools.Const
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

data class AiQuizUiState(
    val selectedThemeTag: String = THEME_ALL,
    val articles: List<ArticleItem> = emptyList(),
    val selectedArticleIds: Set<String> = emptySet(),
    val isSearchingArticles: Boolean = false,
    val isGeneratingQuiz: Boolean = false,
    val generatedQuiz: GeneratedAiQuiz? = null,
    val savedQuizLevelId: Int? = null,
    val savedQuizzes: List<SavedAiQuiz> = emptyList(),
    val remainingFreeTries: Int = Const.MAX_FREE_AI_QUIZ_TRIES,
    val showPaywallDialog: Boolean = false,
    val isApiKeyConfigured: Boolean = false
) {
    val filteredArticles: List<ArticleItem>
        get() = articles

    companion object {
        const val THEME_ALL = "all"
    }
}

@HiltViewModel
class AiQuizViewModel @Inject constructor(
    private val repository: QuestionRepository,
    private val billingManager: BillingManager
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        AiQuizUiState(
            savedQuizzes = repository.getSavedAiQuizzes(),
            remainingFreeTries = repository.getRemainingAiFreeTries(),
            isApiKeyConfigured = repository.isGeminiApiKeyConfigured()
        )
    )
    val uiState: StateFlow<AiQuizUiState> = _uiState.asStateFlow()

    val isSubscribed: StateFlow<Boolean> = billingManager.isSubscribed
    val formattedPrice: StateFlow<String?> = billingManager.formattedPrice

    init {
        billingManager.startBillingConnection()
        loadArticlesForTheme(AiQuizUiState.THEME_ALL)
    }

    fun selectTheme(themeTag: String) {
        if (_uiState.value.selectedThemeTag.equals(themeTag, ignoreCase = true) && _uiState.value.articles.isNotEmpty()) {
            return
        }
        _uiState.update {
            it.copy(
                selectedThemeTag = themeTag,
                selectedArticleIds = emptySet()
            )
        }
        loadArticlesForTheme(themeTag)
    }

    fun toggleArticleSelection(articleId: String) {
        _uiState.update { state ->
            val updated = state.selectedArticleIds.toMutableSet()
            if (updated.contains(articleId)) {
                updated.remove(articleId)
            } else {
                updated.add(articleId)
            }
            state.copy(selectedArticleIds = updated)
        }
    }

    fun loadArticlesForTheme(themeTag: String = _uiState.value.selectedThemeTag) {
        val language = Locale.current.language
        _uiState.update { it.copy(isSearchingArticles = true) }

        viewModelScope.launch {
            val foundArticles = repository.searchArticles(
                topicQuery = themeTag,
                selectedSources = emptyList(),
                language = language
            )
            _uiState.update {
                it.copy(
                    articles = foundArticles,
                    selectedArticleIds = emptySet(),
                    isSearchingArticles = false
                )
            }
        }
    }

    fun generateQuizFromSelectedArticles() {
        val state = _uiState.value
        if (state.isGeneratingQuiz) return

        val subscribed = isSubscribed.value
        val remainingTries = repository.getRemainingAiFreeTries()

        if (!subscribed && remainingTries <= 0) {
            _uiState.update {
                it.copy(
                    remainingFreeTries = 0,
                    showPaywallDialog = true
                )
            }
            return
        }

        val chosenArticles = state.articles.filter { state.selectedArticleIds.contains(it.id) }
        if (chosenArticles.isEmpty()) return

        val language = Locale.current.language
        _uiState.update {
            it.copy(
                isGeneratingQuiz = true,
                generatedQuiz = null,
                savedQuizLevelId = null
            )
        }

        viewModelScope.launch {
            val generated = repository.generateQuizFromArticles(chosenArticles, language)
            if (!subscribed) {
                repository.incrementAiFreeTriesUsed()
            }
            _uiState.update {
                it.copy(
                    isGeneratingQuiz = false,
                    generatedQuiz = generated,
                    savedQuizLevelId = null,
                    remainingFreeTries = repository.getRemainingAiFreeTries()
                )
            }
        }
    }

    fun saveCurrentQuizLocally() {
        val quiz = _uiState.value.generatedQuiz ?: return
        if (_uiState.value.savedQuizLevelId != null) return

        viewModelScope.launch(Dispatchers.IO) {
            val savedQuiz = repository.saveGeneratedAiQuizLocally(quiz)
            val allSaved = repository.getSavedAiQuizzes()
            _uiState.update {
                it.copy(
                    savedQuizLevelId = savedQuiz.levelId,
                    savedQuizzes = allSaved
                )
            }
        }
    }

    fun saveAndPlayCurrentQuiz(onNavigateToQuiz: (theme: String, level: String) -> Unit) {
        val quiz = _uiState.value.generatedQuiz ?: return
        val existingLevelId = _uiState.value.savedQuizLevelId

        viewModelScope.launch {
            val targetLevelId = withContext(Dispatchers.IO) {
                repository.resetIsGoodAnswerCounter()
                if (existingLevelId != null) {
                    existingLevelId
                } else {
                    val saved = repository.saveGeneratedAiQuizLocally(quiz)
                    val allSaved = repository.getSavedAiQuizzes()
                    _uiState.update {
                        it.copy(
                            savedQuizLevelId = saved.levelId,
                            savedQuizzes = allSaved
                        )
                    }
                    saved.levelId
                }
            }
            onNavigateToQuiz(Const.AI_QUIZ_DB_THEME, targetLevelId.toString())
        }
    }

    fun playSavedQuiz(levelId: Int, onNavigateToQuiz: (theme: String, level: String) -> Unit) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.resetIsGoodAnswerCounter()
            }
            onNavigateToQuiz(Const.AI_QUIZ_DB_THEME, levelId.toString())
        }
    }

    fun deleteSavedQuiz(levelId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteSavedAiQuiz(levelId)
            val allSaved = repository.getSavedAiQuizzes()
            _uiState.update { state ->
                state.copy(
                    savedQuizzes = allSaved,
                    savedQuizLevelId = if (state.savedQuizLevelId == levelId) null else state.savedQuizLevelId
                )
            }
        }
    }

    fun openPaywall() {
        _uiState.update { it.copy(showPaywallDialog = true) }
    }

    fun dismissPaywall() {
        _uiState.update { it.copy(showPaywallDialog = false) }
    }

    fun subscribeMonthly(activity: Activity?) {
        billingManager.launchSubscriptionFlow(
            activity = activity,
            onStoreProductNotReady = {
            }
        )
    }

    fun restoreSubscription() {
        billingManager.queryActiveSubscriptions()
    }

    fun activateDebugSubscription() {
        billingManager.setSubscribedState(true)
        _uiState.update { it.copy(showPaywallDialog = false) }
    }
}
