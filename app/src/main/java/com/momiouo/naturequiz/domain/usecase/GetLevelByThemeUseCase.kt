package com.momiouo.naturequiz.domain.usecase

import android.util.Log
import com.momiouo.naturequiz.domain.repository.QuestionRepository
import com.momiouo.naturequiz.tools.ThemeDbConverter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class GetLevelByThemeUseCase @Inject constructor(
    private val repository: QuestionRepository
) {
    operator fun invoke(theme: String): Flow<Int> {
        Log.d(
            "GetLevelByThemeUseCase",
            "invoke() called with: theme = $theme"
        )
        return repository.getLevelByTheme(
            ThemeDbConverter.fromUiThemeToDBTheme(theme) ?: ""
        )
    }

}