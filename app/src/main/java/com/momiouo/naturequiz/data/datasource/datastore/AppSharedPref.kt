package com.momiouo.naturequiz.data.datasource.datastore

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import javax.inject.Inject

class AppSharedPref @Inject constructor(
    private val context: Context,
) {

    private var pref: SharedPreferences =
        context.getSharedPreferences("MyPref", 0) // 0 - for private mode
    private var editor: Editor = pref.edit()

    fun incrementSharedPrefCounter() {
        val counter = pref.getInt("counter", 0)
        editor.putInt("counter", counter + 1)
        editor.commit()
    }

    fun resetSharedPrefCounter() {
        editor.putInt("counter", 0)
        editor.commit()
    }

    fun getSharedPrefCounter() =
        pref.getInt("counter", 0)

}