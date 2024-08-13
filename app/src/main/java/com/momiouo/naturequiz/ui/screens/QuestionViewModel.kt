package com.momiouo.naturequiz.ui.screens

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.momiouo.naturequiz.domain.model.toQuestionUiModel
import com.momiouo.naturequiz.domain.usecase.GetQuestionUseCase
import com.momiouo.naturequiz.domain.usecase.SaveIsGoodAnswerUseCase
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

    val questionUiState: StateFlow<QuestionUiState> =
        getQuestionUseCase.invoke(
            selectedThemeId.value,
            selectedLevelId.value,
            selectedPositionId.value
        ).combine(_isQuestionAnswered) { question, isAnswered ->
            Log.d(
                "QuestionViewModel",
                "questionUiStateFlow() called with: question = $question, isAnswered = $isAnswered"
            )
            if (question != null) {
                QuestionUiState.Loaded(question.toQuestionUiModel(), isAnswered)
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
}

sealed interface QuestionUiState {
    data object Loading : QuestionUiState

    data object Finished : QuestionUiState

    data class Loaded(
        val question: QuestionUiModel?,
        val isAnswered: Boolean
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

