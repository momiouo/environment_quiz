package com.momiouo.naturequiz.domain.usecase

import android.util.Log
import com.momiouo.naturequiz.domain.repository.QuestionRepository
import com.momiouo.naturequiz.tools.ThemeDbConverter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuestionNumberThemeLevelUseCase @Inject constructor(
    private val repository: QuestionRepository
) {
    operator fun invoke(theme: String, level: String): Flow<Int> {
        Log.d(
            "GetQuestionNumberThemeLevelUseCase",
            "invoke() called with: theme = $theme, level = $level"
        )
        return repository.getQuestionNumberThemeLevelUseCase(
            ThemeDbConverter.fromUiThemeToDBTheme(theme) ?: "",
            level
        )
    }

}