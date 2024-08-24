package com.momiouo.naturequiz.domain.model

import com.momiouo.naturequiz.ui.screens.QuestionUiModel

data class Question(
    val question: String,
    val firstResponse: String,
    val secondResponse: String,
    val thirdResponse: String,
    val correctAnswer: Int,
    val hint: String,
    val explanation: String
)

fun Question.toQuestionUiModel(): QuestionUiModel {
    return QuestionUiModel(
        question = question,
        firstResponse = firstResponse,
        secondResponse = secondResponse,
        thirdResponse = thirdResponse,
        correctAnswer = correctAnswer,
        hint = hint,
        explanation = explanation
    )
}