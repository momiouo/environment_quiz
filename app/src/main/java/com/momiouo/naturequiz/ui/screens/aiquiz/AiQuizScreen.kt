package com.momiouo.naturequiz.ui.screens.aiquiz

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.momiouo.naturequiz.domain.model.ArticleItem
import com.momiouo.naturequiz.domain.model.GeneratedAiQuiz
import com.momiouo.naturequiz.domain.model.SavedAiQuiz
import com.momiouo.naturequiz.tools.Const
import com.momiouo.naturequiz.tools.getActivityOrNull
import com.momiouo.naturequiz.ui.common.BackgroundImage
import com.momiouo.naturequiz.ui.theme.Orange
import fr.momiouo.naturequiz.BuildConfig
import fr.momiouo.naturequiz.R
import java.net.URLEncoder

private val CardBackground = Color(0x88000000)
private val CardSelectedBackground = Color(0xB01B4332)
private val GreenTag = Color(0xFF40916C)
private val GoldBadge = Color(0xFFFFD166)

/**
 * Opens article URL directly if valid, or falls back to Google Search query.
 */
private fun openArticle(context: Context, url: String, title: String, sourceName: String) {
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
        Log.e("AiQuizScreen", "Error opening article: $url", e)
    }
}

@Composable
fun AiQuizScreen(
    viewModel: AiQuizViewModel = hiltViewModel(),
    navigateBack: () -> Unit,
    navigateToPlayQuiz: (theme: String, level: String) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val isSubscribed by viewModel.isSubscribed.collectAsStateWithLifecycle()
    val formattedPrice by viewModel.formattedPrice.collectAsStateWithLifecycle()
    val context = LocalContext.current

    var selectedTab by remember { mutableIntStateOf(0) }
    val hasReachedLimit = !isSubscribed && uiState.remainingFreeTries <= 0

    BackgroundImage(backgroundResource = R.drawable.our_mainbg) {
        // Requirement 1: If free quiz limit reached, do NOT load anything and just show the dedicated limit screen!
        if (hasReachedLimit) {
            LimitReachedScreen(
                priceText = formattedPrice ?: stringResource(R.string.paywall_default_price),
                onSubscribeClick = { viewModel.subscribeMonthly(context.getActivityOrNull()) },
                onRestoreClick = viewModel::restoreSubscription,
                onDebugUnlockClick = viewModel::activateDebugSubscription,
                navigateBack = navigateBack
            )
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                // Top Navigation Bar (PRO badge removed per user requirement)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.back_arrow),
                        contentDescription = "Back",
                        modifier = Modifier
                            .size(42.dp)
                            .clickable { navigateBack() }
                    )

                    Text(
                        text = stringResource(R.string.ai_quiz_theme),
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 32.sp),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f)
                    )

                    Spacer(modifier = Modifier.size(42.dp))
                }

                // Simple Mode Tabs: Articles | Saved Quizzes
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clip(CircleShape)
                        .background(Color(0x66000000))
                        .padding(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    TabPill(
                        text = stringResource(R.string.ai_tab_generate),
                        selected = selectedTab == 0,
                        modifier = Modifier.weight(1f),
                        onClick = { selectedTab = 0 }
                    )
                    TabPill(
                        text = stringResource(R.string.ai_tab_saved, uiState.savedQuizzes.size),
                        selected = selectedTab == 1,
                        modifier = Modifier.weight(1f),
                        onClick = { selectedTab = 1 }
                    )
                }

                if (selectedTab == 0) {
                    CreateQuizContent(
                        uiState = uiState,
                        onSelectTheme = viewModel::selectTheme,
                        onToggleArticle = viewModel::toggleArticleSelection,
                        onGenerateClicked = viewModel::generateQuizFromSelectedArticles,
                        onSaveQuizClicked = viewModel::saveCurrentQuizLocally,
                        onPlayQuizClicked = {
                            viewModel.saveAndPlayCurrentQuiz(navigateToPlayQuiz)
                        },
                        onOpenArticle = { url, title, source ->
                            openArticle(context, url, title, source)
                        }
                    )
                } else {
                    SavedQuizzesContent(
                        savedQuizzes = uiState.savedQuizzes,
                        onPlaySavedQuiz = { levelId ->
                            viewModel.playSavedQuiz(levelId, navigateToPlayQuiz)
                        },
                        onDeleteSavedQuiz = viewModel::deleteSavedQuiz
                    )
                }
            }
        }

        if (uiState.showPaywallDialog) {
            AiPaywallDialog(
                priceText = formattedPrice ?: stringResource(R.string.paywall_default_price),
                onSubscribeClick = {
                    viewModel.subscribeMonthly(context.getActivityOrNull())
                },
                onRestoreClick = viewModel::restoreSubscription,
                onDebugUnlockClick = viewModel::activateDebugSubscription,
                onDismiss = viewModel::dismissPaywall
            )
        }
    }
}

/**
 * Dedicated Limit Reached Screen:
 * If free limit is reached, nothing else is loaded and only this view is displayed.
 */
@Composable
private fun LimitReachedScreen(
    priceText: String,
    onSubscribeClick: () -> Unit,
    onRestoreClick: () -> Unit,
    onDebugUnlockClick: () -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = "Back",
                modifier = Modifier
                    .size(42.dp)
                    .clickable { navigateBack() }
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.ai_limit_reached_header),
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 32.sp),
                color = GoldBadge,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = stringResource(R.string.ai_limit_reached_tries),
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 22.sp),
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = stringResource(R.string.ai_limit_reached_message),
                color = Color(0xFFD8F3DC),
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                lineHeight = 22.sp
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = onSubscribeClick,
                colors = ButtonDefaults.buttonColors(containerColor = Orange),
                shape = CircleShape,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(54.dp)
            ) {
                Text(
                    text = stringResource(R.string.ai_subscribe_monthly_format, priceText),
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 19.sp),
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            TextButton(onClick = onRestoreClick) {
                Text(
                    text = stringResource(R.string.paywall_restore_button),
                    color = Color.LightGray,
                    fontSize = 13.sp
                )
            }

            if (BuildConfig.DEBUG) {
                Spacer(modifier = Modifier.height(6.dp))
                TextButton(onClick = onDebugUnlockClick) {
                    Text(
                        text = stringResource(R.string.paywall_debug_unlock),
                        color = GoldBadge,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
private fun TabPill(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(if (selected) Orange else Color.Transparent)
            .clickable { onClick() }
            .padding(vertical = 7.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun CreateQuizContent(
    uiState: AiQuizUiState,
    onSelectTheme: (String) -> Unit,
    onToggleArticle: (String) -> Unit,
    onGenerateClicked: () -> Unit,
    onSaveQuizClicked: () -> Unit,
    onPlayQuizClicked: () -> Unit,
    onOpenArticle: (url: String, title: String, source: String) -> Unit
) {
    val selectedCount = uiState.selectedArticleIds.size
    val displayedArticles = uiState.filteredArticles

    // Localized theme list: English by default, French if phone is French
    val themeList = listOf(
        AiQuizUiState.THEME_ALL to stringResource(R.string.ai_theme_all),
        "oceans" to stringResource(R.string.ai_theme_oceans),
        "animaux" to stringResource(R.string.ai_theme_animals),
        "energies" to stringResource(R.string.ai_theme_energy),
        "forets" to stringResource(R.string.ai_theme_forests),
        "climat" to stringResource(R.string.ai_theme_climate),
        "espace" to stringResource(R.string.ai_theme_space),
        "dechets" to stringResource(R.string.ai_theme_waste)
    )

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Theme selection list with "Tous" at the very beginning
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    themeList.forEach { (tag, label) ->
                        val isSelected = uiState.selectedThemeTag.equals(tag, ignoreCase = true)
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(if (isSelected) Orange else Color(0x66000000))
                                .border(1.dp, if (isSelected) Orange else Color(0x44FFFFFF), CircleShape)
                                .clickable { onSelectTheme(tag) }
                                .padding(horizontal = 14.dp, vertical = 7.dp)
                        ) {
                            Text(
                                text = label,
                                color = Color.White,
                                fontSize = 13.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                            )
                        }
                    }
                }
            }

            // Loading state indicator
            if (uiState.isSearchingArticles) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CircularProgressIndicator(color = Color.White, modifier = Modifier.size(24.dp))
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = stringResource(R.string.ai_loading_articles),
                            color = Color.White,
                            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
                        )
                    }
                }
            }

            if (uiState.isGeneratingQuiz) {
                item {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = CardBackground),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CircularProgressIndicator(color = Orange)
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = stringResource(R.string.ai_generating_quiz),
                                color = Color.White,
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }

            // Generated Quiz Card
            uiState.generatedQuiz?.let { generatedQuiz ->
                item {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color(0xD0143625)),
                        shape = RoundedCornerShape(18.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(2.dp, GoldBadge, RoundedCornerShape(18.dp))
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = stringResource(R.string.ai_quiz_ready_title),
                                color = GoldBadge,
                                style = MaterialTheme.typography.titleLarge.copy(fontSize = 26.sp)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = generatedQuiz.title,
                                color = Color.White,
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Button(
                                    onClick = onSaveQuizClicked,
                                    enabled = uiState.savedQuizLevelId == null,
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = GreenTag,
                                        disabledContainerColor = Color(0x6640916C)
                                    ),
                                    shape = CircleShape,
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(
                                        text = if (uiState.savedQuizLevelId != null) {
                                            stringResource(R.string.ai_quiz_saved_badge)
                                        } else {
                                            stringResource(R.string.ai_save_quiz_button)
                                        },
                                        color = Color.White,
                                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp)
                                    )
                                }

                                Button(
                                    onClick = onPlayQuizClicked,
                                    colors = ButtonDefaults.buttonColors(containerColor = Orange),
                                    shape = CircleShape,
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(
                                        text = stringResource(R.string.ai_play_quiz_button),
                                        color = Color.White,
                                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Article List (Clean, simplified, no article description, working Google Search redirection)
            items(displayedArticles, key = { it.id }) { article ->
                val isSelected = uiState.selectedArticleIds.contains(article.id)
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = if (isSelected) CardSelectedBackground else CardBackground
                    ),
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = if (isSelected) 2.dp else 1.dp,
                            color = if (isSelected) Orange else Color(0x33FFFFFF),
                            shape = RoundedCornerShape(14.dp)
                        )
                        .clickable { onToggleArticle(article.id) }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 14.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Check circle icon
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(CircleShape)
                                .background(if (isSelected) Orange else Color(0x44FFFFFF)),
                            contentAlignment = Alignment.Center
                        ) {
                            if (isSelected) {
                                Text(text = "✓", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                            }
                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = article.sourceName,
                                color = GreenTag,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = article.title,
                                color = Color.White,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        // Open article directly via URL or Google Search fallback
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(Color(0x33FFFFFF))
                                .clickable { onOpenArticle(article.url, article.title, article.sourceName) }
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.ai_open_link),
                                color = GoldBadge,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Large Bottom Button styled in the game's classic design
        Button(
            onClick = onGenerateClicked,
            enabled = !uiState.isGeneratingQuiz && selectedCount > 0,
            colors = ButtonDefaults.buttonColors(
                containerColor = Orange,
                disabledContainerColor = Color(0x55FFA500)
            ),
            shape = CircleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
        ) {
            Text(
                text = if (selectedCount == 0) {
                    stringResource(R.string.ai_generate_quiz_button_none)
                } else {
                    stringResource(R.string.ai_generate_quiz_button, selectedCount)
                },
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp)
            )
        }
    }
}

@Composable
private fun SavedQuizzesContent(
    savedQuizzes: List<SavedAiQuiz>,
    onPlaySavedQuiz: (Int) -> Unit,
    onDeleteSavedQuiz: (Int) -> Unit
) {
    if (savedQuizzes.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = CardBackground),
                shape = RoundedCornerShape(18.dp)
            ) {
                Text(
                    text = stringResource(R.string.ai_no_saved_quizzes),
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(24.dp)
                )
            }
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(savedQuizzes, key = { it.levelId }) { savedQuiz ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = CardBackground),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(
                            text = savedQuiz.title,
                            color = Color.White,
                            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = stringResource(
                                R.string.ai_questions_count,
                                savedQuiz.questionCount,
                                savedQuiz.sourcesSummary
                            ),
                            color = GreenTag,
                            fontSize = 12.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Button(
                                onClick = { onPlaySavedQuiz(savedQuiz.levelId) },
                                colors = ButtonDefaults.buttonColors(containerColor = Orange),
                                shape = CircleShape,
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = stringResource(R.string.ai_play_quiz_button),
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp)
                                )
                            }
                            TextButton(
                                onClick = { onDeleteSavedQuiz(savedQuiz.levelId) }
                            ) {
                                Text(
                                    text = stringResource(R.string.ai_delete_quiz),
                                    color = Color(0xFFFF8FA3),
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun AiPaywallDialog(
    priceText: String,
    onSubscribeClick: () -> Unit,
    onRestoreClick: () -> Unit,
    onDebugUnlockClick: () -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xF01B4332)),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, GoldBadge, RoundedCornerShape(20.dp))
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.paywall_title),
                    color = GoldBadge,
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 24.sp),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = stringResource(R.string.paywall_subtitle, Const.MAX_FREE_AI_QUIZ_TRIES),
                    color = Color.White,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(14.dp))

                Column(
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.paywall_feature_1),
                        color = Color(0xFFD8F3DC),
                        fontSize = 13.sp
                    )
                    Text(
                        text = stringResource(R.string.paywall_feature_2),
                        color = Color(0xFFD8F3DC),
                        fontSize = 13.sp
                    )
                    Text(
                        text = stringResource(R.string.paywall_feature_3),
                        color = Color(0xFFD8F3DC),
                        fontSize = 13.sp
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = onSubscribeClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Orange),
                    shape = CircleShape,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(
                        text = stringResource(R.string.paywall_subscribe_button, priceText),
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 17.sp)
                    )
                }

                if (BuildConfig.DEBUG) {
                    Spacer(modifier = Modifier.height(6.dp))
                    TextButton(onClick = onDebugUnlockClick) {
                        Text(
                            text = stringResource(R.string.paywall_debug_unlock),
                            color = GoldBadge,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextButton(onClick = onRestoreClick) {
                        Text(
                            text = stringResource(R.string.paywall_restore_button),
                            color = Color.LightGray,
                            fontSize = 12.sp
                        )
                    }
                    TextButton(onClick = onDismiss) {
                        Text(
                            text = stringResource(R.string.paywall_close_button),
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}
