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

    //OFFSET SKIP row before :position
    @Query("SELECT * FROM exotypeqcm WHERE theme=:theme AND niveau=:level LIMIT 1 OFFSET :position")
    fun getQuestionByThemeLevelPosition(
        theme: String,
        level: String,
        position: Int
    ): Flow<QuestionEntity?>

    @Query("SELECT count(*) FROM exotypeqcm WHERE theme=:theme AND niveau=:level")
    fun getQuestionCountByThemeLevel(
        theme: String,
        level: String,
    ): Flow<Int>
}