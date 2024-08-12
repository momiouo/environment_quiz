package com.momiouo.naturequiz.data.repository

import android.util.Log
import com.momiouo.naturequiz.data.datasource.db.AppDatabase
import com.momiouo.naturequiz.data.datasource.db.entity.toQuestion
import com.momiouo.naturequiz.domain.model.Question
import com.momiouo.naturequiz.domain.repository.QuestionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QuestionRepositoryImpl(
    private val appDatabase: AppDatabase
) : QuestionRepository {

    override fun getQuestions(theme: String, level: String): Flow<List<Question>> {
        Log.d(
            "QuestionRepositoryImpl",
            "getQuestions() called with: theme = $theme, level = $level"
        )

        return appDatabase.questionDAO().getAllQuestionsByThemeLevel(theme, level)
            .map { questionEntityList ->
                Log.d(
                    "QuestionRepositoryImpl",
                    "getQuestions() called with: questionEntityList = $questionEntityList"
                )
                questionEntityList.map { it.toQuestion() }
            }
    }
}