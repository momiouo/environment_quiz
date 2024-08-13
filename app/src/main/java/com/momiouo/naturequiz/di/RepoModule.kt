package com.momiouo.naturequiz.di

import android.content.Context
import com.momiouo.naturequiz.data.datasource.datastore.AppSharedPref
import com.momiouo.naturequiz.data.datasource.db.AppDatabase
import com.momiouo.naturequiz.data.repository.QuestionRepositoryImpl
import com.momiouo.naturequiz.domain.repository.QuestionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun providesQuestionRepository(
        @ApplicationContext context: Context,
        database: AppDatabase,
        appSharedPref: AppSharedPref
    ): QuestionRepository = QuestionRepositoryImpl(context, database, appSharedPref)
}