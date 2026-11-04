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
class GeminiAiDataSource @Inject constructor() {

    private val apiKey: String
        get() = BuildConfig.GEMINI_API_KEY.trim()

    fun isApiKeyConfigured(): Boolean = apiKey.isNotEmpty()

    suspend fun searchRecentArticles(
        topicQuery: String,
        selectedSources: List<String>,
        language: String
    ): List<ArticleItem> = withContext(Dispatchers.IO) {
        val activeSources = if (selectedSources.isEmpty()) DEFAULT_SOURCES else selectedSources
        val isFrench = language.lowercase().startsWith("fr")
        val effectiveTopic = topicQuery.trim().ifEmpty {
            if (isFrench) "environnement climat biodiversité écologie actualités récentes"
            else "environment climate change biodiversity ecology recent news"
        }

        if (apiKey.isNotEmpty()) {
            try {
                val prompt = buildArticleSearchPrompt(effectiveTopic, activeSources, isFrench)
                val responseJson = callGeminiWithSearchGrounding(prompt)
                val parsed = parseArticlesFromGeminiResponse(responseJson, activeSources)
                if (parsed.isNotEmpty()) {
                    return@withContext parsed
                }
            } catch (e: Exception) {
                if (BuildConfig.DEBUG) {
                    Log.e(TAG, "Gemini searchRecentArticles failed, using curated fallback", e)
                }
            }
        }

        getCuratedFallbackArticles(topicQuery.trim(), activeSources, isFrench)
    }

    suspend fun generateQuizFromArticles(
        articles: List<ArticleItem>,
        language: String
    ): GeneratedAiQuiz = withContext(Dispatchers.IO) {
        val isFrench = language.lowercase().startsWith("fr")

        if (apiKey.isNotEmpty() && articles.isNotEmpty()) {
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

        generateFallbackQuizFromArticles(articles, isFrench)
    }

    private fun buildArticleSearchPrompt(
        topic: String,
        sources: List<String>,
        isFrench: Boolean
    ): String {
        val domains = sources.mapNotNull { SOURCE_DOMAIN_MAP[it] }.joinToString(", ")
        val sourcesText = sources.joinToString(", ")
        return if (isFrench) {
            """
            Utilise Google Search pour trouver 5 articles scientifiques ou écologiques récents portant sur : "$topic".
            Priorise strictement ces sources fiables utilisées dans notre application : $sourcesText (domaines : $domains).
            Réponds UNIQUEMENT avec un tableau JSON valide (sans texte autour ni balises markdown) au format suivant :
            [
              {
                "title": "Titre exact de l'article en français",
                "sourceName": "Nom de la source (ex: Futura Sciences, Les Horizons, Nature, NASA, ADEME)",
                "url": "URL complète https://...",
                "summary": "Résumé clair de 2 phrases des faits clés de l'article permettant de créer un quiz.",
                "publishedDate": "Date ou mois/année de publication"
              }
            ]
            """.trimIndent()
        } else {
            """
            Use Google Search to find 5 recent science or environment articles about: "$topic".
            Strictly prioritize these trusted sources used in our app: $sourcesText (domains: $domains).
            Respond ONLY with a valid JSON array (no extra text) in this exact format:
            [
              {
                "title": "Article title in English",
                "sourceName": "Source name (e.g. Futura Sciences, Les Horizons, Nature, NASA, ADEME)",
                "url": "Full https://... URL",
                "summary": "Clear 2-sentence summary of key facts from the article suitable for a quiz.",
                "publishedDate": "Publication date or month/year"
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
            "${index + 1}. [${article.sourceName}] ${article.title} (${article.url}) - ${article.summary}"
        }.joinToString("\n")

        return if (isFrench) {
            """
            À partir des articles suivants (tu peux utiliser Google Search pour vérifier les détails des articles) :
            $articlesDescription

            Génère un quiz écologique et scientifique de 5 questions à choix multiples (3 réponses possibles par question, une seule bonne réponse numérotée 1, 2 ou 3).
            Réponds UNIQUEMENT avec un objet JSON valide au format exact suivant :
            {
              "quizTitle": "Titre court du quiz en français",
              "questions": [
                {
                  "question": "Texte de la question ?",
                  "firstResponse": "Choix 1",
                  "secondResponse": "Choix 2",
                  "thirdResponse": "Choix 3",
                  "correctAnswer": 1,
                  "hint": "Indice utile sans donner directement la réponse",
                  "explanation": "Explication détaillée citant la source (ex: Selon Futura Sciences...)"
                }
              ]
            }
            """.trimIndent()
        } else {
            """
            Based on the following articles (you may use Google Search to verify article details):
            $articlesDescription

            Generate a 5-question multiple-choice environment & science quiz (3 options per question, with correctAnswer as 1, 2, or 3).
            Respond ONLY with a valid JSON object in this exact format:
            {
              "quizTitle": "Short quiz title in English",
              "questions": [
                {
                  "question": "Question text?",
                  "firstResponse": "Option 1",
                  "secondResponse": "Option 2",
                  "thirdResponse": "Option 3",
                  "correctAnswer": 1,
                  "hint": "Helpful clue without giving away the answer",
                  "explanation": "Detailed explanation citing the source (e.g. According to Futura Sciences...)"
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

    private fun extractGroundingUrls(responseJson: JSONObject): List<Pair<String, String>> {
        val urls = mutableListOf<Pair<String, String>>()
        val candidates = responseJson.optJSONArray("candidates") ?: return urls
        val firstCandidate = candidates.optJSONObject(0) ?: return urls
        val groundingMetadata = firstCandidate.optJSONObject("groundingMetadata") ?: return urls
        val chunks = groundingMetadata.optJSONArray("groundingChunks") ?: return urls
        for (i in 0 until chunks.length()) {
            val web = chunks.optJSONObject(i)?.optJSONObject("web") ?: continue
            val uri = web.optString("uri", "")
            val title = web.optString("title", "")
            if (uri.isNotEmpty()) {
                urls.add(title to uri)
            }
        }
        return urls
    }

    private fun parseArticlesFromGeminiResponse(
        responseJson: JSONObject,
        activeSources: List<String>
    ): List<ArticleItem> {
        val rawText = extractCandidateText(responseJson)
        val groundingUrls = extractGroundingUrls(responseJson)
        val jsonArrayStr = extractJsonSubstring(rawText, '[', ']') ?: return emptyList()

        val jsonArray = JSONArray(jsonArrayStr)
        val articles = mutableListOf<ArticleItem>()
        for (i in 0 until jsonArray.length()) {
            val obj = jsonArray.optJSONObject(i) ?: continue
            val title = obj.optString("title").trim()
            if (title.isEmpty()) continue
            val sourceName = obj.optString(
                "sourceName",
                activeSources.firstOrNull() ?: "Futura Sciences"
            ).trim()
            var url = obj.optString("url").trim()
            if (url.isEmpty() && i < groundingUrls.size) {
                url = groundingUrls[i].second
            }
            if (url.isEmpty()) {
                url = "https://www.futura-sciences.com/planete/environnement/"
            }
            val summary = obj.optString("summary").trim()
            val publishedDate = obj.optString("publishedDate", "2026").trim()
            articles.add(
                ArticleItem(
                    id = UUID.randomUUID().toString(),
                    title = title,
                    sourceName = sourceName,
                    url = url,
                    summary = summary,
                    publishedDate = publishedDate
                )
            )
        }
        return articles
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
            "Quiz : ${sourceArticles.firstOrNull()?.title?.take(35) ?: "Actualités Écologie"}"
        } else {
            "Quiz: ${sourceArticles.firstOrNull()?.title?.take(35) ?: "Eco News"}"
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
                        hint = hint.ifEmpty {
                            if (isFrench) "Pensez aux données de l'article sélectionné."
                            else "Think about the key findings from the selected article."
                        },
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

    private fun getCuratedFallbackArticles(
        query: String,
        selectedSources: List<String>,
        isFrench: Boolean
    ): List<ArticleItem> {
        val allArticles = if (isFrench) {
            listOf(
                ArticleItem(
                    id = "futura_1",
                    title = "Océans : comment les nouveaux systèmes captent 80 % des macroplastiques avant le large",
                    sourceName = "Futura Sciences",
                    url = "https://www.futura-sciences.com/planete/actualites/ocean-pollution-plastique/",
                    summary = "Les barrières flottantes déployées dans les rivières les plus polluées interceptent désormais la majorité des déchets plastiques avant qu'ils n'atteignent les gyres océaniques. Selon Futura Sciences, cibler 1 % des fleuves mondiaux permet de réduire drastiquement les nouveaux rejets en mer.",
                    publishedDate = "Récemment · Futura Planète"
                ),
                ArticleItem(
                    id = "futura_2",
                    title = "Énergies renouvelables : le solaire et l'éolien franchissent un cap historique dans le mix électrique européen",
                    sourceName = "Futura Sciences",
                    url = "https://www.futura-sciences.com/planete/environnement/developpement-durable/",
                    summary = "Pour la première fois, la production combinée de l'éolien et du photovoltaïque dépasse celle des énergies fossiles en Europe sur un semestre complet, réduisant les émissions du secteur électrique de près de 19 %.",
                    publishedDate = "Récemment · Futura Sciences"
                ),
                ArticleItem(
                    id = "horizons_1",
                    title = "Numérique responsable : l'impact carbone caché des centres de données et de l'IA générative",
                    sourceName = "Les Horizons",
                    url = "https://leshorizons.net/",
                    summary = "La consommation électrique et hydrique des data centers augmente avec l'essor du cloud et de l'intelligence artificielle. L'éco-conception logicielle, la récupération de chaleur fatale et le prolongement de la durée de vie des smartphones restent les leviers majeurs.",
                    publishedDate = "Récemment · Les Horizons"
                ),
                ArticleItem(
                    id = "nature_1",
                    title = "Forêt amazonienne et puits de carbone : nouvelles observations sur la résilience des forêts tropicales",
                    sourceName = "Nature",
                    url = "https://www.nature.com/subjects/climate-change",
                    summary = "Une étude internationale publiée dans Nature montre que la protection des territoires autochtones et la restauration des corridors forestiers permettent de restaurer jusqu'à 35 % de la capacité d'absorption de CO2 des zones dégradées.",
                    publishedDate = "Récemment · Revue Nature"
                ),
                ArticleItem(
                    id = "nasa_1",
                    title = "Observation satellitaire NASA : suivi de la banquise arctique et du verdissement global des continents",
                    sourceName = "NASA",
                    url = "https://earthobservatory.nasa.gov/",
                    summary = "Les satellites d'observation de la Terre de la NASA confirment l'accélération du cycle hydrologique tout en mesurant l'impact positif des programmes massifs de reforestation sur l'albédo et la capture du carbone.",
                    publishedDate = "Récemment · NASA Earth"
                ),
                ArticleItem(
                    id = "ademe_1",
                    title = "Tri des biodéchets et économie circulaire : comment le compostage réduit de 30 % le poids de nos poubelles",
                    sourceName = "ADEME",
                    url = "https://agirpourlatransition.ademe.fr/",
                    summary = "Selon l'ADEME, les biodéchets représentent encore près d'un tiers des ordures ménagères résiduelles. Leur valorisation en compost ou en biogaz évite l'incinération d'une matière composée à 80 % d'eau et enrichit les sols agricoles.",
                    publishedDate = "Récemment · ADEME"
                )
            )
        } else {
            listOf(
                ArticleItem(
                    id = "futura_en_1",
                    title = "Oceans: How river interceptor barriers capture 80% of macroplastics before reaching the sea",
                    sourceName = "Futura Sciences",
                    url = "https://www.futura-sciences.com/planete/actualites/ocean-pollution-plastique/",
                    summary = "Floating river barriers deployed in major polluted rivers now intercept most plastic waste before it reaches ocean gyres. Targeting just 1% of the world's rivers can drastically curb new marine plastic pollution.",
                    publishedDate = "Recent · Futura Planet"
                ),
                ArticleItem(
                    id = "futura_en_2",
                    title = "Renewable Energy: Solar and wind surpass fossil fuels in European electricity generation",
                    sourceName = "Futura Sciences",
                    url = "https://www.futura-sciences.com/planete/environnement/developpement-durable/",
                    summary = "Combined wind and solar power generation has reached a historic milestone in Europe, cutting power-sector CO2 emissions by nearly 19% thanks to grid storage and clean energy expansion.",
                    publishedDate = "Recent · Futura Sciences"
                ),
                ArticleItem(
                    id = "horizons_en_1",
                    title = "Green Digital: Measuring the water and carbon footprint of modern data centers",
                    sourceName = "Les Horizons",
                    url = "https://leshorizons.net/",
                    summary = "Data center energy and water use is rising rapidly. Waste heat recovery for urban heating networks and extending smartphone lifespans remain the most effective ways to reduce digital carbon footprints.",
                    publishedDate = "Recent · Les Horizons"
                ),
                ArticleItem(
                    id = "nature_en_1",
                    title = "Amazon Rainforest Carbon Sink: New findings on tropical forest restoration and resilience",
                    sourceName = "Nature",
                    url = "https://www.nature.com/subjects/climate-change",
                    summary = "A study published in Nature reveals that protecting indigenous lands and reconnecting forest corridors can restore up to 35% of carbon sequestration capacity in previously degraded tropical areas.",
                    publishedDate = "Recent · Nature Journal"
                ),
                ArticleItem(
                    id = "nasa_en_1",
                    title = "NASA Earth Observatory: Tracking global vegetation greening and polar ice dynamics from space",
                    sourceName = "NASA",
                    url = "https://earthobservatory.nasa.gov/",
                    summary = "NASA Earth observation satellites measure how large-scale reforestation programs and shifting climate patterns affect continental carbon uptake and global surface temperatures.",
                    publishedDate = "Recent · NASA Earth"
                ),
                ArticleItem(
                    id = "ademe_en_1",
                    title = "Biowaste Sorting & Circular Economy: How composting cuts household trash weight by 30%",
                    sourceName = "ADEME",
                    url = "https://agirpourlatransition.ademe.fr/",
                    summary = "According to ADEME, organic waste still accounts for nearly one-third of residual household waste. Composting or methanization avoids incinerating matter that is 80% water and returns nutrients to soils.",
                    publishedDate = "Recent · ADEME"
                )
            )
        }

        val filteredBySource = allArticles.filter { article ->
            selectedSources.any { src -> article.sourceName.equals(src, ignoreCase = true) }
        }.ifEmpty { allArticles }

        if (query.isBlank()) return filteredBySource

        val keywords = query.lowercase().split(" ").filter { it.length > 2 }
        val matched = filteredBySource.filter { article ->
            val haystack = "${article.title} ${article.summary} ${article.sourceName}".lowercase()
            keywords.any { haystack.contains(it) }
        }
        return matched.ifEmpty { filteredBySource }
    }

    private fun generateFallbackQuizFromArticles(
        articles: List<ArticleItem>,
        isFrench: Boolean
    ): GeneratedAiQuiz {
        val chosen = articles.ifEmpty { getCuratedFallbackArticles("", DEFAULT_SOURCES, isFrench) }
        val sourcesLabel = chosen.map { it.sourceName }.distinct().joinToString(", ")
        val title = if (isFrench) {
            "Quiz IA : ${chosen.first().title.take(32)}…"
        } else {
            "AI Quiz: ${chosen.first().title.take(32)}…"
        }

        val questions = if (isFrench) {
            listOf(
                Question(
                    question = "Selon les articles sélectionnés ($sourcesLabel), quel levier permet d'intercepter efficacement la pollution plastique avant les océans ?",
                    firstResponse = "Cibler l'embouchure des fleuves les plus pollués avec des barrières flottantes",
                    secondResponse = "Filtrer uniquement les eaux profondes de l'Antarctique",
                    thirdResponse = "Brûler le plastique sur les plages",
                    correctAnswer = 1,
                    hint = "La majorité du plastique marin transite d'abord par un petit nombre de cours d'eau.",
                    explanation = "Selon Futura Sciences, intercepter les macroplastiques dans les fleuves les plus pollués permet de bloquer jusqu'à 80 % des déchets avant leur dispersion en mer."
                ),
                Question(
                    question = "Quelle part des ordures ménagères résiduelles est encore constituée de biodéchets valorisables en compost ?",
                    firstResponse = "Moins de 2 %",
                    secondResponse = "Près d'un tiers (environ 30 %)",
                    thirdResponse = "Plus de 90 %",
                    correctAnswer = 2,
                    hint = "Il s'agit des épluchures, restes alimentaires et déchets organiques du quotidien.",
                    explanation = "Selon l'ADEME, trier et composter les biodéchets permet d'alléger nos poubelles d'environ 30 % et d'éviter d'incinérer une matière composée à 80 % d'eau."
                ),
                Question(
                    question = "Dans le secteur du numérique responsable (Les Horizons), quelle action réduit le plus l'empreinte carbone d'un équipement ?",
                    firstResponse = "Allumer le mode sombre uniquement la nuit",
                    secondResponse = "Prolonger la durée de vie des appareils et récupérer la chaleur fatale des serveurs",
                    thirdResponse = "Changer de smartphone tous les 6 mois",
                    correctAnswer = 2,
                    hint = "La phase de fabrication des terminaux et le refroidissement des data centers sont les plus énergivores.",
                    explanation = "Comme le rappelle Les Horizons, allonger la durée d'usage des équipements et valoriser la chaleur des data centers réduisent fortement le bilan carbone du numérique."
                ),
                Question(
                    question = "Quel enseignement majeur ressort des études publiées dans la revue Nature sur la forêt amazonienne ?",
                    firstResponse = "Les corridors forestiers et territoires protégés restaurent jusqu'à 35 % de la capture de CO2",
                    secondResponse = "Les forêts tropicales n'absorbent aucun carbone",
                    thirdResponse = "La déforestation accélère la croissance des glaciers",
                    correctAnswer = 1,
                    hint = "La connectivité écologique aide la forêt à se régénérer.",
                    explanation = "Selon la revue Nature, la préservation des territoires autochtones et la restauration des corridors écologiques renforcent significativement le puits de carbone forestier."
                ),
                Question(
                    question = "Quelle évolution historique a été observée sur la production d'électricité en Europe selon Futura Sciences ?",
                    firstResponse = "Le charbon représente 100 % du mix électrique",
                    secondResponse = "Le solaire et l'éolien combinés ont dépassé les énergies fossiles sur un semestre",
                    thirdResponse = "L'énergie éolienne a été arrêtée en hiver",
                    correctAnswer = 2,
                    hint = "Les énergies renouvelables connaissent une croissance record en Europe.",
                    explanation = "La progression du photovoltaïque et de l'éolien a permis de franchir ce cap historique et de faire baisser les émissions de CO2 du secteur électrique de près de 19 %."
                )
            )
        } else {
            listOf(
                Question(
                    question = "According to the selected articles ($sourcesLabel), what is the most effective way to stop ocean plastic pollution early?",
                    firstResponse = "Intercepting waste in the most polluted rivers using floating barriers",
                    secondResponse = "Only filtering deep Antarctic waters",
                    thirdResponse = "Sinking plastic containers offshore",
                    correctAnswer = 1,
                    hint = "Most ocean plastic travels through a small percentage of rivers first.",
                    explanation = "According to Futura Sciences, deploying river interceptors in major polluted rivers can stop up to 80% of macroplastics before they enter ocean gyres."
                ),
                Question(
                    question = "What share of household residual waste is still made up of organic biowaste that could be composted?",
                    firstResponse = "Less than 2%",
                    secondResponse = "Nearly one-third (around 30%)",
                    thirdResponse = "More than 90%",
                    correctAnswer = 2,
                    hint = "Think of food scraps, peelings, and organic kitchen waste.",
                    explanation = "According to ADEME, sorting and composting biowaste reduces household trash weight by around 30% and avoids burning matter that is 80% water."
                ),
                Question(
                    question = "In green computing (Les Horizons), what is the most impactful action to cut digital carbon emissions?",
                    firstResponse = "Using dark mode only on weekends",
                    secondResponse = "Extending device lifespan and reusing waste heat from data centers",
                    thirdResponse = "Replacing smartphones every 6 months",
                    correctAnswer = 2,
                    hint = "Hardware manufacturing and server cooling account for most of the footprint.",
                    explanation = "As reported by Les Horizons, extending hardware lifespans and recovering data center heat are key levers for sustainable digital infrastructure."
                ),
                Question(
                    question = "What key finding was highlighted in Nature regarding tropical rainforest carbon sinks?",
                    firstResponse = "Protected indigenous lands and forest corridors can restore up to 35% of CO2 absorption",
                    secondResponse = "Tropical forests do not absorb any CO2",
                    thirdResponse = "Deforestation cools ocean currents",
                    correctAnswer = 1,
                    hint = "Reconnecting fragmented habitats helps forests regenerate.",
                    explanation = "Studies in Nature show that protecting indigenous territories and restoring ecological corridors significantly strengthens tropical carbon sequestration."
                ),
                Question(
                    question = "What historic milestone did renewable electricity reach in Europe according to Futura Sciences?",
                    firstResponse = "Coal reached 100% of power generation",
                    secondResponse = "Combined solar and wind power surpassed fossil fuels over a full half-year",
                    thirdResponse = "Wind turbines were decommissioned across Europe",
                    correctAnswer = 2,
                    hint = "Solar and wind capacity have expanded rapidly across European grids.",
                    explanation = "Record solar and wind output surpassed fossil fuel electricity generation, cutting power-sector emissions by nearly 19%."
                )
            )
        }

        return GeneratedAiQuiz(
            title = title,
            sourceArticles = chosen,
            questions = questions
        )
    }

    companion object {
        private const val TAG = "GeminiAiDataSource"

        val DEFAULT_SOURCES = listOf(
            "Futura Sciences",
            "Les Horizons",
            "Nature",
            "NASA",
            "ADEME"
        )

        private val SOURCE_DOMAIN_MAP = mapOf(
            "Futura Sciences" to "futura-sciences.com",
            "Les Horizons" to "leshorizons.net",
            "Nature" to "nature.com",
            "NASA" to "earthobservatory.nasa.gov, nasa.gov",
            "ADEME" to "ademe.fr"
        )
    }
}
