package com.momiouo.naturequiz.ui.screens.answer

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.momiouo.naturequiz.domain.usecase.GetQuestionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class AnswerQuestionViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getQuestionUseCase: GetQuestionUseCase,
) : ViewModel() {
    //TODO create arguments key constant in nav graph
    private val selectedThemeId: StateFlow<String> = savedStateHandle.getStateFlow("themeId", "")
    private val selectedLevelId: StateFlow<String> = savedStateHandle.getStateFlow("levelId", "")
    private val selectedPositionId: StateFlow<Int> = savedStateHandle.getStateFlow("positionId", 0)

    val questionUiState: StateFlow<AnswerQuestionUiState> =
        getQuestionUseCase.invoke(
            selectedThemeId.value,
            selectedLevelId.value,
            selectedPositionId.value
        ).mapNotNull { question ->
            question?.let {
                AnswerQuestionUiState.Loaded(
                    AnswerQuestionUiModel(
                        it.question,
                        it.explanation
                    )
                )
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = AnswerQuestionUiState.Loading,
        )


}


sealed interface AnswerQuestionUiState {
    data object Loading : AnswerQuestionUiState

    data class Loaded(
        val question: AnswerQuestionUiModel?
    ) : AnswerQuestionUiState

}

data class AnswerQuestionUiModel(
    val question: String,
    val explanation: String
)

