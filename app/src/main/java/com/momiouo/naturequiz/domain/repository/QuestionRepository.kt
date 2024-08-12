package com.momiouo.naturequiz.domain.repository

import com.momiouo.naturequiz.domain.model.Question
import kotlinx.coroutines.flow.Flow

interface QuestionRepository {
    fun getQuestions(theme: String, level: String): Flow<List<Question>>
}