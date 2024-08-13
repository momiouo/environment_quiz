package com.momiouo.naturequiz.di

import com.momiouo.naturequiz.data.datasource.datastore.AppSharedPref
import com.momiouo.naturequiz.data.datasource.db.AppDatabase
import com.momiouo.naturequiz.data.repository.QuestionRepositoryImpl
import com.momiouo.naturequiz.domain.repository.QuestionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun providesQuestionRepository(
        database: AppDatabase,
        appSharedPref: AppSharedPref
    ): QuestionRepository = QuestionRepositoryImpl(database, appSharedPref)
}