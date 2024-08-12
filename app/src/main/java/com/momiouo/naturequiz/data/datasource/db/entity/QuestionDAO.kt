package com.momiouo.naturequiz.data.datasource.db.entity

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: QuestionEntity)

    @Query("SELECT * FROM exotypeqcm")
    suspend fun getAllQuestions(): List<QuestionEntity>

    @Query("SELECT * FROM exotypeqcm WHERE theme=:theme AND niveau=:level")
    fun getAllQuestionsByThemeLevel(
        theme: String,
        level: String
    ): Flow<List<QuestionEntity>>
}