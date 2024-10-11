package com.momiouo.naturequiz.ui.screens.end

import androidx.annotation.StringRes
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.momiouo.naturequiz.domain.usecase.GetGoodAnswerCounterUseCase
import com.momiouo.naturequiz.domain.usecase.GetQuestionNumberThemeLevelUseCase
import com.momiouo.naturequiz.domain.usecase.ResetIsGoodAnswerCounterUseCase
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
    private val resetIsGoodAnswerCounterUseCase: ResetIsGoodAnswerCounterUseCase
) : ViewModel() {

    //TODO create constant arguments key in nav graph
    private val selectedThemeId: StateFlow<String> = savedStateHandle.getStateFlow("themeId", "")
    private val selectedLevelId: StateFlow<String> = savedStateHandle.getStateFlow("levelId", "")

    val endUiState =
        getQuestionNumberThemeLevelUseCase.invoke(selectedThemeId.value, selectedLevelId.value)
            .combine(getGoodAnswerCounterUseCase.invoke()) { questionNumber, goodAnswerNumber ->
                val score =
                    Math.round(((goodAnswerNumber.toDouble() / questionNumber.toDouble()) * 100))
                val text = if (score == 100L) {
                    R.string.rep1
                } else if (score >= 80L) {
                    R.string.rep2
                } else if (score >= 50L) {
                    R.string.rep3
                } else {
                    R.string.rep4
                }
                EndUiState.Loaded(score.toInt(), text)
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
        @StringRes val text: Int
    ) : EndUiState

}

