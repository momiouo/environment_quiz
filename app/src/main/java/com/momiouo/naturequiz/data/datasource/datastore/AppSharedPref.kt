package com.momiouo.naturequiz.data.datasource.datastore

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import com.momiouo.naturequiz.domain.model.SavedAiQuiz
import com.momiouo.naturequiz.tools.Const
import org.json.JSONArray
import org.json.JSONObject
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

    fun getAiFreeTriesUsed(): Int =
        pref.getInt(KEY_AI_FREE_TRIES_USED, 0)

    fun incrementAiFreeTriesUsed() {
        val used = getAiFreeTriesUsed()
        editor.putInt(KEY_AI_FREE_TRIES_USED, used + 1)
        editor.commit()
    }

    fun getRemainingAiFreeTries(): Int =
        (Const.MAX_FREE_AI_QUIZ_TRIES - getAiFreeTriesUsed()).coerceAtLeast(0)

    fun isAiProSubscribed(): Boolean =
        pref.getBoolean(KEY_AI_PRO_SUBSCRIBED, false)

    fun setAiProSubscribed(isSubscribed: Boolean) {
        editor.putBoolean(KEY_AI_PRO_SUBSCRIBED, isSubscribed)
        editor.commit()
    }

    fun getSavedAiQuizzes(): List<SavedAiQuiz> {
        val rawJson = pref.getString(KEY_SAVED_AI_QUIZZES, null) ?: return emptyList()
        return try {
            val array = JSONArray(rawJson)
            val list = mutableListOf<SavedAiQuiz>()
            for (i in 0 until array.length()) {
                val obj = array.getJSONObject(i)
                list.add(
                    SavedAiQuiz(
                        levelId = obj.optInt("levelId", i + 1),
                        title = obj.optString("title", "AI Quiz #${i + 1}"),
                        sourcesSummary = obj.optString("sourcesSummary", "Futura Sciences"),
                        createdAt = obj.optString("createdAt", ""),
                        questionCount = obj.optInt("questionCount", 5)
                    )
                )
            }
            list.sortedByDescending { it.levelId }
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun addSavedAiQuiz(quiz: SavedAiQuiz) {
        val current = getSavedAiQuizzes().filterNot { it.levelId == quiz.levelId }.toMutableList()
        current.add(0, quiz)
        saveAiQuizzesList(current)
    }

    fun removeSavedAiQuiz(levelId: Int) {
        val updated = getSavedAiQuizzes().filterNot { it.levelId == levelId }
        saveAiQuizzesList(updated)
    }

    private fun saveAiQuizzesList(list: List<SavedAiQuiz>) {
        val array = JSONArray()
        list.forEach { item ->
            val obj = JSONObject().apply {
                put("levelId", item.levelId)
                put("title", item.title)
                put("sourcesSummary", item.sourcesSummary)
                put("createdAt", item.createdAt)
                put("questionCount", item.questionCount)
            }
            array.put(obj)
        }
        editor.putString(KEY_SAVED_AI_QUIZZES, array.toString())
        editor.commit()
    }

    companion object {
        private const val KEY_AI_FREE_TRIES_USED = "ai_free_tries_used"
        private const val KEY_AI_PRO_SUBSCRIBED = "ai_pro_subscribed"
        private const val KEY_SAVED_AI_QUIZZES = "saved_ai_quizzes_json"
    }
}