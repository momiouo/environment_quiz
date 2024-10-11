package com.momiouo.naturequiz

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import fr.momiouo.naturequiz.BuildConfig

@HiltAndroidApp
class MyApp : Application() {

    override fun onCreate() {
        if (BuildConfig.DEBUG) {
            Log.d("MyApp", "onCreate() called")
        }
        super.onCreate()
    }
}