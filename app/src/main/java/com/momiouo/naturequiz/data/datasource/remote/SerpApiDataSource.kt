package com.momiouo.naturequiz.data.datasource.remote

import android.util.Log
import com.momiouo.naturequiz.domain.model.ArticleItem
import fr.momiouo.naturequiz.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SerpApiDataSource @Inject constructor() {

    private val apiKey: String = BuildConfig.SERPAPI_API_KEY.trim()

    fun isConfigured(): Boolean = apiKey.isNotEmpty()

    suspend fun searchArticles(
        themeTag: String,
        language: String
    ): List<ArticleItem> = withContext(Dispatchers.IO) {
        if (!isConfigured()) {
            return@withContext emptyList()
        }

        val isFrench = language.lowercase().startsWith("fr")
        val gl = if (isFrench) "fr" else "us"
        val hl = if (isFrench) "fr" else "en"
        val query = getSearchQuery(themeTag, isFrench)

        try {
            // First try Google News engine
            val newsArticles = querySerpApi(
                engine = "google_news",
                query = query,
                gl = gl,
                hl = hl,
                themeTag = themeTag,
                isFrench = isFrench
            )
            if (newsArticles.isNotEmpty()) {
                return@withContext newsArticles
            }

            // Fallback to Google Search with news filter
            return@withContext querySerpApi(
                engine = "google",
                query = query,
                gl = gl,
                hl = hl,
                themeTag = themeTag,
                isFrench = isFrench,
                extraParam = "&tbm=nws"
            )
        } catch (e: Exception) {
            if (BuildConfig.DEBUG) {
                Log.e(TAG, "SerpApi search failed for theme: $themeTag", e)
            }
            emptyList()
        }
    }

    private fun querySerpApi(
        engine: String,
        query: String,
        gl: String,
        hl: String,
        themeTag: String,
        isFrench: Boolean,
        extraParam: String = ""
    ): List<ArticleItem> {
        val encodedQuery = URLEncoder.encode(query, "UTF-8")
        val endpoint =
            "https://serpapi.com/search.json?engine=$engine&q=$encodedQuery&gl=$gl&hl=$hl&api_key=$apiKey$extraParam"

        val url = URL(endpoint)
        val connection = (url.openConnection() as HttpURLConnection).apply {
            requestMethod = "GET"
            connectTimeout = 15_000
            readTimeout = 20_000
            setRequestProperty("Accept", "application/json")
        }

        val responseCode = connection.responseCode
        if (responseCode !in 200..299) {
            if (BuildConfig.DEBUG) {
                Log.w(TAG, "SerpApi error HTTP $responseCode: ${connection.responseMessage}")
            }
            return emptyList()
        }

        val responseText = connection.inputStream.bufferedReader().use { it.readText() }
        val root = JSONObject(responseText)
        return parseSerpApiResponse(root, themeTag, isFrench)
    }

    private fun parseSerpApiResponse(
        root: JSONObject,
        themeTag: String,
        isFrench: Boolean
    ): List<ArticleItem> {
        val articles = mutableListOf<ArticleItem>()

        // 1. Check news_results
        val newsArray = root.optJSONArray("news_results")
        if (newsArray != null) {
            for (i in 0 until newsArray.length()) {
                val item = newsArray.optJSONObject(i) ?: continue
                val article = parseArticleObject(item, themeTag, isFrench)
                if (article != null) {
                    articles.add(article)
                }
            }
        }

        // 2. Fallback to organic_results if news is empty
        if (articles.isEmpty()) {
            val organicArray = root.optJSONArray("organic_results")
            if (organicArray != null) {
                for (i in 0 until organicArray.length()) {
                    val item = organicArray.optJSONObject(i) ?: continue
                    val article = parseArticleObject(item, themeTag, isFrench)
                    if (article != null) {
                        articles.add(article)
                    }
                }
            }
        }

        return articles
    }

    private fun parseArticleObject(
        item: JSONObject,
        themeTag: String,
        isFrench: Boolean
    ): ArticleItem? {
        val rawTitle = item.optString("title").trim()
        val link = item.optString("link").trim()
        if (rawTitle.isBlank() || link.isBlank()) return null

        val cleanTitle = cleanHtml(rawTitle)
        val snippet = cleanHtml(
            item.optString("snippet")
                .ifBlank { item.optString("date") }
        )

        // Resolve source name
        val sourceObj = item.optJSONObject("source")
        val sourceName = cleanHtml(
            sourceObj?.optString("name")
                ?: item.optString("source")
                .ifBlank { if (isFrench) "Futura Sciences" else "Nature" }
        )

        val date = item.optString("date").ifBlank { if (isFrench) "Récent" else "Recent" }

        return ArticleItem(
            id = UUID.randomUUID().toString(),
            title = cleanTitle,
            sourceName = sourceName,
            url = link,
            summary = snippet.ifBlank { cleanTitle },
            publishedDate = date,
            themeTag = themeTag
        )
    }

    private fun getSearchQuery(themeTag: String, isFrench: Boolean): String {
        return when (themeTag.lowercase()) {
            "oceans" -> if (isFrench) "océans biodiversité marine coraux science" else "oceans marine life marine biology coral science"
            "animaux", "wildlife" -> if (isFrench) "animaux faune sauvage biodiversité nature" else "wildlife animals conservation nature biodiversity"
            "energies", "energy" -> if (isFrench) "énergies renouvelables transition écologique solaire éolien" else "renewable energy solar wind clean energy transition"
            "forets", "forests" -> if (isFrench) "forêts déforestation biodiversité arbres écologie" else "forests trees conservation deforestation nature"
            "climat", "climate" -> if (isFrench) "climat réchauffement climatique cop météorologie" else "climate change global warming emissions atmosphere"
            "espace", "space" -> if (isFrench) "espace astronomie télescope nasa esa univers" else "space astronomy NASA ESA telescope cosmos"
            "dechets", "waste", "recycling" -> if (isFrench) "déchets recyclage pollution plastique économie circulaire" else "waste recycling plastic pollution circular economy"
            else -> if (isFrench) "environnement nature science Futura Sciences" else "nature environment science NASA Nature"
        }
    }

    private fun cleanHtml(text: String): String {
        return text
            .replace("&quot;", "\"")
            .replace("&amp;", "&")
            .replace("&#39;", "'")
            .replace("&apos;", "'")
            .replace("&lt;", "<")
            .replace("&gt;", ">")
            .replace("\\s+".toRegex(), " ")
            .trim()
    }

    companion object {
        private const val TAG = "SerpApiDataSource"
    }
}
