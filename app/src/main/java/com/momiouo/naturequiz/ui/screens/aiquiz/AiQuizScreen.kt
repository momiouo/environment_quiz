package com.momiouo.naturequiz.ui.screens.aiquiz

import android.content.Intent
import android.net.Uri
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.text.font.FontFamily
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

private val ForestGreenDark = Color(0xFF1B4332)
private val ForestGreenCard = Color(0xDD1B4332)
private val AccentGreen = Color(0xFF40916C)
private val GoldBadge = Color(0xFFFFD166)

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

    BackgroundImage(backgroundResource = R.drawable.our_mainbg) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            // Top bar
            Row(
                modifier = Modifier.fillMaxWidth(),
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
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 34.sp),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )

                // Free tries / PRO pill
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(if (isSubscribed) GoldBadge else Orange)
                        .clickable { viewModel.openPaywall() }
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = if (isSubscribed) {
                            stringResource(R.string.ai_pro_active_badge)
                        } else {
                            stringResource(
                                R.string.ai_free_tries_badge,
                                uiState.remainingFreeTries,
                                Const.MAX_FREE_AI_QUIZ_TRIES
                            )
                        },
                        color = if (isSubscribed) Color.Black else Color.White,
                        fontSize = 12.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Tabs: Create AI Quiz | Saved Quizzes
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color(0x99000000))
                    .padding(4.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                TabButton(
                    text = stringResource(R.string.ai_tab_generate),
                    selected = selectedTab == 0,
                    modifier = Modifier.weight(1f),
                    onClick = { selectedTab = 0 }
                )
                TabButton(
                    text = stringResource(R.string.ai_tab_saved, uiState.savedQuizzes.size),
                    selected = selectedTab == 1,
                    modifier = Modifier.weight(1f),
                    onClick = { selectedTab = 1 }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            if (selectedTab == 0) {
                CreateAiQuizTabContent(
                    uiState = uiState,
                    onQueryChanged = viewModel::onSearchQueryChanged,
                    onToggleSource = viewModel::toggleSource,
                    onSearchClicked = viewModel::searchArticles,
                    onToggleArticle = viewModel::toggleArticleSelection,
                    onGenerateClicked = viewModel::generateQuizFromSelectedArticles,
                    onSaveQuizClicked = viewModel::saveCurrentQuizLocally,
                    onPlayQuizClicked = {
                        viewModel.saveAndPlayCurrentQuiz(navigateToPlayQuiz)
                    },
                    onOpenUrl = { url ->
                        try {
                            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                        } catch (_: Exception) {
                        }
                    }
                )
            } else {
                SavedAiQuizzesTabContent(
                    savedQuizzes = uiState.savedQuizzes,
                    onPlaySavedQuiz = { levelId ->
                        viewModel.playSavedQuiz(levelId, navigateToPlayQuiz)
                    },
                    onDeleteSavedQuiz = viewModel::deleteSavedQuiz
                )
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

@Composable
private fun TabButton(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(if (selected) Orange else Color.Transparent)
            .clickable { onClick() }
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 14.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun CreateAiQuizTabContent(
    uiState: AiQuizUiState,
    onQueryChanged: (String) -> Unit,
    onToggleSource: (String) -> Unit,
    onSearchClicked: () -> Unit,
    onToggleArticle: (String) -> Unit,
    onGenerateClicked: () -> Unit,
    onSaveQuizClicked: () -> Unit,
    onPlayQuizClicked: () -> Unit,
    onOpenUrl: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Source selector & search box card
            item {
                Card(
                    colors = CardDefaults.cardColors(containerColor = ForestGreenCard),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            text = stringResource(R.string.ai_sources_label),
                            color = Color.White,
                            fontSize = 14.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            uiState.availableSources.forEach { source ->
                                val isSelected = uiState.selectedSources.contains(source)
                                Box(
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .background(if (isSelected) AccentGreen else Color(0x55000000))
                                        .border(
                                            width = 1.dp,
                                            color = if (isSelected) Color.White else Color.Gray,
                                            shape = CircleShape
                                        )
                                        .clickable { onToggleSource(source) }
                                        .padding(horizontal = 12.dp, vertical = 6.dp)
                                ) {
                                    Text(
                                        text = if (isSelected) "✓ $source" else source,
                                        color = Color.White,
                                        fontSize = 13.sp,
                                        fontFamily = FontFamily.SansSerif,
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        OutlinedTextField(
                            value = uiState.searchQuery,
                            onValueChange = onQueryChanged,
                            placeholder = {
                                Text(
                                    text = stringResource(R.string.ai_search_hint),
                                    color = Color(0xCCFFFFFF),
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily.SansSerif
                                )
                            },
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedTextColor = Color.White,
                                unfocusedTextColor = Color.White,
                                focusedBorderColor = Orange,
                                unfocusedBorderColor = Color.White.copy(alpha = 0.6f),
                                cursorColor = Orange
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(
                            onClick = onSearchClicked,
                            enabled = !uiState.isSearchingArticles,
                            colors = ButtonDefaults.buttonColors(containerColor = Orange),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = stringResource(R.string.ai_search_button),
                                color = Color.White,
                                fontSize = 15.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        if (!uiState.isApiKeyConfigured && BuildConfig.DEBUG) {
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = stringResource(R.string.ai_api_key_note),
                                color = GoldBadge,
                                fontSize = 11.sp,
                                fontFamily = FontFamily.SansSerif
                            )
                        }
                    }
                }
            }

            // Generated Quiz Preview Card (if ready)
            if (uiState.isGeneratingQuiz) {
                item {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = ForestGreenCard),
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
                                fontSize = 15.sp,
                                fontFamily = FontFamily.SansSerif,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }

            uiState.generatedQuiz?.let { generatedQuiz ->
                item {
                    GeneratedQuizResultCard(
                        quiz = generatedQuiz,
                        isSaved = uiState.savedQuizLevelId != null,
                        onSaveClick = onSaveQuizClicked,
                        onPlayClick = onPlayQuizClicked
                    )
                }
            }

            // Articles section header
            item {
                if (uiState.isSearchingArticles) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CircularProgressIndicator(
                            color = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = stringResource(R.string.ai_searching_articles),
                            color = Color.White,
                            fontSize = 15.sp,
                            fontFamily = FontFamily.SansSerif
                        )
                    }
                } else {
                    Text(
                        text = stringResource(
                            R.string.ai_select_articles_prompt,
                            uiState.selectedArticleIds.size
                        ),
                        color = Color.White,
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 4.dp)
                    )
                }
            }

            items(uiState.articles, key = { it.id }) { article ->
                ArticleSelectionCard(
                    article = article,
                    isSelected = uiState.selectedArticleIds.contains(article.id),
                    onToggleSelect = { onToggleArticle(article.id) },
                    onOpenUrl = { onOpenUrl(article.url) }
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Sticky bottom Generate button
        Button(
            onClick = onGenerateClicked,
            enabled = !uiState.isGeneratingQuiz && uiState.articles.isNotEmpty(),
            colors = ButtonDefaults.buttonColors(containerColor = Orange),
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        ) {
            Text(
                text = stringResource(
                    R.string.ai_generate_quiz_button,
                    uiState.selectedArticleIds.size.coerceAtLeast(1)
                ),
                color = Color.White,
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun GeneratedQuizResultCard(
    quiz: GeneratedAiQuiz,
    isSaved: Boolean,
    onSaveClick: () -> Unit,
    onPlayClick: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xEE143625)),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, GoldBadge, RoundedCornerShape(16.dp))
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Text(
                text = stringResource(R.string.ai_quiz_ready_title),
                color = GoldBadge,
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = quiz.title,
                color = Color.White,
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = stringResource(
                    R.string.ai_questions_count,
                    quiz.questions.size,
                    quiz.sourceArticles.map { it.sourceName }.distinct().joinToString(", ")
                ),
                color = Color(0xFFD8F3DC),
                fontSize = 13.sp,
                fontFamily = FontFamily.SansSerif
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(
                    onClick = onSaveClick,
                    enabled = !isSaved,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSaved) AccentGreen else Color(0xFF2D6A4F),
                        disabledContainerColor = AccentGreen
                    ),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = if (isSaved) {
                            stringResource(R.string.ai_quiz_saved_badge)
                        } else {
                            stringResource(R.string.ai_save_quiz_button)
                        },
                        color = Color.White,
                        fontSize = 13.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold
                    )
                }

                Button(
                    onClick = onPlayClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Orange),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = stringResource(R.string.ai_play_quiz_button),
                        color = Color.White,
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun ArticleSelectionCard(
    article: ArticleItem,
    isSelected: Boolean,
    onToggleSelect: () -> Unit,
    onOpenUrl: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color(0xEE1B4332) else Color(0xCC112A1E)
        ),
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = if (isSelected) 2.dp else 1.dp,
                color = if (isSelected) Orange else Color.White.copy(alpha = 0.25f),
                shape = RoundedCornerShape(14.dp)
            )
            .clickable { onToggleSelect() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.Top
        ) {
            Checkbox(
                checked = isSelected,
                onCheckedChange = { onToggleSelect() },
                colors = CheckboxDefaults.colors(
                    checkedColor = Orange,
                    uncheckedColor = Color.White,
                    checkmarkColor = Color.White
                )
            )
            Spacer(modifier = Modifier.width(6.dp))
            Column(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(AccentGreen)
                            .padding(horizontal = 8.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = article.sourceName,
                            color = Color.White,
                            fontSize = 11.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Text(
                        text = article.publishedDate,
                        color = Color(0xFFB7E4C7),
                        fontSize = 11.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = article.title,
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = article.summary,
                    color = Color(0xFFE9F5EC),
                    fontSize = 13.sp,
                    fontFamily = FontFamily.SansSerif,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = stringResource(R.string.ai_read_article),
                    color = GoldBadge,
                    fontSize = 12.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { onOpenUrl() }
                )
            }
        }
    }
}

@Composable
private fun SavedAiQuizzesTabContent(
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
                colors = CardDefaults.cardColors(containerColor = ForestGreenCard),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.ai_no_saved_quizzes),
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
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
                    colors = CardDefaults.cardColors(containerColor = ForestGreenCard),
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(
                            text = savedQuiz.title,
                            color = Color.White,
                            fontSize = 17.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = stringResource(
                                R.string.ai_questions_count,
                                savedQuiz.questionCount,
                                savedQuiz.sourcesSummary
                            ),
                            color = Color(0xFFB7E4C7),
                            fontSize = 13.sp,
                            fontFamily = FontFamily.SansSerif
                        )
                        if (savedQuiz.createdAt.isNotEmpty()) {
                            Text(
                                text = savedQuiz.createdAt,
                                color = Color.LightGray,
                                fontSize = 11.sp,
                                fontFamily = FontFamily.SansSerif
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Button(
                                onClick = { onPlaySavedQuiz(savedQuiz.levelId) },
                                colors = ButtonDefaults.buttonColors(containerColor = Orange),
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = stringResource(R.string.ai_play_quiz_button),
                                    color = Color.White,
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            TextButton(
                                onClick = { onDeleteSavedQuiz(savedQuiz.levelId) }
                            ) {
                                Text(
                                    text = stringResource(R.string.ai_delete_quiz),
                                    color = Color(0xFFFF8FA3),
                                    fontFamily = FontFamily.SansSerif,
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
            colors = CardDefaults.cardColors(containerColor = ForestGreenDark),
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
                    fontSize = 22.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(R.string.paywall_subtitle, Const.MAX_FREE_AI_QUIZ_TRIES),
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(14.dp))

                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.paywall_feature_1),
                        color = Color(0xFFD8F3DC),
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    Text(
                        text = stringResource(R.string.paywall_feature_2),
                        color = Color(0xFFD8F3DC),
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    Text(
                        text = stringResource(R.string.paywall_feature_3),
                        color = Color(0xFFD8F3DC),
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))

                Button(
                    onClick = onSubscribeClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Orange),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(
                        text = stringResource(R.string.paywall_subscribe_button, priceText),
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold
                    )
                }

                if (BuildConfig.DEBUG) {
                    Spacer(modifier = Modifier.height(8.dp))
                    TextButton(onClick = onDebugUnlockClick) {
                        Text(
                            text = stringResource(R.string.paywall_debug_unlock),
                            color = GoldBadge,
                            fontSize = 13.sp,
                            fontFamily = FontFamily.SansSerif,
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
                            fontSize = 12.sp,
                            fontFamily = FontFamily.SansSerif
                        )
                    }
                    TextButton(onClick = onDismiss) {
                        Text(
                            text = stringResource(R.string.paywall_close_button),
                            color = Color.White,
                            fontSize = 12.sp,
                            fontFamily = FontFamily.SansSerif
                        )
                    }
                }
            }
        }
    }
}
