package com.momiouo.naturequiz.ui.screens

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.momiouo.naturequiz.domain.model.toQuestionUiModel
import com.momiouo.naturequiz.domain.usecase.GetQuestionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getQuestionUseCase: GetQuestionUseCase
) : ViewModel() {

    //TODO create arguments key constant in nav graph
    private val selectedThemeId: StateFlow<String> = savedStateHandle.getStateFlow("themeId", "")
    private val selectedLevelId: StateFlow<String> = savedStateHandle.getStateFlow("levelId", "")

    val questionUiState: StateFlow<QuestionUiState> =
        getQuestionUseCase.invoke(selectedThemeId.value, selectedLevelId.value)
            .map { questionList ->
                QuestionUiState.Loaded(questionList.map { it.toQuestionUiModel() })
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = QuestionUiState.Loading,
            )
}

sealed interface QuestionUiState {
    data object Loading : QuestionUiState

    data class Loaded(
        val questionsList: List<QuestionUiModel>?,
    ) : QuestionUiState

}

data class QuestionUiModel(
    val question: String,
    val firstResponse: String,
    val secondResponse: String,
    val thirdResponse: String,
    val correctAnswer: Int,
    val hint: String
)

