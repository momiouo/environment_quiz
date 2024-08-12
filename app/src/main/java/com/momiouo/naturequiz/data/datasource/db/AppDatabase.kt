package com.momiouo.naturequiz.data.datasource.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.momiouo.naturequiz.data.datasource.db.entity.QuestionDAO
import com.momiouo.naturequiz.data.datasource.db.entity.QuestionEntity
import com.momiouo.naturequiz.data.datasource.db.entity.QuestionEntityEn

@Database(entities = [QuestionEntity::class, QuestionEntityEn::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun questionDAO(): QuestionDAO
}