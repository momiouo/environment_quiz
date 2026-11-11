package com.momiouo.naturequiz.ui.screens.end

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.momiouo.naturequiz.ui.common.BackgroundImage
import fr.momiouo.naturequiz.R
import java.net.URLEncoder

private val GreenScoreColor = Color(0xFF4CAF50)
private val OrangeScoreColor = Color(0xFFFF9800)
private val RedScoreColor = Color(0xFFE53935)
private val GoldBadge = Color(0xFFFFD166)
private val GreenTag = Color(0xFF40916C)

private fun openArticleUrl(context: Context, url: String, title: String, sourceName: String) {
    try {
        val targetUrl = if (url.startsWith("http://") || url.startsWith("https://")) {
            url
        } else {
            val query = URLEncoder.encode("$title $sourceName", "UTF-8")
            "https://www.google.com/search?q=$query"
        }
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(targetUrl)).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    } catch (e: Exception) {
        Log.e("EndScreen", "Error opening article url: $url", e)
    }
}

@Composable
fun EndScreen(
    endViewModel: EndViewModel = hiltViewModel(),
    theme: String,
    level: String,
    navigateToQuestionScreen: (theme: String, level: String) -> Unit,
    navigateToMenuScreen: () -> Unit
) {
    val endUiState by endViewModel.endUiState.collectAsStateWithLifecycle()

    LaunchedEffect(endUiState) {
        when (endUiState) {
            is EndUiState.Loaded -> endViewModel.resetIsGoodAnswerCounter()
            EndUiState.Loading -> Unit
        }
    }

    BackgroundImage(backgroundResource = R.drawable.our_mainbg_tree) {
        when (val endState = endUiState) {
            is EndUiState.Loaded -> EndScreenContent(
                theme = theme,
                level = level,
                endState = endState,
                navigateToMenuScreen = navigateToMenuScreen,
                navigateToQuestionScreen = navigateToQuestionScreen
            )
            EndUiState.Loading -> Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = stringResource(R.string.loading), color = Color.White)
            }
        }
    }
}

@Composable
fun EndScreenContent(
    theme: String,
    level: String,
    endState: EndUiState.Loaded,
    navigateToMenuScreen: () -> Unit,
    navigateToQuestionScreen: (theme: String, level: String) -> Unit
) {
    val context = LocalContext.current

    // Performance-based dynamic result color:
    // High (>=80%): Green, Moderate (50-79%): Orange, Low (<50%): Red
    val resultColor = when {
        endState.score >= 80 -> GreenScoreColor
        endState.score >= 50 -> OrangeScoreColor
        else -> RedScoreColor
    }

    val playStoreLink = "https://play.google.com/store/apps/details?id=fr.momiouo.naturequiz"
    val articleLink = endState.articleUrl.ifBlank {
        if (endState.articleTitle.isNotBlank()) {
            "https://www.google.com/search?q=" + URLEncoder.encode(endState.articleTitle, "UTF-8")
        } else {
            playStoreLink
        }
    }

    val shareMessage = if (endState.articleTitle.isNotBlank()) {
        stringResource(
            R.string.end_share_picker_message,
            endState.score,
            endState.articleTitle.take(55).trim(),
            playStoreLink,
            articleLink
        )
    } else {
        stringResource(
            R.string.end_share_picker_message_general,
            endState.score,
            playStoreLink
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 70.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Screen Title
            Text(
                text = stringResource(R.string.end_of_quiz),
                modifier = Modifier.padding(top = 18.dp),
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )

            // Dynamic Score Display
            Row(
                modifier = Modifier.padding(top = 28.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.scoretotal) + " ",
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 24.sp),
                    color = Color.White
                )
                Text(
                    text = "${endState.score}%",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    color = resultColor
                )
            }

            // Dynamic Performance Feedback Message (Green / Orange / Red)
            Text(
                text = stringResource(id = endState.text),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
                color = resultColor,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Native "Share via..." Picker Button
            val chooserTitle = stringResource(R.string.end_share_chooser_title)
            val appName = stringResource(R.string.app_name)
            Button(
                onClick = {
                    try {
                        val sendIntent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_SUBJECT, appName)
                            putExtra(Intent.EXTRA_TEXT, shareMessage)
                        }
                        val shareChooser = Intent.createChooser(sendIntent, chooserTitle).apply {
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        }
                        context.startActivity(shareChooser)
                    } catch (e: Exception) {
                        Log.e("EndScreen", "Error launching share picker", e)
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1B4332)),
                shape = CircleShape,
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .height(48.dp)
                    .border(1.dp, Color(0xFF40916C), CircleShape)
            ) {
                Text(
                    text = stringResource(R.string.end_share_button),
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp)
                )
            }

            // Source Article Preview Card (Article title, direct link, and Coil image)
            if (endState.articleTitle.isNotBlank()) {
                Spacer(modifier = Modifier.height(20.dp))

                Card(
                    colors = CardDefaults.cardColors(containerColor = Color(0x99000000)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color(0x33FFFFFF), RoundedCornerShape(16.dp))
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(
                            text = stringResource(R.string.end_source_article_title),
                            color = GoldBadge,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Featured Article Image loaded via Coil AsyncImage
                            val imageUrl = endState.articleImageUrl.ifBlank {
                                "https://images.unsplash.com/photo-1511497584788-87676104235f?w=400&q=80"
                            }
                            AsyncImage(
                                model = ImageRequest.Builder(context)
                                    .data(imageUrl)
                                    .crossfade(true)
                                    .error(R.drawable.randombackground)
                                    .placeholder(R.drawable.randombackground)
                                    .build(),
                                contentDescription = "Article image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(72.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .border(1.dp, Color(0x33FFFFFF), RoundedCornerShape(10.dp))
                            )

                            Spacer(modifier = Modifier.width(12.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = endState.sourceName.ifBlank { "Futura Sciences" },
                                    color = GreenTag,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = endState.articleTitle,
                                    color = Color.White,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )

                                Spacer(modifier = Modifier.height(6.dp))

                                // Direct link button to read original article
                                Box(
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .background(Color(0x33FFFFFF))
                                        .clickable {
                                            openArticleUrl(
                                                context,
                                                endState.articleUrl,
                                                endState.articleTitle,
                                                endState.sourceName
                                            )
                                        }
                                        .padding(horizontal = 10.dp, vertical = 4.dp)
                                ) {
                                    Text(
                                        text = stringResource(R.string.end_read_article),
                                        color = GoldBadge,
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        // Bottom Navigation Buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 6.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.undo),
                contentDescription = "Retry",
                modifier = Modifier
                    .size(54.dp)
                    .clickable {
                        navigateToQuestionScreen(theme, level)
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.home),
                contentDescription = "Return",
                modifier = Modifier
                    .size(54.dp)
                    .clickable {
                        navigateToMenuScreen()
                    }
            )
        }
    }
}
