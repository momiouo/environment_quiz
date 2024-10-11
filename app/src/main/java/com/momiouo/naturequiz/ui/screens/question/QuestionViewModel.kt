package com.momiouo.naturequiz.ui.screens.question

import android.content.Context
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.momiouo.naturequiz.domain.model.toQuestionUiModel
import com.momiouo.naturequiz.domain.usecase.GetQuestionUseCase
import com.momiouo.naturequiz.domain.usecase.SaveIsGoodAnswerUseCase
import com.momiouo.naturequiz.tools.getActivityOrNull
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getQuestionUseCase: GetQuestionUseCase,
    private val saveIsGoodAnswerUseCase: SaveIsGoodAnswerUseCase,
) : ViewModel() {

    //TODO create arguments key constant in nav graph
    private val selectedThemeId: StateFlow<String> = savedStateHandle.getStateFlow("themeId", "")
    private val selectedLevelId: StateFlow<String> = savedStateHandle.getStateFlow("levelId", "")
    private val selectedPositionId: StateFlow<Int> = savedStateHandle.getStateFlow("positionId", 0)

    private val _isQuestionAnswered = MutableStateFlow(false)
    val isQuestionAnswered = _isQuestionAnswered.asStateFlow()

    private val _isAdLoading = MutableStateFlow(false)
    val isAdLoading = _isAdLoading.asStateFlow()

    val questionUiState: StateFlow<QuestionUiState> =
        combine(
            getQuestionUseCase.invoke(
                selectedThemeId.value,
                selectedLevelId.value,
                selectedPositionId.value
            ), _isQuestionAnswered, _isAdLoading
        ) { question, isAnswered, isAdLoading ->
            Log.d(
                "QuestionViewModel",
                "questionUiStateFlow() called with: question = $question, isAnswered = $isAnswered, isAdLoading = $isAdLoading"
            )
            if (question != null) {
                QuestionUiState.Loaded(question.toQuestionUiModel(), isAnswered, isAdLoading)
            } else {
                QuestionUiState.Finished
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = QuestionUiState.Loading,
        )

    fun saveIsGoodAnswer(isGoodAnswer: Boolean) = viewModelScope.launch(Dispatchers.IO) {
        _isQuestionAnswered.update { true }
        saveIsGoodAnswerUseCase.invoke(isGoodAnswer)
    }

    //TODO Add this logic in a repo then use case then here ...
    fun showInterstitialAd(context: Context, admobId: String, onAdFinished: () -> Unit) {
        Log.d(
            "QuestionViewModel",
            "showInterstialAd() called with: context = $context, goToNextQuestion = $onAdFinished"
        )
        _isAdLoading.update { true }
        val adCallBack = object : FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() {
                onAdFinished()
                _isAdLoading.update { false }
            }
        }

        InterstitialAd.load(
            context,
            admobId,
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d("QuestionViewModel", "onAdFailedToLoad() called with: adError = $adError")
                    onAdFinished()
                    _isAdLoading.update { false }
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.d(
                        "QuestionViewModel",
                        "onAdLoaded() called with: interstitialAd = $interstitialAd"
                    )
                    context.getActivityOrNull()?.let { interstitialAd.show(it) }
                    interstitialAd.fullScreenContentCallback = adCallBack
                }
            }
        )


    }
}

sealed interface QuestionUiState {
    data object Loading : QuestionUiState

    data object Finished : QuestionUiState

    data class Loaded(
        val question: QuestionUiModel?,
        val isAnswered: Boolean,
        val isAdLoading: Boolean
    ) : QuestionUiState

}

data class QuestionUiModel(
    val question: String,
    val firstResponse: String,
    val secondResponse: String,
    val thirdResponse: String,
    val correctAnswer: Int,
    val hint: String,
    val explanation: String
)

