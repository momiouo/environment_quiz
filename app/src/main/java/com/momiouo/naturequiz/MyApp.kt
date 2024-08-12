package com.momiouo.naturequiz

import android.app.Application
import android.util.Log
import androidx.room.Room
import com.momiouo.naturequiz.data.datasource.db.AppDatabase
import com.momiouo.naturequiz.data.datasource.db.MyDatabaseCallback
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application() {

    override fun onCreate() {
        Log.d("MyApp", "onCreate() called")
        super.onCreate()
    }
}