package com.momiouo.naturequiz.domain.model

data class ArticleItem(
    val id: String,
    val title: String,
    val sourceName: String,
    val url: String,
    val summary: String,
    val publishedDate: String,
    val themeTag: String = "general",
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
    val questionCount: Int
)
