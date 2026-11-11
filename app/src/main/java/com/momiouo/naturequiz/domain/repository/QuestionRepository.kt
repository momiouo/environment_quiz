package com.momiouo.naturequiz.domain.repository

import com.momiouo.naturequiz.domain.model.ArticleItem
import com.momiouo.naturequiz.domain.model.GeneratedAiQuiz
import com.momiouo.naturequiz.domain.model.Question
import com.momiouo.naturequiz.domain.model.SavedAiQuiz
import kotlinx.coroutines.flow.Flow

interface QuestionRepository {
    fun getQuestion(theme: String, level: String, position: Int): Flow<Question?>
    fun getLevelByTheme(theme: String): Flow<Int>
    suspend fun saveIsGoodAnswer(isGoodAnswer: Boolean)
    suspend fun resetIsGoodAnswerCounter()
    fun getQuestionNumberThemeLevelUseCase(theme: String, level: String): Flow<Int>
    fun getGoodAnswerCounter(): Flow<Int>

    suspend fun searchArticles(
        topicQuery: String,
        selectedSources: List<String>,
        language: String
    ): List<ArticleItem>

    suspend fun generateQuizFromArticles(
        articles: List<ArticleItem>,
        language: String
    ): GeneratedAiQuiz

    suspend fun saveGeneratedAiQuizLocally(quiz: GeneratedAiQuiz): SavedAiQuiz
    fun getSavedAiQuizzes(): List<SavedAiQuiz>
    fun getSavedAiQuizByLevel(levelId: Int): SavedAiQuiz?
    suspend fun deleteSavedAiQuiz(levelId: Int)
    fun getRemainingAiFreeTries(): Int
    fun incrementAiFreeTriesUsed()
    fun isGeminiApiKeyConfigured(): Boolean
}