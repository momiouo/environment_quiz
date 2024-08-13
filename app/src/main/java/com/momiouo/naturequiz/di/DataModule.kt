package com.momiouo.naturequiz.di

import android.content.Context
import com.momiouo.naturequiz.data.datasource.datastore.AppSharedPref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun providesAppDataStorePref(
        @ApplicationContext context: Context,
    ) = AppSharedPref(context)
}