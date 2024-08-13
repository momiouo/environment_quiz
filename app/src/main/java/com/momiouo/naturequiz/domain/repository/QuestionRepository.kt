package com.momiouo.naturequiz.domain.repository

import com.momiouo.naturequiz.domain.model.Question
import kotlinx.coroutines.flow.Flow

interface QuestionRepository {
    fun getQuestion(theme: String, level: String, position: Int): Flow<Question?>
    fun getLevelByTheme(theme: String): Flow<Int>
    suspend fun saveIsGoodAnswer(isGoodAnswer: Boolean)
    suspend fun resetIsGoodAnswerCounter()
    fun getQuestionNumberThemeLevelUseCase(theme: String, level: String): Flow<Int>
    fun getGoodAnswerCounter(): Flow<Int>
}