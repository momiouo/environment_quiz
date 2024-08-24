package com.momiouo.naturequiz.data.datasource.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.momiouo.naturequiz.domain.model.Question

@Entity(tableName = "exotypeqcm")
open class QuestionEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "theme")
    var theme: String? = null,

    @ColumnInfo(name = "niveau")
    var niveau: Int = 0,

    @ColumnInfo(name = "question")
    var question: String? = null,

    @ColumnInfo(name = "positiongoodanswer")
    var goodanswer: Int = 0,

    @ColumnInfo(name = "answer1")
    var answer1: String? = null,

    @ColumnInfo(name = "answer2")
    var answer2: String? = null,

    @ColumnInfo(name = "answer3")
    var answer3: String? = null,

    @ColumnInfo(name = "indice")
    var indice: String? = null,

    @ColumnInfo(name = "explication")
    var explication: String? = null
)

fun QuestionEntity.toQuestion(): Question {
    return Question(
        question = question ?: "",
        firstResponse = answer1 ?: "",
        secondResponse = answer2 ?: "",
        thirdResponse = answer3 ?: "",
        correctAnswer = goodanswer,
        hint = indice ?: "",
        explanation = explication ?: ""
    )
}