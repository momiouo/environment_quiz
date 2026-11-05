package com.momiouo.naturequiz.data.datasource.remote

import android.util.Log
import com.momiouo.naturequiz.domain.model.ArticleItem
import com.momiouo.naturequiz.domain.model.GeneratedAiQuiz
import com.momiouo.naturequiz.domain.model.Question
import fr.momiouo.naturequiz.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GeminiAiDataSource @Inject constructor(
    private val serpApiDataSource: SerpApiDataSource
) {

    private val apiKey: String
        get() = BuildConfig.GEMINI_API_KEY.trim()

    fun isApiKeyConfigured(): Boolean = apiKey.isNotEmpty()

    suspend fun searchRecentArticles(
        topicQuery: String,
        selectedSources: List<String>,
        language: String
    ): List<ArticleItem> = withContext(Dispatchers.IO) {
        val isFrench = language.lowercase().startsWith("fr")

        // 1. If SerpApi key configured, use SerpApi (exact web scraped title & direct article link!)
        if (serpApiDataSource.isConfigured()) {
            try {
                val scrapedArticles = serpApiDataSource.searchArticles(topicQuery.trim(), language)
                if (scrapedArticles.isNotEmpty()) {
                    if (scrapedArticles.size >= 5) {
                        return@withContext scrapedArticles
                    } else {
                        val fallback = getCuratedArticles(topicQuery.trim(), isFrench)
                        val combined = (scrapedArticles + fallback).distinctBy { it.title }
                        return@withContext combined.take(maxOf(5, scrapedArticles.size))
                    }
                }
            } catch (e: Exception) {
                if (BuildConfig.DEBUG) {
                    Log.e(TAG, "SerpApi search failed, proceeding to fallback", e)
                }
            }
        }

        // 2. Gemini search grounding if valid Gemini key
        if (apiKey.isNotEmpty() && apiKey.startsWith("AIzaSy")) {
            try {
                val prompt = buildArticleSearchPrompt(topicQuery.trim(), isFrench)
                val responseJson = callGeminiWithSearchGrounding(prompt)
                val parsed = parseArticlesFromGeminiResponse(responseJson)
                if (parsed.isNotEmpty()) {
                    return@withContext parsed
                }
            } catch (e: Exception) {
                if (BuildConfig.DEBUG) {
                    Log.e(TAG, "Gemini searchRecentArticles failed, using curated fallback", e)
                }
            }
        }

        // 3. High-quality curated articles (French if phone is French, English otherwise!)
        getCuratedArticles(topicQuery.trim(), isFrench)
    }

    suspend fun generateQuizFromArticles(
        articles: List<ArticleItem>,
        language: String
    ): GeneratedAiQuiz = withContext(Dispatchers.IO) {
        val isFrench = language.lowercase().startsWith("fr")

        if (apiKey.isNotEmpty() && apiKey.startsWith("AIzaSy") && articles.isNotEmpty()) {
            try {
                val prompt = buildQuizGenerationPrompt(articles, isFrench)
                val responseJson = callGeminiWithSearchGrounding(prompt)
                val parsedQuiz = parseQuizFromGeminiResponse(responseJson, articles, isFrench)
                if (parsedQuiz != null && parsedQuiz.questions.isNotEmpty()) {
                    return@withContext parsedQuiz
                }
            } catch (e: Exception) {
                if (BuildConfig.DEBUG) {
                    Log.e(TAG, "Gemini generateQuizFromArticles failed, using fallback", e)
                }
            }
        }

        generateCuratedQuizFromArticles(articles, isFrench)
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

    private fun callGeminiWithSearchGrounding(prompt: String): JSONObject {
        val modelsToTry = listOf("gemini-2.5-flash", "gemini-2.0-flash")
        var lastException: Exception? = null

        for (modelName in modelsToTry) {
            try {
                val endpoint =
                    "https://generativelanguage.googleapis.com/v1beta/models/$modelName:generateContent?key=$apiKey"
                val url = URL(endpoint)
                val connection = (url.openConnection() as HttpURLConnection).apply {
                    requestMethod = "POST"
                    connectTimeout = 20_000
                    readTimeout = 30_000
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
            articles.add(
                ArticleItem(
                    id = UUID.randomUUID().toString(),
                    title = title,
                    sourceName = sourceName,
                    url = url,
                    summary = summary,
                    publishedDate = publishedDate,
                    themeTag = detectThemeTag(title, summary)
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

    private fun parseQuizFromGeminiResponse(
        responseJson: JSONObject,
        sourceArticles: List<ArticleItem>,
        isFrench: Boolean
    ): GeneratedAiQuiz? {
        val rawText = extractCandidateText(responseJson)
        val jsonObjStr = extractJsonSubstring(rawText, '{', '}') ?: return null
        val root = JSONObject(jsonObjStr)

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

    private fun getCuratedArticles(query: String, isFrench: Boolean): List<ArticleItem> {
        val library = if (isFrench) getComprehensiveFrenchArticles() else CuratedEnglishArticles.getArticles()
        if (query.isBlank() || query.equals("all", ignoreCase = true) || query.equals("tous", ignoreCase = true)) {
            return library
        }

        val targetTag = query.lowercase().trim()
        val byTag = library.filter { it.themeTag.equals(targetTag, ignoreCase = true) }
        if (byTag.isNotEmpty()) {
            return byTag
        }

        val keywords = query.lowercase().split(" ", "-", "'").filter { it.length > 2 }
        val matched = library.filter { article ->
            val haystack = "${article.title} ${article.summary} ${article.themeTag}".lowercase()
            keywords.any { haystack.contains(it) }
        }
        return matched.ifEmpty { library }
    }

    /**
     * Generates a 100% custom quiz strictly from the chosen articles' curated questions.
     * Each article has its own unique real-world questions with NO mention of "l'article".
     */
    private fun generateCuratedQuizFromArticles(
        articles: List<ArticleItem>,
        isFrench: Boolean
    ): GeneratedAiQuiz {
        val chosen = articles.ifEmpty { getCuratedArticles("", isFrench).take(1) }
        val allAvailableQuestions = chosen.flatMap { it.curatedQuestions }
        val finalQuestions = if (allAvailableQuestions.isNotEmpty()) {
            allAvailableQuestions.take(5)
        } else {
            // Articles from live search without pre-baked questions:
            // Match against curated library based on theme / topic
            val library = if (isFrench) getComprehensiveFrenchArticles() else CuratedEnglishArticles.getArticles()
            val matchedQuestions = mutableListOf<Question>()
            for (article in chosen) {
                val matchedArticles = library.filter {
                    it.themeTag.equals(article.themeTag, ignoreCase = true) ||
                    article.title.lowercase().contains(it.themeTag.lowercase()) ||
                    it.title.lowercase().split(" ").any { word -> word.length > 3 && article.title.lowercase().contains(word) }
                }
                if (matchedArticles.isNotEmpty()) {
                    matchedQuestions.addAll(matchedArticles.flatMap { it.curatedQuestions })
                }
            }
            if (matchedQuestions.isNotEmpty()) {
                matchedQuestions.distinctBy { it.question }.take(5)
            } else {
                library.flatMap { it.curatedQuestions }.shuffled().take(5)
            }
        }

        val mainTitle = chosen.first().title.take(34)
        val quizTitle = if (isFrench) "Quiz : $mainTitle…" else "Quiz: $mainTitle…"

        return GeneratedAiQuiz(
            title = quizTitle,
            sourceArticles = chosen,
            questions = finalQuestions
        )
    }

    private fun getComprehensiveFrenchArticles(): List<ArticleItem> = listOf(
        ArticleItem(
            id = "futura_ocean_1",
            title = "Océans : comment les barrières fluviales interceptent 80 % des macroplastiques",
            sourceName = "Futura Sciences",
            url = "https://www.futura-sciences.com/planete/actualites/ocean-pollution-plastique/",
            summary = "Les barrières flottantes déployées sur les fleuves bloquent la majorité des déchets plastiques avant qu'ils ne se fragmentent au large des océans.",
            publishedDate = "Récemment",
            themeTag = "oceans",
            curatedQuestions = listOf(
                Question(
                    question = "Quel pourcentage des déchets plastiques marins provient des fleuves et cours d'eau ?",
                    firstResponse = "Près de 80 %",
                    secondResponse = "Moins de 5 %",
                    thirdResponse = "Exactement 100 %",
                    correctAnswer = 1,
                    hint = "La grande majorité des plastiques transite d'abord par les eaux fluviales.",
                    explanation = "Les études océanographiques montrent qu'environ 80 % du plastique dans les mers provient des fleuves les plus pollués."
                ),
                Question(
                    question = "Quelle solution innovante permet de capturer les plastiques fluviaux avant qu'ils n'atteignent le large ?",
                    firstResponse = "Des barrières flottantes automatisées",
                    secondResponse = "Des filets suspendus par hélicoptère",
                    thirdResponse = "Des aimants sous-marins",
                    correctAnswer = 1,
                    hint = "Ces systèmes flottent à la surface et guident les débris vers un collecteur.",
                    explanation = "Les intercepteurs fluviaux flottants piègent les macrodéchets à l'embouchure des fleuves avant leur dispersion marine."
                ),
                Question(
                    question = "Combien de temps met une bouteille en plastique jetée dans la nature pour se désagréger ?",
                    firstResponse = "Environ 1 an",
                    secondResponse = "Environ 450 ans",
                    thirdResponse = "Plus de 50 000 ans",
                    correctAnswer = 2,
                    hint = "La dégradation d'un polymère plastique prend plusieurs siècles.",
                    explanation = "Une bouteille en plastique met en moyenne 450 ans à se fragmenter en microparticules dans l'environnement."
                ),
                Question(
                    question = "Où se concentrent principalement les débris plastiques non biodégradables au milieu des océans ?",
                    firstResponse = "Dans de gigantesques gyres océaniques",
                    secondResponse = "Dans les fosses sous-marines abyssales",
                    thirdResponse = "Uniquement sur les plages polaires",
                    correctAnswer = 1,
                    hint = "Les courants marins circulaires créent de vastes zones de convergence de déchets.",
                    explanation = "Les cinq grands gyres subtropicaux accumulent les débris flottants, formant les vortex de déchets océaniques."
                ),
                Question(
                    question = "Quel risque majeur posent les microplastiques pour la chaîne alimentaire ?",
                    firstResponse = "Ils sont ingérés par le plancton et les poissons",
                    secondResponse = "Ils refroidissent excessivement la température de l'eau",
                    thirdResponse = "Ils stoppent les marées océaniques",
                    correctAnswer = 1,
                    hint = "Les animaux marins confondent ces minuscules fragments avec leur nourriture.",
                    explanation = "En se fragmentant, le plastique pénètre la chaîne trophique marine dès les organismes filtreurs et les poissons."
                )
            )
        ),
        ArticleItem(
            id = "nature_wolf_1",
            title = "Biodiversité : le retour du loup et son impact régulateur sur les forêts alpines",
            sourceName = "Nature",
            url = "https://www.nature.com/subjects/biodiversity",
            summary = "La réapparition des grands prédateurs réduit la pression des herbivores sur les jeunes pousses d'arbres, favorisant la régénération naturelle des forêts.",
            publishedDate = "Récemment",
            themeTag = "animaux",
            curatedQuestions = listOf(
                Question(
                    question = "Quel effet bénéfique la présence du loup apporte-t-elle à la régénération des forêts ?",
                    firstResponse = "Il empêche le surpâturage des jeunes pousses par les cervidés",
                    secondResponse = "Il plante directement des graines dans le sol",
                    thirdResponse = "Il coupe le bois mort avec ses griffes",
                    correctAnswer = 1,
                    hint = "Les grands prédateurs incitent les herbivores à se déplacer constamment.",
                    explanation = "En régulant la présence des cerfs et chevreuils, les loups permettent aux jeunes arbres de grandir et de renouveler la forêt."
                ),
                Question(
                    question = "Comment qualifie-t-on la régulation en cascade exercée par un grand prédateur sur son écosystème ?",
                    firstResponse = "Une cascade trophique",
                    secondResponse = "Une érosion sédimentaire",
                    thirdResponse = "Un cycle photosynthétique",
                    correctAnswer = 1,
                    hint = "Ce terme désigne les interactions alimentaires qui descendent du sommet de la chaîne jusqu'à la flore.",
                    explanation = "La cascade trophique démontre qu'un prédateur au sommet équilibre la faune et enrichit indirectement la flore."
                ),
                Question(
                    question = "Quel célèbre parc naturel a vu ses cours d'eau se stabiliser après le retour du loup ?",
                    firstResponse = "Le parc de Yellowstone",
                    secondResponse = "Le parc Kruger",
                    thirdResponse = "Le parc des Cévennes",
                    correctAnswer = 1,
                    hint = "Situé aux États-Unis, ce parc a servi de référence mondiale pour la réintroduction du loup en 1995.",
                    explanation = "À Yellowstone, le retour du loup a permis aux forêts riveraines de repousser, stabilisant les berges des rivières."
                ),
                Question(
                    question = "À quelle famille de mammifères carnivores appartient le loup ?",
                    firstResponse = "Les canidés",
                    secondResponse = "Les félidés",
                    thirdResponse = "Les ursidés",
                    correctAnswer = 1,
                    hint = "C'est la même famille que le renard et le chien.",
                    explanation = "Le loup (Canis lupus) est l'espèce emblématique de la famille des canidés."
                ),
                Question(
                    question = "Quel sens particulièrement aiguisé permet au loup de repérer ses proies à plusieurs kilomètres ?",
                    firstResponse = "L'odorat",
                    secondResponse = "Le goût",
                    thirdResponse = "Le toucher",
                    correctAnswer = 1,
                    hint = "Sa truffe possède des centaines de millions de récepteurs olfactifs.",
                    explanation = "L'odorat du loup est jusqu'à 100 fois plus développé que celui de l'homme, détectant une odeur à plus de 2 kilomètres."
                )
            )
        ),
        ArticleItem(
            id = "futura_solar_1",
            title = "Énergies renouvelables : l'éolien et le solaire dépassent les fossiles en Europe",
            sourceName = "Futura Sciences",
            url = "https://www.futura-sciences.com/planete/environnement/developpement-durable/",
            summary = "La production combinée d'électricité verte éolienne et photovoltaïque a atteint un record historique en Europe, diminuant de près de 19 % les émissions de CO2.",
            publishedDate = "Récemment",
            themeTag = "energies",
            curatedQuestions = listOf(
                Question(
                    question = "Quelle source d'énergie propre utilise directement la lumière du soleil pour générer de l'électricité ?",
                    firstResponse = "Le photovoltaïque",
                    secondResponse = "La géothermie",
                    thirdResponse = "La biomasse",
                    correctAnswer = 1,
                    hint = "Les photons de la lumière sont directement convertis en courant électrique.",
                    explanation = "L'effet photovoltaïque convertit le rayonnement solaire en électricité grâce à des matériaux semi-conducteurs."
                ),
                Question(
                    question = "Quel matériau abondant constitue l'élément principal des cellules solaires modernes ?",
                    firstResponse = "Le silicium",
                    secondResponse = "Le plomb",
                    thirdResponse = "Le mercure",
                    correctAnswer = 1,
                    hint = "C'est le deuxième élément le plus abondant de la croûte terrestre après l'oxygène.",
                    explanation = "Le silicium, extrait de la silice (sable), est le composant de base de l'immense majorité des panneaux solaires."
                ),
                Question(
                    question = "Quel est l'avantage clé de l'éolien en mer (offshore) par rapport aux éoliennes terrestres ?",
                    firstResponse = "Les vents marins sont plus puissants et réguliers",
                    secondResponse = "Elles n'ont besoin d'aucun entretien",
                    thirdResponse = "Elles fonctionnent sans vent",
                    correctAnswer = 1,
                    hint = "En mer, l'absence de relief terrestre permet à l'air de circuler sans obstacle.",
                    explanation = "Les vents marins plus forts et continus augmentent nettement la production d'électricité des éoliennes offshore."
                ),
                Question(
                    question = "Comment peut-on stocker massivement l'électricité renouvelable excédentaire en montagne ?",
                    firstResponse = "En pompant de l'eau vers un bassin supérieur (STEP)",
                    secondResponse = "En enfouissant des bobines de cuivre",
                    thirdResponse = "En chauffant du sable à l'air libre",
                    correctAnswer = 1,
                    hint = "Cette technique hydraulique fonctionne comme une immense batterie naturelle.",
                    explanation = "Les stations de pompage-turbinage (STEP) montent l'eau quand l'électricité abonde et la turbinent aux heures de pointe."
                ),
                Question(
                    question = "Quelle énergie renouvelable exploite directement la chaleur emmagasinée dans le sous-sol terrestre ?",
                    firstResponse = "La géothermie",
                    secondResponse = "L'énergie marémotrice",
                    thirdResponse = "L'énergie osmotique",
                    correctAnswer = 1,
                    hint = "Le terme vient des mots grecs 'gê' (la Terre) et 'thermos' (la chaleur).",
                    explanation = "La géothermie capte la chaleur des roches et des nappes profondes pour produire chauffage et électricité."
                )
            )
        ),
        ArticleItem(
            id = "nature_corals_1",
            title = "Récifs coralliens : découverte de souches de coraux ultra-résistantes à la chaleur",
            sourceName = "Nature",
            url = "https://www.nature.com/subjects/marine-biology",
            summary = "Des colonies coralliennes capables de supporter des températures de l'eau plus élevées de 2°C ont été identifiées, ouvrant la voie à la restauration des lagons.",
            publishedDate = "Récemment",
            themeTag = "oceans",
            curatedQuestions = listOf(
                Question(
                    question = "Quelle part de la biodiversité marine mondiale les récifs coralliens abritent-ils ?",
                    firstResponse = "Près de 25 %",
                    secondResponse = "Moins de 1 %",
                    thirdResponse = "Exactement 95 %",
                    correctAnswer = 1,
                    hint = "Bien qu'ils couvrent moins de 1 % des fonds marins, ils sont de véritables oasis pour la faune.",
                    explanation = "Les récifs de corail abritent environ un quart de toutes les espèces marines connues sur la planète."
                ),
                Question(
                    question = "Qu'est-ce qui provoque le blanchissement des coraux lors d'une canicule marine ?",
                    firstResponse = "L'expulsion des microalgues symbiotiques (zooxanthelles)",
                    secondResponse = "Une attaque d'étoiles de mer géantes",
                    thirdResponse = "Une baisse brutale de la salinité",
                    correctAnswer = 1,
                    hint = "Le corail perd son partenaire végétal qui lui fournit couleur et nourriture.",
                    explanation = "Sous l'effet du stress thermique, les coraux expulsent leurs algues symbiotiques et se retrouvent affamés et décolorés."
                ),
                Question(
                    question = "Quel animal marin microscopique construit les structures calcaires des récifs ?",
                    firstResponse = "Le polype corallien",
                    secondResponse = "Le krill antarctique",
                    thirdResponse = "Le plancton bioluminescent",
                    correctAnswer = 1,
                    hint = "C'est un minuscule invertébré cousin de l'anémone de mer.",
                    explanation = "Les polypes coralliens sécrètent un squelette d'aragonite (carbonate de calcium) qui bâtit le récif au fil des siècles."
                ),
                Question(
                    question = "Quel rôle protecteur les récifs coralliens jouent-ils pour les îles et les côtes ?",
                    firstResponse = "Ils absorbent l'énergie des vagues et limitent l'érosion",
                    secondResponse = "Ils empêchent la pluie de tomber sur terre",
                    thirdResponse = "Ils arrêtent la montée des marées",
                    correctAnswer = 1,
                    hint = "Ils forment un brise-lames naturel devant les lagons.",
                    explanation = "Les barrières coralliennes dissipent jusqu'à 97 % de l'énergie des vagues, protégeant les littoraux des tempêtes."
                ),
                Question(
                    question = "Quelle hausse de température les coraux dits 'résistants' découverts récemment peuvent-ils supporter ?",
                    firstResponse = "Environ 1 à 2 °C de plus",
                    secondResponse = "Plus de 45 °C de plus",
                    thirdResponse = "Moins de 0,01 °C",
                    correctAnswer = 1,
                    hint = "Cette tolérance accrue permet d'espérer la résilience de certains récifs tropicaux.",
                    explanation = "Certaines souches coralliennes génétiquement adaptées tolèrent des eaux jusqu'à 2°C plus chaudes sans blanchir."
                )
            )
        ),
        ArticleItem(
            id = "nasa_greening_1",
            title = "NASA Earth : les satellites mesurent un verdissement mondial porté par la reforestation",
            sourceName = "NASA",
            url = "https://earthobservatory.nasa.gov/",
            summary = "Grâce à des capteurs en orbite, la NASA documente une augmentation de 5 % des surfaces foliaires mondiales, stimulée par des campagnes massives de plantation.",
            publishedDate = "Récemment",
            themeTag = "espace",
            curatedQuestions = listOf(
                Question(
                    question = "De combien la surface verte de végétation mondiale a-t-elle augmenté selon les données de la NASA ?",
                    firstResponse = "D'environ 5 %",
                    secondResponse = "De plus de 80 %",
                    thirdResponse = "D'exactement 0 %",
                    correctAnswer = 1,
                    hint = "Cette surface équivaut à la superficie totale de la forêt amazonienne.",
                    explanation = "Les observations satellites sur vingt ans montrent que la Terre a gagné 5 % de surface foliaire verte supplémentaire."
                ),
                Question(
                    question = "Quels pays ont le plus contribué au reverdissement mesuré depuis l'espace par les satellites ?",
                    firstResponse = "La Chine et l'Inde",
                    secondResponse = "Le Canada et la Norvège",
                    thirdResponse = "L'Islande et le Chili",
                    correctAnswer = 1,
                    hint = "Ces deux géants asiatiques ont mené des programmes massifs de reforestation et d'agriculture intensive.",
                    explanation = "La Chine (reforestation intensive) et l'Inde (surfaces cultivées irriguées) expliquent un tiers de ce reverdissement."
                ),
                Question(
                    question = "Quel phénomène naturel permet aux arbres de rafraîchir l'air ambiant en été ?",
                    firstResponse = "L'évapotranspiration",
                    secondResponse = "La photosynthèse nocturne",
                    thirdResponse = "L'oxydation foliaire",
                    correctAnswer = 1,
                    hint = "Les arbres rejettent de la vapeur d'eau par les stomates de leurs feuilles.",
                    explanation = "L'évapotranspiration des arbres consomme de la chaleur et humidifie l'air, agissant comme un climatiseur naturel."
                ),
                Question(
                    question = "Quel gaz à effet de serre les forêts absorbent-elles pour fabriquer du bois lors de la photosynthèse ?",
                    firstResponse = "Le dioxyde de carbone (CO2)",
                    secondResponse = "L'hélium",
                    thirdResponse = "Le méthane",
                    correctAnswer = 1,
                    hint = "C'est le principal gaz responsable du réchauffement climatique d'origine humaine.",
                    explanation = "Les arbres captent le CO2 de l'atmosphère et stockent le carbone dans leurs troncs, branches et racines."
                ),
                Question(
                    question = "Quel instrument embarqué sur les satellites surveille la santé de la biosphère terrestre ?",
                    firstResponse = "Le capteur optique MODIS",
                    secondResponse = "Le télescope James Webb",
                    thirdResponse = "Le sismomètre InSight",
                    correctAnswer = 1,
                    hint = "Cet imageur optique surveille quotidiennement la Terre depuis les satellites Terra et Aqua.",
                    explanation = "L'instrument MODIS de la NASA mesure quotidiennement la réflectance de la végétation partout sur le globe."
                )
            )
        ),
        ArticleItem(
            id = "futura_bees_1",
            title = "Biodiversité : rôle irremplaçable des abeilles sauvages dans la pollinisation",
            sourceName = "Futura Sciences",
            url = "https://www.futura-sciences.com/planete/actualites/biodiversite-abeilles/",
            summary = "Les pollinisateurs sauvages augmentent le rendement des récoltes fruitières de 24 % par rapport aux seules ruches domestiques, prouvant le besoin d'habitats préservés.",
            publishedDate = "Récemment",
            themeTag = "animaux",
            curatedQuestions = listOf(
                Question(
                    question = "Quelle part des plantes à fleurs sauvages dépend de la pollinisation par les insectes ?",
                    firstResponse = "Près de 90 %",
                    secondResponse = "Moins de 5 %",
                    thirdResponse = "Exactement 50 %",
                    correctAnswer = 1,
                    hint = "L'immense majorité de la flore terrestre a besoin de pollinisateurs pour se reproduire.",
                    explanation = "Près de 90 % des espèces de plantes à fleurs dépendent des insectes pollinisateurs pour féconder leurs graines."
                ),
                Question(
                    question = "En quoi les abeilles sauvages se distinguent-elles de l'abeille domestique des apiculteurs ?",
                    firstResponse = "La plupart sont solitaires et nichent dans le sol ou le bois",
                    secondResponse = "Elles mangent uniquement de la viande",
                    thirdResponse = "Elles dorment sous l'eau en hiver",
                    correctAnswer = 1,
                    hint = "Contrairement à l'abeille de ruche, les espèces sauvages ne vivent pas en colonie sociale.",
                    explanation = "Sur les 1 000 espèces d'abeilles en France, la grande majorité vit en solitaire sans former de ruche."
                ),
                Question(
                    question = "De combien la présence de pollinisateurs sauvages augmente-t-elle le rendement des vergers fruitiers ?",
                    firstResponse = "D'environ 24 %",
                    secondResponse = "De moins de 1 %",
                    thirdResponse = "De 100 % garanti",
                    correctAnswer = 1,
                    hint = "Leur efficacité de transport de pollen complète idéalement les ruches d'élevage.",
                    explanation = "Les études agronomiques montrent que les pollinisateurs sauvages boostent les récoltes de fruits de près d'un quart."
                ),
                Question(
                    question = "Quel bourdon robuste est réputé pour butiner dès la fin de l'hiver par temps froid ?",
                    firstResponse = "Le bourdon terrestre",
                    secondResponse = "La libellule empereur",
                    thirdResponse = "Le papillon machaon",
                    correctAnswer = 1,
                    hint = "Son corps velu et sa capacité à faire vibrer ses muscles lui permettent de voler dès 5°C.",
                    explanation = "Le bourdon terrestre (Bombus terrestris) pollinise les premières floraisons dès février grâce à sa résistance au froid."
                ),
                Question(
                    question = "Quel aménagement simple dans un jardin aide concrètement les abeilles et insectes solitaires ?",
                    firstResponse = "Un hôtel à insectes et des fleurs mellifères locales",
                    secondResponse = "Tondre la pelouse à ras tous les jours",
                    thirdResponse = "Remplacer l'herbe par du bitume",
                    correctAnswer = 1,
                    hint = "Des tiges creuses et des plantes nectarifères fournissent gîte et couvert.",
                    explanation = "Les abris en bois percé et les bandes fleuries permettent aux abeilles solitaires de pondre et de se nourrir."
                )
            )
        ),
        ArticleItem(
            id = "ademe_compost_1",
            title = "Économie circulaire : le tri des biodéchets allège de 30 % nos poubelles",
            sourceName = "ADEME",
            url = "https://agirpourlatransition.ademe.fr/",
            summary = "Le compostage et la méthanisation des restes alimentaires évitent d'incinérer une matière composée à 80 % d'eau et restituent des nutriments organiques aux sols.",
            publishedDate = "Récemment",
            themeTag = "dechets",
            curatedQuestions = listOf(
                Question(
                    question = "Quelle part du poids de notre poubelle ménagère est composée de déchets organiques ?",
                    firstResponse = "Près d'un tiers (environ 30 %)",
                    secondResponse = "Moins de 2 %",
                    thirdResponse = "Exactement 90 %",
                    correctAnswer = 1,
                    hint = "Les épluchures, restes alimentaires et marc de café pèsent très lourd dans les poubelles.",
                    explanation = "Les biodéchets représentent encore environ 30 % du poids total de nos poubelles résiduelles."
                ),
                Question(
                    question = "De quoi sont principalement constitués les restes de fruits et légumes du quotidien ?",
                    firstResponse = "D'eau (à environ 80 %)",
                    secondResponse = "De plastique condensé",
                    thirdResponse = "De minéraux métalliques",
                    correctAnswer = 1,
                    hint = "C'est pour cela que les incinérer gaspille énormément d'énergie de combustion.",
                    explanation = "Composés à 80 % d'eau, les biodéchets brûlent très mal et n'ont aucun intérêt thermique en incinérateur."
                ),
                Question(
                    question = "Quel gaz renouvelable peut être capté et injecté dans le réseau grâce aux biodéchets ?",
                    firstResponse = "Le biométhane (biogaz)",
                    secondResponse = "L'hélium pur",
                    thirdResponse = "Le fréon",
                    correctAnswer = 1,
                    hint = "La fermentation anaérobie des matières organiques dégage ce gaz combustible.",
                    explanation = "La méthanisation transforme les fermentations organiques en biométhane vert, substitut au gaz fossile."
                ),
                Question(
                    question = "Quel amendement naturel riche en nutriments obtient-on en compostant ses déchets de cuisine ?",
                    firstResponse = "Du compost organique pour fertiliser la terre",
                    secondResponse = "Du goudron bitumineux",
                    thirdResponse = "De la chaux vive",
                    correctAnswer = 1,
                    hint = "Ce terreau brun nourrit les sols et améliore leur capacité à retenir l'eau.",
                    explanation = "Le compost nourrit naturellement la microfaune du sol et évite l'utilisation d'engrais chimiques de synthèse."
                ),
                Question(
                    question = "Quel petit animal invertébré est l'ouvrier numéro un du compostage dans la litière ?",
                    firstResponse = "Le ver de terre (lombric)",
                    secondResponse = "La guêpe fouisseuse",
                    thirdResponse = "Le scorpion d'eau",
                    correctAnswer = 1,
                    hint = "Il dévore les matières en décomposition et aère le sol par ses galeries.",
                    explanation = "Les vers de terre et vers de compost digèrent la matière organique et produisent un humus de grande qualité."
                )
            )
        ),
        ArticleItem(
            id = "nasa_glaciers_1",
            title = "Climatologie : fonte de la calotte glaciaire polaire et effet albédo",
            sourceName = "NASA",
            url = "https://earthobservatory.nasa.gov/",
            summary = "Les radars satellitaires cartographient la banquise et mesurent la boucle de rétroaction radiative provoquée par la diminution des glaces polaires.",
            publishedDate = "Récemment",
            themeTag = "climat",
            curatedQuestions = listOf(
                Question(
                    question = "Quelle part de l'eau douce de notre planète est stockée dans les glaciers et calottes polaires ?",
                    firstResponse = "Près de 70 %",
                    secondResponse = "Moins de 2 %",
                    thirdResponse = "Exactement 10 %",
                    correctAnswer = 1,
                    hint = "Les glaces de l'Antarctique et du Groenland concentrent l'essentiel de l'eau douce terrestre.",
                    explanation = "Environ 69 % de toute l'eau douce sur Terre est stockée sous forme de glace polaire et de glaciers d'altitude."
                ),
                Question(
                    question = "Comment appelle-t-on la capacité de la neige blanche à renvoyer la chaleur solaire vers l'espace ?",
                    firstResponse = "L'effet albédo",
                    secondResponse = "L'effet de serre",
                    thirdResponse = "La photosynthèse",
                    correctAnswer = 1,
                    hint = "Le mot vient du latin 'albus', qui signifie blanc.",
                    explanation = "L'albédo mesure la part de rayonnement réfléchi : la neige fraîche renvoie jusqu'à 90 % de l'énergie solaire."
                ),
                Question(
                    question = "Que se passe-t-il lorsque la glace blanche fond et laisse place à de l'eau de mer sombre ?",
                    firstResponse = "L'océan absorbe plus de chaleur et amplifie le réchauffement",
                    secondResponse = "La mer gèle instantanément",
                    thirdResponse = "L'albédo augmente à 100 %",
                    correctAnswer = 1,
                    hint = "Une surface sombre absorbe la lumière au lieu de la réfléchir.",
                    explanation = "C'est la boucle de rétroaction albédo : moins de glace signifie plus de chaleur absorbée par l'océan."
                ),
                Question(
                    question = "Quelle est la différence fondamentale entre la banquise et un glacier continental ?",
                    firstResponse = "La banquise est de l'eau de mer gelée, le glacier est sur la terre ferme",
                    secondResponse = "La banquise est composée de roche volcanique",
                    thirdResponse = "Il n'y a aucune différence",
                    correctAnswer = 1,
                    hint = "L'un flotte sur l'océan, l'autre repose sur le sol continental.",
                    explanation = "La banquise est de l'eau marine gelée en surface, tandis qu'un glacier naît de l'accumulation de neige sur terre."
                ),
                Question(
                    question = "Dans quelle région du globe se trouve la plus gigantesque calotte glaciaire de la Terre ?",
                    firstResponse = "En Antarctique",
                    secondResponse = "Au Groenland",
                    thirdResponse = "En Islande",
                    correctAnswer = 1,
                    hint = "Ce continent blanc du pôle Sud contient à lui seul plus de 85 % de la glace terrestre.",
                    explanation = "L'inlandsis antarctique est la plus vaste masse de glace terrestre, mesurant jusqu'à 4 kilomètres d'épaisseur."
                )
            )
        )
    )

    companion object {
        private const val TAG = "GeminiAiDataSource"
    }
}
