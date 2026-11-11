package com.momiouo.naturequiz.ui.screens.end

import androidx.annotation.StringRes
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.momiouo.naturequiz.domain.repository.QuestionRepository
import com.momiouo.naturequiz.domain.usecase.GetGoodAnswerCounterUseCase
import com.momiouo.naturequiz.domain.usecase.GetQuestionNumberThemeLevelUseCase
import com.momiouo.naturequiz.domain.usecase.ResetIsGoodAnswerCounterUseCase
import com.momiouo.naturequiz.tools.Const
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.momiouo.naturequiz.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EndViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getQuestionNumberThemeLevelUseCase: GetQuestionNumberThemeLevelUseCase,
    getGoodAnswerCounterUseCase: GetGoodAnswerCounterUseCase,
    private val resetIsGoodAnswerCounterUseCase: ResetIsGoodAnswerCounterUseCase,
    private val repository: QuestionRepository
) : ViewModel() {

    private val selectedThemeId: StateFlow<String> = savedStateHandle.getStateFlow("themeId", "")
    private val selectedLevelId: StateFlow<String> = savedStateHandle.getStateFlow("levelId", "")

    val endUiState =
        getQuestionNumberThemeLevelUseCase.invoke(selectedThemeId.value, selectedLevelId.value)
            .combine(getGoodAnswerCounterUseCase.invoke()) { questionNumber, goodAnswerNumber ->
                val score = if (questionNumber > 0) {
                    Math.round(((goodAnswerNumber.toDouble() / questionNumber.toDouble()) * 100)).toInt()
                } else {
                    0
                }
                val text = when {
                    score == 100 -> R.string.rep1
                    score >= 80 -> R.string.rep2
                    score >= 50 -> R.string.rep3
                    else -> R.string.rep4
                }

                val isAiQuiz = selectedThemeId.value == Const.AI_QUIZ_DB_THEME
                val levelInt = selectedLevelId.value.toIntOrNull() ?: 0
                val savedAiQuiz = if (isAiQuiz) repository.getSavedAiQuizByLevel(levelInt) else null

                EndUiState.Loaded(
                    score = score,
                    text = text,
                    isAiQuiz = isAiQuiz,
                    articleTitle = savedAiQuiz?.articleTitle?.ifBlank { savedAiQuiz.title } ?: "",
                    articleUrl = savedAiQuiz?.articleUrl ?: "",
                    articleImageUrl = savedAiQuiz?.articleImageUrl ?: "",
                    sourceName = savedAiQuiz?.sourcesSummary?.ifBlank { "Futura Sciences" } ?: "",
                    quizTitle = savedAiQuiz?.title ?: "Nature Quiz"
                )
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = EndUiState.Loading,
            )

    fun resetIsGoodAnswerCounter() =
        viewModelScope.launch(Dispatchers.IO) { resetIsGoodAnswerCounterUseCase.invoke() }
}

sealed interface EndUiState {
    data object Loading : EndUiState

    data class Loaded(
        val score: Int,
        @StringRes val text: Int,
        val isAiQuiz: Boolean = false,
        val articleTitle: String = "",
        val articleUrl: String = "",
        val articleImageUrl: String = "",
        val sourceName: String = "",
        val quizTitle: String = ""
    ) : EndUiState
}
