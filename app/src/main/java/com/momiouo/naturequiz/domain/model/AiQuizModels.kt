package com.momiouo.naturequiz.domain.model

data class ArticleItem(
    val id: String,
    val title: String,
    val sourceName: String,
    val url: String,
    val summary: String,
    val publishedDate: String,
    val themeTag: String = "general",
    val imageUrl: String = "",
    val curatedQuestions: List<Question> = emptyList()
)

data class GeneratedAiQuiz(
    val title: String,
    val sourceArticles: List<ArticleItem>,
    val questions: List<Question>
)

data class SavedAiQuiz(
    val levelId: Int,
    val title: String,
    val sourcesSummary: String,
    val createdAt: String,
    val questionCount: Int,
    val articleTitle: String = "",
    val articleUrl: String = "",
    val articleImageUrl: String = ""
)

enum class AiQuizErrorSource {
    NO_INTERNET,
    AI_SERVICE,
    SEARCH_SERVICE,
    UNKNOWN
}

class AiQuizException(
    val errorSource: AiQuizErrorSource,
    message: String? = null,
    cause: Throwable? = null
) : Exception(message, cause)
