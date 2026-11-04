package com.momiouo.naturequiz.data.repository

import android.content.Context
import android.util.Log
import androidx.compose.ui.text.intl.Locale
import com.momiouo.naturequiz.data.datasource.datastore.AppSharedPref
import com.momiouo.naturequiz.data.datasource.db.AppDatabase
import com.momiouo.naturequiz.data.datasource.db.entity.QuestionEntity
import com.momiouo.naturequiz.data.datasource.db.entity.QuestionEntityEn
import com.momiouo.naturequiz.data.datasource.db.entity.toQuestion
import com.momiouo.naturequiz.data.datasource.remote.GeminiAiDataSource
import com.momiouo.naturequiz.domain.model.ArticleItem
import com.momiouo.naturequiz.domain.model.GeneratedAiQuiz
import com.momiouo.naturequiz.domain.model.Question
import com.momiouo.naturequiz.domain.model.SavedAiQuiz
import com.momiouo.naturequiz.domain.repository.QuestionRepository
import com.momiouo.naturequiz.tools.Const
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject

class QuestionRepositoryImpl @Inject constructor(
    private val context: Context,
    private val appDatabase: AppDatabase,
    private val appSharedPref: AppSharedPref,
    private val geminiAiDataSource: GeminiAiDataSource
) : QuestionRepository {

    override fun getQuestion(theme: String, level: String, position: Int): Flow<Question?> {
        Log.d(
            "QuestionRepositoryImpl",
            "getQuestion() called with: theme = $theme, level = $level, position = $position local=${Locale.current.language}"
        )

        return if (Locale.current.language == "fr") {
            appDatabase.questionDAO().getQuestionByThemeLevelPosition(theme, level, position)
                .map { questionEntity ->
                    Log.d(
                        "QuestionRepositoryImpl",
                        "getQuestion() called with: questionEntityList = $questionEntity"
                    )
                    questionEntity?.toQuestion()
                }
        } else {
            appDatabase.questionDAO().getQuestionByThemeLevelPositionEN(theme, level, position)
                .map { questionEntity ->
                    Log.d(
                        "QuestionRepositoryImpl",
                        "getQuestion() called with: questionEntityList = $questionEntity"
                    )
                    questionEntity?.toQuestion()
                }
        }
    }

    override fun getLevelByTheme(theme: String): Flow<Int> =
        appDatabase.questionDAO().getLevelByTheme(theme)

    override suspend fun saveIsGoodAnswer(isGoodAnswer: Boolean) {
        Log.d(
            "QuestionRepositoryImpl",
            "saveIsGoodAnswer() called with: isGoodAnswer = $isGoodAnswer"
        )
        if (isGoodAnswer)
            appSharedPref.incrementSharedPrefCounter()
    }

    override suspend fun resetIsGoodAnswerCounter() {
        appSharedPref.resetSharedPrefCounter()
    }

    override fun getQuestionNumberThemeLevelUseCase(theme: String, level: String): Flow<Int> {
        Log.d(
            "QuestionRepositoryImpl",
            "getQuestionNumberThemeLevelUseCase() called with: theme = $theme, level = $level"
        )
        return appDatabase.questionDAO().getQuestionCountByThemeLevel(theme, level)
    }

    override fun getGoodAnswerCounter(): Flow<Int> = flowOf(appSharedPref.getSharedPrefCounter())

    override suspend fun searchArticles(
        topicQuery: String,
        selectedSources: List<String>,
        language: String
    ): List<ArticleItem> {
        return geminiAiDataSource.searchRecentArticles(topicQuery, selectedSources, language)
    }

    override suspend fun generateQuizFromArticles(
        articles: List<ArticleItem>,
        language: String
    ): GeneratedAiQuiz {
        return geminiAiDataSource.generateQuizFromArticles(articles, language)
    }

    override suspend fun saveGeneratedAiQuizLocally(quiz: GeneratedAiQuiz): SavedAiQuiz {
        val dao = appDatabase.questionDAO()
        val maxDbLevel = dao.getMaxLevelByTheme(Const.AI_QUIZ_DB_THEME)
        val maxSavedLevel = appSharedPref.getSavedAiQuizzes().maxOfOrNull { it.levelId } ?: 0
        val nextLevel = maxOf(maxDbLevel, maxSavedLevel) + 1

        quiz.questions.forEach { q ->
            val frEntity = QuestionEntity(
                theme = Const.AI_QUIZ_DB_THEME,
                niveau = nextLevel,
                question = q.question,
                goodanswer = q.correctAnswer,
                answer1 = q.firstResponse,
                answer2 = q.secondResponse,
                answer3 = q.thirdResponse,
                indice = q.hint,
                explication = q.explanation
            )
            dao.insertQuestion(frEntity)

            val enEntity = QuestionEntityEn().apply {
                theme = Const.AI_QUIZ_DB_THEME
                niveau = nextLevel
                question = q.question
                goodanswer = q.correctAnswer
                answer1 = q.firstResponse
                answer2 = q.secondResponse
                answer3 = q.thirdResponse
                indice = q.hint
                explication = q.explanation
            }
            dao.insertQuestionEn(enEntity)
        }

        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", java.util.Locale.getDefault())
        val sourcesSummary = quiz.sourceArticles.map { it.sourceName }.distinct().joinToString(", ")
            .ifEmpty { "Futura Sciences" }
        val savedQuiz = SavedAiQuiz(
            levelId = nextLevel,
            title = quiz.title,
            sourcesSummary = sourcesSummary,
            createdAt = dateFormat.format(Date()),
            questionCount = quiz.questions.size
        )
        appSharedPref.addSavedAiQuiz(savedQuiz)
        return savedQuiz
    }

    override fun getSavedAiQuizzes(): List<SavedAiQuiz> {
        return appSharedPref.getSavedAiQuizzes()
    }

    override suspend fun deleteSavedAiQuiz(levelId: Int) {
        val dao = appDatabase.questionDAO()
        dao.deleteQuestionsByThemeAndLevel(Const.AI_QUIZ_DB_THEME, levelId)
        dao.deleteQuestionsByThemeAndLevelEn(Const.AI_QUIZ_DB_THEME, levelId)
        appSharedPref.removeSavedAiQuiz(levelId)
    }

    override fun getRemainingAiFreeTries(): Int {
        return appSharedPref.getRemainingAiFreeTries()
    }

    override fun incrementAiFreeTriesUsed() {
        appSharedPref.incrementAiFreeTriesUsed()
    }

    override fun isGeminiApiKeyConfigured(): Boolean {
        return geminiAiDataSource.isApiKeyConfigured()
    }
}