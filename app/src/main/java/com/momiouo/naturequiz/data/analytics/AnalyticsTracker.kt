package com.momiouo.naturequiz.data.analytics

import android.content.Context
import android.os.Bundle
import android.util.Log
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import dagger.hilt.android.qualifiers.ApplicationContext
import fr.momiouo.naturequiz.BuildConfig
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnalyticsTracker @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val firebaseAnalytics: FirebaseAnalytics by lazy {
        FirebaseAnalytics.getInstance(context)
    }

    private val crashlytics: FirebaseCrashlytics by lazy {
        FirebaseCrashlytics.getInstance()
    }

    // =========================================================================
    // AI Quiz Events
    // =========================================================================

    fun logThemeSelected(theme: String) {
        logEvent("ai_theme_selected") {
            putString("theme", theme.take(32))
        }
    }

    fun logCustomSearch(query: String) {
        logEvent("ai_custom_search") {
            putString("query_length", query.length.toString())
            putString("search_query", query.take(40))
        }
    }

    fun logArticlesLoaded(theme: String, count: Int, isCustom: Boolean) {
        logEvent("ai_articles_loaded") {
            putString("theme", theme.take(32))
            putLong("article_count", count.toLong())
            putBoolean("is_custom", isCustom)
        }
    }

    fun logQuizGenerationStarted(theme: String, articlesCount: Int) {
        logEvent("ai_quiz_generation_started") {
            putString("theme", theme.take(32))
            putLong("selected_articles_count", articlesCount.toLong())
        }
        crashlytics.log("Started quiz generation for theme=$theme with $articlesCount articles")
    }

    fun logQuizGenerationSuccess(
        quizTitle: String,
        questionsCount: Int,
        durationMs: Long,
        modelName: String
    ) {
        logEvent("ai_quiz_generation_success") {
            putString("quiz_title", quizTitle.take(50))
            putLong("questions_count", questionsCount.toLong())
            putLong("duration_ms", durationMs)
            putString("ai_model", modelName)
        }
        crashlytics.log("Quiz generation success: '$quizTitle' ($questionsCount questions in ${durationMs}ms)")
    }

    fun logQuizGenerationFailed(
        errorSource: String,
        errorMessage: String?,
        durationMs: Long,
        throwable: Throwable? = null
    ) {
        logEvent("ai_quiz_generation_failed") {
            putString("error_source", errorSource)
            putString("error_message", errorMessage?.take(100) ?: "unknown")
            putLong("duration_ms", durationMs)
        }

        crashlytics.setCustomKey("last_ai_error_source", errorSource)
        crashlytics.setCustomKey("last_ai_duration_ms", durationMs)
        if (errorMessage != null) {
            crashlytics.setCustomKey("last_ai_error_msg", errorMessage.take(100))
        }
        if (throwable != null) {
            crashlytics.recordException(throwable)
        } else {
            crashlytics.log("AI Generation failed: errorSource=$errorSource msg=$errorMessage")
        }
    }

    fun logQuizPlayed(title: String, questionCount: Int) {
        logEvent("ai_quiz_played") {
            putString("quiz_title", title.take(50))
            putLong("question_count", questionCount.toLong())
        }
    }

    fun logQuizCompleted(
        scorePercentage: Int,
        goodAnswers: Int,
        totalQuestions: Int,
        articleTitle: String
    ) {
        logEvent("ai_quiz_completed") {
            putLong("score_percentage", scorePercentage.toLong())
            putLong("good_answers", goodAnswers.toLong())
            putLong("total_questions", totalQuestions.toLong())
            putString("article_title", articleTitle.take(50))
        }
    }

    fun logScoreShared(scorePercentage: Int, articleTitle: String) {
        logEvent("ai_score_shared") {
            putLong("score_percentage", scorePercentage.toLong())
            putString("article_title", articleTitle.take(50))
        }
    }

    fun logArticleOpened(articleTitle: String, articleUrl: String) {
        logEvent("ai_article_opened") {
            putString("article_title", articleTitle.take(50))
            putString("article_url", articleUrl.take(100))
        }
    }

    // =========================================================================
    // Subscription & Paywall Events
    // =========================================================================

    fun logPaywallViewed(source: String, remainingFreeTries: Int) {
        logEvent("paywall_viewed") {
            putString("source", source) // e.g. "limit_reached", "badge_click", "quiz_generate"
            putLong("remaining_free_tries", remainingFreeTries.toLong())
        }
        crashlytics.log("Paywall viewed from source=$source (remainingFreeTries=$remainingFreeTries)")
    }

    fun logPaywallSubscribeClicked(source: String, price: String?) {
        logEvent("paywall_subscribe_clicked") {
            putString("source", source)
            putString("displayed_price", price ?: "unknown")
        }
        crashlytics.log("User clicked subscribe on paywall: source=$source price=$price")
    }

    fun logSubscriptionStatusChanged(isSubscribed: Boolean, source: String = "sync") {
        logEvent("subscription_status_changed") {
            putBoolean("is_subscribed", isSubscribed)
            putString("change_source", source)
        }
        crashlytics.setCustomKey("is_subscribed", isSubscribed)
        crashlytics.log("Subscription status updated: isSubscribed=$isSubscribed (source=$source)")
    }

    fun logSubscriptionRestored(isSubscribed: Boolean) {
        logEvent("subscription_restored") {
            putBoolean("is_active", isSubscribed)
        }
        crashlytics.log("Subscription restore performed: isActive=$isSubscribed")
    }

    // =========================================================================
    // Generic Exception & Diagnostics Recording
    // =========================================================================

    fun recordError(
        tag: String,
        message: String,
        throwable: Throwable? = null,
        extraParams: Map<String, String> = emptyMap()
    ) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, message, throwable)
        }
        crashlytics.log("[$tag] $message")
        extraParams.forEach { (key, value) ->
            crashlytics.setCustomKey(key, value.take(100))
        }
        if (throwable != null) {
            crashlytics.recordException(throwable)
        }
    }

    private inline fun logEvent(eventName: String, crossinline paramsBuilder: Bundle.() -> Unit) {
        try {
            val bundle = Bundle().apply(paramsBuilder)
            firebaseAnalytics.logEvent(eventName, bundle)
            if (BuildConfig.DEBUG) {
                Log.d(TAG, "Event logged: $eventName -> $bundle")
            }
        } catch (e: Exception) {
            if (BuildConfig.DEBUG) {
                Log.w(TAG, "Failed to log event $eventName", e)
            }
        }
    }

    companion object {
        private const val TAG = "AnalyticsTracker"
    }
}
