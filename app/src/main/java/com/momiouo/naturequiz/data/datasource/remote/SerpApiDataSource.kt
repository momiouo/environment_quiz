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
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SerpApiDataSource @Inject constructor() {

    // Single SerpApi key for now
    private val apiKey: String = BuildConfig.SERPAPI_API_KEY.trim()

    /*
     * MULTI-KEY ROTATION (Commentée pour l'instant)
     * Pour activer la rotation avec plusieurs comptes gratuits SerpApi (ex: key1,key2,key3) :
     * Décommentez ces lignes et utilisez querySerpApiWithFailover ci-dessous.
     *
     * private val apiKeys: List<String> = BuildConfig.SERPAPI_API_KEY
     *     .split(",")
     *     .map { it.trim() }
     *     .filter { it.isNotEmpty() }
     * private val exhaustedKeys = ConcurrentHashMap.newKeySet<String>()
     * private fun getAvailableApiKey(): String? = apiKeys.firstOrNull { !exhaustedKeys.contains(it) }
     */

    private data class CachedSearch(
        val articles: List<ArticleItem>,
        val timestamp: Long
    )

    // In-memory cache to eliminate redundant SerpApi requests and minimize costs (12 hours TTL)
    private val searchCache = ConcurrentHashMap<String, CachedSearch>()
    private val CACHE_TTL_MS = 12 * 60 * 60 * 1000L // 12 hours TTL

    fun isConfigured(): Boolean = apiKey.isNotEmpty()

    suspend fun searchArticles(
        themeTag: String,
        language: String
    ): List<ArticleItem> = withContext(Dispatchers.IO) {
        if (!isConfigured()) {
            return@withContext emptyList()
        }

        val isFrench = language.lowercase().startsWith("fr")
        val cacheKey = "${themeTag.lowercase().trim()}_${if (isFrench) "fr" else "en"}"
        val now = System.currentTimeMillis()

        // Check cache before calling external API
        val cached = searchCache[cacheKey]
        if (cached != null && (now - cached.timestamp < CACHE_TTL_MS)) {
            return@withContext cached.articles
        }

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
                val limited = newsArticles.take(8)
                searchCache[cacheKey] = CachedSearch(limited, now)
                return@withContext limited
            }

            // Fallback to Google Search with news filter
            val organicNews = querySerpApi(
                engine = "google",
                query = query,
                gl = gl,
                hl = hl,
                themeTag = themeTag,
                isFrench = isFrench,
                extraParam = "&tbm=nws"
            )
            if (organicNews.isNotEmpty()) {
                val limited = organicNews.take(8)
                searchCache[cacheKey] = CachedSearch(limited, now)
                return@withContext limited
            }
            emptyList()
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

    /*
     * querySerpApiWithFailover (Commentée pour rotation multi-clés si réactivée) :
     *
     * private fun querySerpApiWithFailover(...) { ... }
     */

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

        val thumbnail = item.optString("thumbnail")
            .ifBlank { item.optJSONObject("thumbnail")?.optString("src") ?: "" }
            .ifBlank { item.optString("image") }
            .ifBlank { item.optJSONObject("image")?.optString("src") ?: "" }
            .ifBlank { getDefaultThumbnailForTheme(themeTag) }

        return ArticleItem(
            id = UUID.randomUUID().toString(),
            title = cleanTitle,
            sourceName = sourceName,
            url = link,
            summary = snippet.ifBlank { cleanTitle },
            publishedDate = date,
            themeTag = themeTag,
            imageUrl = thumbnail
        )
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

    private fun getSearchQuery(themeTag: String, isFrench: Boolean): String {
        val tag = themeTag.lowercase().trim()
        return when (tag) {
            "all", "tous", "custom", "" -> if (isFrench) "environnement nature science Futura Sciences" else "nature environment science NASA Nature"
            "oceans" -> if (isFrench) "océans biodiversité marine coraux science" else "oceans marine life marine biology coral science"
            "animaux", "wildlife" -> if (isFrench) "animaux faune sauvage biodiversité nature" else "wildlife animals conservation nature biodiversity"
            "energies", "energy" -> if (isFrench) "énergies renouvelables transition écologique solaire éolien" else "renewable energy solar wind clean energy transition"
            "forets", "forests" -> if (isFrench) "forêts déforestation biodiversité arbres écologie" else "forests trees conservation deforestation nature"
            "climat", "climate" -> if (isFrench) "climat réchauffement climatique cop météorologie" else "climate change global warming emissions atmosphere"
            "espace", "space" -> if (isFrench) "espace astronomie télescope nasa esa univers" else "space astronomy NASA ESA telescope cosmos"
            "dechets", "waste", "recycling" -> if (isFrench) "déchets recyclage pollution plastique économie circulaire" else "waste recycling plastic pollution circular economy"
            else -> "$themeTag ${if (isFrench) "science nature Futura" else "science nature"}"
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
