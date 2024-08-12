package com.momiouo.naturequiz.domain.usecase

import com.momiouo.naturequiz.domain.model.Question
import com.momiouo.naturequiz.domain.repository.QuestionRepository
import com.momiouo.naturequiz.tools.ThemeDbConverter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuestionUseCase @Inject constructor(
    private val repository: QuestionRepository
) {
    operator fun invoke(theme: String, level: String): Flow<List<Question>> {
        return repository.getQuestions(ThemeDbConverter.fromUiThemeToDBTheme(theme) ?: "", level)
    }

}