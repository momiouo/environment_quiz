package com.momiouo.naturequiz.data.repository

import android.content.Context
import android.util.Log
import androidx.compose.ui.text.intl.Locale
import com.momiouo.naturequiz.data.datasource.datastore.AppSharedPref
import com.momiouo.naturequiz.data.datasource.db.AppDatabase
import com.momiouo.naturequiz.data.datasource.db.entity.toQuestion
import com.momiouo.naturequiz.domain.model.Question
import com.momiouo.naturequiz.domain.repository.QuestionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class QuestionRepositoryImpl @Inject constructor(
    private val context: Context,
    private val appDatabase: AppDatabase,
    private val appSharedPref: AppSharedPref
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


}