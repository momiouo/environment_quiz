package com.momiouo.naturequiz.ui.screens.level

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.momiouo.naturequiz.domain.usecase.GetLevelByThemeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class LevelViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getLevelByThemeUseCase: GetLevelByThemeUseCase,
) : ViewModel() {

    private val selectedThemeId: StateFlow<String> = savedStateHandle.getStateFlow("themeId", "")

    val levelUiState =
        getLevelByThemeUseCase.invoke(selectedThemeId.value)
            .map {
                LevelUiState.Loaded(it)
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = LevelUiState.Loading,
            )

}

sealed interface LevelUiState {
    data object Loading : LevelUiState

    data class Loaded(
        val levelNumber: Int,
    ) : LevelUiState

}

