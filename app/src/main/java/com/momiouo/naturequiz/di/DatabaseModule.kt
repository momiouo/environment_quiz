package com.momiouo.naturequiz.di

import android.content.Context
import androidx.room.Room
import com.momiouo.naturequiz.data.datasource.db.AppDatabase
import com.momiouo.naturequiz.data.datasource.db.MyDatabaseCallback
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Provides
    @Singleton
    fun providesAppDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "my_database",
    ).addCallback(MyDatabaseCallback).build()
}
