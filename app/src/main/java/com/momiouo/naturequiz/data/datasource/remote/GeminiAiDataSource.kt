package com.momiouo.naturequiz.data.datasource.remote

import android.content.Context
import android.util.Log
import com.momiouo.naturequiz.domain.model.AiQuizErrorSource
import com.momiouo.naturequiz.domain.model.AiQuizException
import com.momiouo.naturequiz.domain.model.ArticleItem
import com.momiouo.naturequiz.domain.model.GeneratedAiQuiz
import com.momiouo.naturequiz.domain.model.Question
import com.momiouo.naturequiz.tools.isNetworkAvailable
import dagger.hilt.android.qualifiers.ApplicationContext
import fr.momiouo.naturequiz.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.ConnectException
import java.net.HttpURLConnection
import java.net.SocketTimeoutException
import java.net.URL
import java.net.UnknownHostException
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GeminiAiDataSource @Inject constructor(
    @ApplicationContext private val context: Context,
    private val serpApiDataSource: SerpApiDataSource
) {

    private val apiKey: String
        get() = BuildConfig.GEMINI_API_KEY.trim()

    // In-memory cache for generated quizzes to optimize token costs and response times
    private val quizCache = ConcurrentHashMap<String, GeneratedAiQuiz>()

    fun isApiKeyConfigured(): Boolean = apiKey.isNotEmpty()

    suspend fun searchRecentArticles(
        topicQuery: String,
        selectedSources: List<String>,
        language: String
    ): List<ArticleItem> = withContext(Dispatchers.IO) {
        if (!context.isNetworkAvailable()) {
            throw AiQuizException(AiQuizErrorSource.NO_INTERNET, "No internet connection")
        }

        val isFrench = language.lowercase().startsWith("fr")

        // 1. If SerpApi key configured, use SerpApi (exact web scraped title & direct article link!)
        if (serpApiDataSource.isConfigured()) {
            try {
                val scrapedArticles = serpApiDataSource.searchArticles(topicQuery.trim(), language)
                if (scrapedArticles.isNotEmpty()) {
                    return@withContext scrapedArticles
                }
            } catch (e: Exception) {
                if (e is UnknownHostException || e is ConnectException || e is SocketTimeoutException || !context.isNetworkAvailable()) {
                    throw AiQuizException(AiQuizErrorSource.NO_INTERNET, e.message, e)
                }
                if (BuildConfig.DEBUG) {
                    Log.e(TAG, "SerpApi search failed", e)
                }
            }
        }

        // 2. Gemini search grounding if valid Gemini key
        if (apiKey.isNotEmpty()) {
            try {
                val prompt = buildArticleSearchPrompt(topicQuery.trim(), isFrench)
                val responseJson = callGeminiWithSearchGrounding(prompt)
                val parsed = parseArticlesFromGeminiResponse(responseJson)
                if (parsed.isNotEmpty()) {
                    return@withContext parsed
                }
            } catch (e: Exception) {
                if (e is UnknownHostException || e is ConnectException || e is SocketTimeoutException || !context.isNetworkAvailable()) {
                    throw AiQuizException(AiQuizErrorSource.NO_INTERNET, e.message, e)
                }
                if (BuildConfig.DEBUG) {
                    Log.e(TAG, "Gemini searchRecentArticles failed", e)
                }
                throw AiQuizException(AiQuizErrorSource.AI_SERVICE, e.message, e)
            }
        }

        if (!context.isNetworkAvailable()) {
            throw AiQuizException(AiQuizErrorSource.NO_INTERNET, "No internet connection")
        }
        throw AiQuizException(AiQuizErrorSource.SEARCH_SERVICE, "No articles found")
    }

    suspend fun generateQuizFromArticles(
        articles: List<ArticleItem>,
        language: String
    ): GeneratedAiQuiz = withContext(Dispatchers.IO) {
        if (!context.isNetworkAvailable()) {
            throw AiQuizException(AiQuizErrorSource.NO_INTERNET, "No internet connection")
        }

        val isFrench = language.lowercase().startsWith("fr")
        val cacheKey = "${articles.map { it.id }.sorted().joinToString(",")}_${if (isFrench) "fr" else "en"}"

        val cached = quizCache[cacheKey]
        if (cached != null) {
            return@withContext cached
        }

        if (apiKey.isNotEmpty() && articles.isNotEmpty()) {
            try {
                val prompt = buildQuizGenerationPrompt(articles, isFrench)
                val responseJson = callGeminiForQuiz(prompt)
                val parsedQuiz = parseQuizFromGeminiResponse(responseJson, articles, isFrench)
                if (parsedQuiz != null && parsedQuiz.questions.isNotEmpty()) {
                    quizCache[cacheKey] = parsedQuiz
                    return@withContext parsedQuiz
                } else {
                    throw AiQuizException(AiQuizErrorSource.AI_SERVICE, "Could not parse questions from AI response")
                }
            } catch (e: Exception) {
                if (e is UnknownHostException || e is ConnectException || e is SocketTimeoutException || !context.isNetworkAvailable()) {
                    throw AiQuizException(AiQuizErrorSource.NO_INTERNET, e.message, e)
                }
                if (e is AiQuizException) throw e
                if (BuildConfig.DEBUG) {
                    Log.e(TAG, "Gemini generateQuizFromArticles failed", e)
                }
                throw AiQuizException(AiQuizErrorSource.AI_SERVICE, e.message, e)
            }
        }

        throw AiQuizException(AiQuizErrorSource.AI_SERVICE, "Gemini API key is missing")
    }

    private fun buildArticleSearchPrompt(
        topic: String,
        isFrench: Boolean
    ): String {
        val queryText = topic.ifEmpty { "environnement biodiversité climat océans faune énergies" }
        return if (isFrench) {
            """
            Utilise Google Search pour explorer le web scientifique et trouver 10 articles d'actualités écologiques récents et précis sur le sujet : "$queryText".
            Explore en priorité Futura Sciences, Nature, NASA Earth, ADEME, Les Horizons, Geo, Science & Vie.
            Réponds UNIQUEMENT avec un tableau JSON valide au format exact :
            [
              {
                "title": "Titre exact de l'article en français",
                "sourceName": "Futura Sciences / Nature / NASA / ADEME",
                "url": "URL complète https://...",
                "summary": "Résumé de 2 phrases contenant des faits scientifiques précis et des chiffres concrets.",
                "publishedDate": "Date récente"
              }
            ]
            """.trimIndent()
        } else {
            """
            Use Google Search to find 10 recent, factual science and ecology news articles about: "$queryText".
            Prioritize Futura Sciences, Nature, NASA Earth, ADEME, Les Horizons, National Geographic.
            Respond ONLY with a valid JSON array in this exact format:
            [
              {
                "title": "Exact article title in English",
                "sourceName": "Futura Sciences / Nature / NASA / ADEME",
                "url": "Full https://... URL",
                "summary": "2-sentence summary containing precise scientific facts and figures.",
                "publishedDate": "Recent date"
              }
            ]
            """.trimIndent()
        }
    }

    private fun buildQuizGenerationPrompt(
        articles: List<ArticleItem>,
        isFrench: Boolean
    ): String {
        val articlesDescription = articles.mapIndexed { index, article ->
            """
            Article ${index + 1}:
            - Titre : ${article.title}
            - Source : ${article.sourceName}
            - Faits scientifiques : ${article.summary}
            """.trimIndent()
        }.joinToString("\n\n")

        return if (isFrench) {
            """
            Tu es un expert créateur de quiz de culture générale pour Nature Quiz.
            Voici les articles sélectionnés :
            $articlesDescription

            RÈGLES CAPITALES ET FORMELLES POUR LES QUESTIONS :
            1. NE JAMAIS mentionner l'article dans la question (interdiction absolue d'écrire 'selon l'article', 'd'après l'article', 'dans l'article de...', etc.).
            2. Les questions doivent être CONCISES, DIRECTES et compréhensibles par N'IMPORTE QUI SANS avoir lu l'article.
            3. Les questions doivent porter sur le monde réel : de vrais animaux, de vrais pourcentages, de vraies technologies, de vrais phénomènes naturels expliqués dans ces articles.
            4. Le quiz doit être 100% DIFFÉRENT et UNIQUE selon les articles choisis : pose des questions sur les sujets précis de ces articles (ex: loup, corail, éolien, satellite, abeille...).
            5. Dans chaque explication, explique le fait scientifique de manière claire et passionnante.
            6. La question doit impérativement faire moins de 90 caractères. Les réponses (firstResponse, secondResponse, thirdResponse) doivent être courtes (moins de 32 caractères chacune).

            Génère 5 questions à choix multiples (3 réponses possibles par question, 1 seule bonne réponse : correctAnswer valant 1, 2 ou 3).
            Réponds UNIQUEMENT avec un objet JSON valide au format :
            {
              "quizTitle": "Titre court du quiz",
              "questions": [
                {
                  "question": "Question concise et directe sur un fait réel ?",
                  "firstResponse": "Choix 1",
                  "secondResponse": "Choix 2",
                  "thirdResponse": "Choix 3",
                  "correctAnswer": 1,
                  "hint": "Indice clair sans donner la réponse",
                  "explanation": "Explication claire du phénomène scientifique"
                }
              ]
            }
            """.trimIndent()
        } else {
            """
            You are an expert science quiz creator for Nature Quiz.
            Here are the chosen articles:
            $articlesDescription

            STRICT MANDATORY RULES FOR QUESTIONS:
            1. NEVER mention the article in the question (never write 'according to the article', 'in the article', etc.).
            2. Questions must be CONCISE, DIRECT, and understandable by anyone WITHOUT reading any article.
            3. Questions must test real-world science: real species, real numbers, clean energy mechanisms, climate facts.
            4. The quiz must be 100% UNIQUE based on the specific articles provided.
            5. In explanations, provide engaging scientific context.
            6. Question text must be strictly under 90 characters. Answer options (firstResponse, secondResponse, thirdResponse) must be short (under 32 characters each).

            Generate 5 multiple-choice questions (3 options each, with correctAnswer as 1, 2, or 3).
            Respond ONLY with a valid JSON object in this format:
            {
              "quizTitle": "Short quiz title",
              "questions": [
                {
                  "question": "Concise and direct real-world trivia question?",
                  "firstResponse": "Option 1",
                  "secondResponse": "Option 2",
                  "thirdResponse": "Option 3",
                  "correctAnswer": 1,
                  "hint": "Helpful clue",
                  "explanation": "Clear explanation of the scientific fact"
                }
              ]
            }
            """.trimIndent()
        }
    }

    private fun callGeminiForQuiz(prompt: String): JSONObject {
        val modelsToTry = listOf("gemini-3.8-flash", "gemini-flash-latest")
        var lastException: Exception? = null

        for (modelName in modelsToTry) {
            try {
                val endpoint =
                    "https://generativelanguage.googleapis.com/v1beta/models/$modelName:generateContent?key=$apiKey"
                val url = URL(endpoint)
                val connection = (url.openConnection() as HttpURLConnection).apply {
                    requestMethod = "POST"
                    connectTimeout = 15_000
                    readTimeout = 40_000
                    doOutput = true
                    setRequestProperty("Content-Type", "application/json; charset=UTF-8")
                }

                val payload = JSONObject().apply {
                    put(
                        "contents",
                        JSONArray().put(
                            JSONObject().apply {
                                put(
                                    "parts",
                                    JSONArray().put(JSONObject().put("text", prompt))
                                )
                            }
                        )
                    )
                    // Guaranteed valid JSON, direct output with 0 thinking token latency
                    put(
                        "generationConfig",
                        JSONObject().apply {
                            put("responseMimeType", "application/json")
                            put("temperature", 0.3)
                            put("maxOutputTokens", 3000)
                            put(
                                "thinkingConfig",
                                JSONObject().apply {
                                    put("thinkingBudget", 0)
                                }
                            )
                        }
                    )
                }

                OutputStreamWriter(connection.outputStream, Charsets.UTF_8).use { writer ->
                    writer.write(payload.toString())
                    writer.flush()
                }

                val responseCode = connection.responseCode
                val stream = if (responseCode in 200..299) {
                    connection.inputStream
                } else {
                    connection.errorStream
                }

                val responseBody = BufferedReader(InputStreamReader(stream, Charsets.UTF_8)).use {
                    it.readText()
                }

                if (responseCode in 200..299) {
                    return JSONObject(responseBody)
                } else {
                    Log.w(TAG, "callGeminiForQuiz: model $modelName returned HTTP $responseCode: $responseBody")
                    lastException = IllegalStateException("HTTP $responseCode: $responseBody")
                }
            } catch (e: Exception) {
                Log.w(TAG, "callGeminiForQuiz: model $modelName failed: ${e.message}")
                lastException = e
            }
        }

        throw lastException ?: IllegalStateException("Gemini API quiz generation request failed")
    }

    private fun callGeminiWithSearchGrounding(prompt: String): JSONObject {
        val modelsToTry = listOf("gemini-3.8-flash", "gemini-flash-latest")
        var lastException: Exception? = null

        for (modelName in modelsToTry) {
            try {
                val endpoint =
                    "https://generativelanguage.googleapis.com/v1beta/models/$modelName:generateContent?key=$apiKey"
                val url = URL(endpoint)
                val connection = (url.openConnection() as HttpURLConnection).apply {
                    requestMethod = "POST"
                    connectTimeout = 20_000
                    readTimeout = 40_000
                    doOutput = true
                    setRequestProperty("Content-Type", "application/json; charset=UTF-8")
                }

                val payload = JSONObject().apply {
                    put(
                        "contents",
                        JSONArray().put(
                            JSONObject().apply {
                                put(
                                    "parts",
                                    JSONArray().put(JSONObject().put("text", prompt))
                                )
                            }
                        )
                    )
                    put(
                        "tools",
                        JSONArray().put(
                            JSONObject().put("google_search", JSONObject())
                        )
                    )
                    // Reasoning & generation config: allow up to 3000 tokens for thought + full JSON output
                    put(
                        "generationConfig",
                        JSONObject().apply {
                            put("temperature", 0.3)
                            put("maxOutputTokens", 3000)
                            put("topP", 0.85)
                        }
                    )
                }

                OutputStreamWriter(connection.outputStream, Charsets.UTF_8).use { writer ->
                    writer.write(payload.toString())
                    writer.flush()
                }

                val responseCode = connection.responseCode
                val stream = if (responseCode in 200..299) {
                    connection.inputStream
                } else {
                    connection.errorStream
                }

                val responseBody = BufferedReader(InputStreamReader(stream, Charsets.UTF_8)).use {
                    it.readText()
                }

                if (responseCode in 200..299) {
                    return JSONObject(responseBody)
                } else {
                    lastException = IllegalStateException("HTTP $responseCode: $responseBody")
                }
            } catch (e: Exception) {
                Log.d(TAG, "callGeminiWithSearchGrounding: modelTried:$modelName exception:$e")
                lastException = e
            }
        }

        throw lastException ?: IllegalStateException("Gemini API request failed")
    }

    private fun extractCandidateText(responseJson: JSONObject): String {
        val candidates = responseJson.optJSONArray("candidates") ?: return ""
        if (candidates.length() == 0) return ""
        val firstCandidate = candidates.optJSONObject(0) ?: return ""
        val content = firstCandidate.optJSONObject("content") ?: return ""
        val parts = content.optJSONArray("parts") ?: return ""
        val builder = StringBuilder()
        for (i in 0 until parts.length()) {
            val part = parts.optJSONObject(i)
            val text = part?.optString("text", "") ?: ""
            if (text.isNotEmpty()) {
                builder.append(text).append("\n")
            }
        }
        return builder.toString().trim()
    }

    private fun parseArticlesFromGeminiResponse(responseJson: JSONObject): List<ArticleItem> {
        val rawText = extractCandidateText(responseJson)
        val jsonArrayStr = extractJsonSubstring(rawText, '[', ']') ?: return emptyList()

        val jsonArray = JSONArray(jsonArrayStr)
        val articles = mutableListOf<ArticleItem>()
        for (i in 0 until jsonArray.length()) {
            val obj = jsonArray.optJSONObject(i) ?: continue
            val title = obj.optString("title").trim()
            if (title.isEmpty()) continue
            val sourceName = obj.optString("sourceName", "Futura Sciences").trim()
            val url = obj.optString("url", "https://www.futura-sciences.com/planete/").trim()
            val summary = obj.optString("summary").trim()
            val publishedDate = obj.optString("publishedDate", "Récemment").trim()
            val themeTag = detectThemeTag(title, summary)
            val imageUrl = obj.optString("imageUrl")
                .ifBlank { getDefaultThumbnailForTheme(themeTag) }
            articles.add(
                ArticleItem(
                    id = UUID.randomUUID().toString(),
                    title = title,
                    sourceName = sourceName,
                    url = url,
                    summary = summary,
                    publishedDate = publishedDate,
                    themeTag = themeTag,
                    imageUrl = imageUrl
                )
            )
        }
        return articles
    }

    private fun detectThemeTag(title: String, summary: String): String {
        val text = "$title $summary".lowercase()
        return when {
            text.contains("océan") || text.contains("mer") || text.contains("corail") || text.contains("poisson") -> "oceans"
            text.contains("loup") || text.contains("animal") || text.contains("abeille") || text.contains("espèce") || text.contains("biodiversité") -> "animaux"
            text.contains("solaire") || text.contains("éolien") || text.contains("énergie") || text.contains("batterie") -> "energies"
            text.contains("forêt") || text.contains("arbre") || text.contains("bois") -> "forets"
            text.contains("glacier") || text.contains("climat") || text.contains("banquise") || text.contains("température") -> "climat"
            text.contains("satellite") || text.contains("nasa") || text.contains("espace") || text.contains("orbite") -> "espace"
            text.contains("déchet") || text.contains("compost") || text.contains("plastique") || text.contains("recyclage") -> "dechets"
            text.contains("numérique") || text.contains("data center") || text.contains("smartphone") -> "digital"
            else -> "general"
        }
    }

    private fun getDefaultThumbnailForTheme(themeTag: String): String {
        return when (themeTag.lowercase()) {
            "oceans" -> "https://images.unsplash.com/photo-1544551763-46a013bb70d5?w=400&q=80"
            "animaux", "wildlife" -> "https://images.unsplash.com/photo-1564349683136-77e08dba1ef6?w=400&q=80"
            "energies", "energy" -> "https://images.unsplash.com/photo-1466611653911-95081537e5b7?w=400&q=80"
            "forets", "forests" -> "https://images.unsplash.com/photo-1448375240586-882707db888b?w=400&q=80"
            "climat", "climate" -> "https://images.unsplash.com/photo-1483086431886-3590a88317fd?w=400&q=80"
            "espace", "space" -> "https://images.unsplash.com/photo-1451187580459-43490279c0fa?w=400&q=80"
            "dechets", "waste", "recycling" -> "https://images.unsplash.com/photo-1532996122724-e3c354a0b15b?w=400&q=80"
            else -> "https://images.unsplash.com/photo-1511497584788-87676104235f?w=400&q=80"
        }
    }

    private fun parseQuizFromGeminiResponse(
        responseJson: JSONObject,
        sourceArticles: List<ArticleItem>,
        isFrench: Boolean
    ): GeneratedAiQuiz? {
        val rawText = extractCandidateText(responseJson)
        val jsonObjStr = extractJsonSubstring(rawText, '{', '}') ?: rawText.trim()
        val root = try {
            JSONObject(jsonObjStr)
        } catch (e: Exception) {
            try {
                JSONObject(rawText.trim())
            } catch (e2: Exception) {
                Log.e(TAG, "parseQuizFromGeminiResponse: JSON parse error", e2)
                return null
            }
        }

        val defaultTitle = if (isFrench) {
            "Quiz : ${sourceArticles.firstOrNull()?.title?.take(32) ?: "Nature & Science"}"
        } else {
            "Quiz: ${sourceArticles.firstOrNull()?.title?.take(32) ?: "Nature & Science"}"
        }
        val quizTitle = root.optString("quizTitle", defaultTitle).ifBlank { defaultTitle }
        val questionsArray = root.optJSONArray("questions") ?: return null
        val questions = mutableListOf<Question>()

        for (i in 0 until questionsArray.length()) {
            val qObj = questionsArray.optJSONObject(i) ?: continue
            val questionText = qObj.optString("question").trim()
            val first = qObj.optString("firstResponse").trim()
            val second = qObj.optString("secondResponse").trim()
            val third = qObj.optString("thirdResponse").trim()
            val correct = qObj.optInt("correctAnswer", 1).coerceIn(1, 3)
            val hint = qObj.optString("hint").trim()
            val explanation = qObj.optString("explanation").trim()
            if (questionText.isNotEmpty() && first.isNotEmpty() && second.isNotEmpty() && third.isNotEmpty()) {
                questions.add(
                    Question(
                        question = questionText,
                        firstResponse = first,
                        secondResponse = second,
                        thirdResponse = third,
                        correctAnswer = correct,
                        hint = hint.ifEmpty { "Pensez aux équilibres naturels et aux données scientifiques." },
                        explanation = explanation
                    )
                )
            }
        }

        if (questions.isEmpty()) return null
        return GeneratedAiQuiz(
            title = quizTitle,
            sourceArticles = sourceArticles,
            questions = questions
        )
    }

    private fun extractJsonSubstring(text: String, openChar: Char, closeChar: Char): String? {
        val start = text.indexOf(openChar)
        val end = text.lastIndexOf(closeChar)
        if (start == -1 || end == -1 || end <= start) return null
        return text.substring(start, end + 1)
    }

    companion object {
        private const val TAG = "GeminiAiDataSource"
    }
}
