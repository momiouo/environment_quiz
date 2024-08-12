package com.momiouo.naturequiz.domain.usecase

import com.momiouo.naturequiz.domain.repository.QuestionRepository
import javax.inject.Inject

class GetQuestionUseCase @Inject constructor(
    private val repository: QuestionRepository
) {
    operator fun invoke(theme: String, level: String) =
        repository.getQuestions(theme, level)

}