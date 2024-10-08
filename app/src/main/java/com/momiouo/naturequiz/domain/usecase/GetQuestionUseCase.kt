package com.momiouo.naturequiz.domain.usecase

import android.util.Log
import com.momiouo.naturequiz.domain.model.Question
import com.momiouo.naturequiz.domain.repository.QuestionRepository
import com.momiouo.naturequiz.tools.ThemeDbConverter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuestionUseCase @Inject constructor(
    private val repository: QuestionRepository
) {
    operator fun invoke(theme: String, level: String, position: Int): Flow<Question?> {
        Log.d(
            "GetQuestionUseCase",
            "invoke() called with: theme = $theme, level = $level, position = $position"
        )
        return repository.getQuestion(
            ThemeDbConverter.fromUiThemeToDBTheme(theme) ?: "",
            level,
            position
        )
    }

}