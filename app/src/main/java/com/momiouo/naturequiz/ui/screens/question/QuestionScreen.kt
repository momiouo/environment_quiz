package com.momiouo.naturequiz.ui.screens.question

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.momiouo.naturequiz.tools.Const
import com.momiouo.naturequiz.ui.common.BackgroundImage
import com.momiouo.naturequiz.ui.common.CustomLargeButton
import com.momiouo.naturequiz.ui.theme.Orange
import fr.momiouo.naturequiz.R
import kotlinx.coroutines.delay

@Composable
fun QuestionScreen(
    questionViewModel: QuestionViewModel = hiltViewModel(),
    themeId: String?,
    levelId: String?,
    positionId: Int?,
    navigateToNextQuestion: (theme: String, level: String, position: Int) -> Unit,
    navigateToEndScreen: () -> Unit
) {
    val context = LocalContext.current

    val questionUiState by questionViewModel.questionUiState.collectAsStateWithLifecycle()

    var isClueVisible by remember { mutableStateOf(false) }

    val saveIsGoodAnswer: (Boolean) -> Unit = {
        questionViewModel.saveIsGoodAnswer(it)
    }

    val decideButtonColor: (isCorrectAnswer: Boolean) -> Color = {
        when (val questionState = questionUiState) {
            is QuestionUiState.Loaded -> {
                if (questionState.isAnswered) {
                    if (it) Color.Green else Color.Red
                } else {
                    Orange
                }
            }

            QuestionUiState.Loading, QuestionUiState.Finished -> Orange
        }
    }

    val onHintClicked: () -> Unit = {
        questionViewModel.showInterstitialAd(
            context,
            Const.ADMOB_ID_INTERSTITIAL_CLUE
        ) { isClueVisible = true }
    }

    val removeClue: () -> Unit = {
        isClueVisible = false
    }

    //TODO Refacto handle this logic outside of the screen ...
    LaunchedEffect(questionUiState) {
        when (val questionState = questionUiState) {
            is QuestionUiState.Loaded -> {
                if (questionState.isAnswered) {
                    delay(1_000L)
                    val localNavigateToNextQuestion = {
                        navigateToNextQuestion(
                            themeId ?: "",
                            levelId ?: "",
                            positionId?.plus(1) ?: 0
                        )
                    }
                    if (positionId == 3 && !questionState.isAdLoading) {
                        Log.d("QuestionScreen", "QuestionScreen() called showInterstitialAd")
                        questionViewModel.showInterstitialAd(
                            context,
                            Const.ADMOB_ID_INTERSTITIAL_Q4_5,
                            localNavigateToNextQuestion
                        )
                    } else {
                        localNavigateToNextQuestion()
                    }
                }
            }

            QuestionUiState.Loading -> Unit
            QuestionUiState.Finished -> navigateToEndScreen()
        }
    }


    BackgroundImage(
        modifier = Modifier.clickable(enabled = isClueVisible) { removeClue() },
        backgroundResource = R.drawable.our_mainbg
    ) {
        when (val questionState = questionUiState) {
            is QuestionUiState.Loaded -> InGameScreenContent(
                themeId,
                questionState.question,
                questionState.isAnswered,
                positionId,
                isClueVisible,
                questionState.isAdLoading,
                saveIsGoodAnswer,
                decideButtonColor,
                onHintClicked,
                removeClue
            )

            QuestionUiState.Loading, QuestionUiState.Finished -> Text(text = stringResource(id = R.string.loading))
        }
    }
}

@Composable
fun InGameScreenContent(
    themeId: String?,
    question: QuestionUiModel?,
    isAnswered: Boolean,
    positionId: Int?,
    isClueVisible: Boolean,
    isAdLoading: Boolean,
    saveIsGoodAnswer: (Boolean) -> Unit,
    decideButtonColor: (Boolean) -> Color,
    onHintClicked: () -> Unit,
    removeClue: () -> Unit
) {

    Box(
        Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {

        LazyColumn(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            item {
                Text(
                    text = themeId ?: "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, bottom = 10.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White
                )
            }


            item {
                LeafQuestionFrame(
                    modifier = Modifier
                        .fillMaxWidth(),
                    question,
                    positionId
                )
            }


            //TODO uses items for each button...
            item {
                CustomLargeButton(
                    text = question?.firstResponse ?: "",
                    buttonColor = decideButtonColor(question?.correctAnswer == 1),
                    enabled = !isAnswered,
                ) {
                    if (isClueVisible) {
                        removeClue()
                    } else {
                        saveIsGoodAnswer(question?.correctAnswer == 1)
                    }
                }
            }


            item {
                CustomLargeButton(
                    text = question?.secondResponse ?: "",
                    buttonColor = decideButtonColor(question?.correctAnswer == 2),
                    enabled = !isAnswered,
                ) {
                    if (isClueVisible) {
                        removeClue()
                    } else {
                        saveIsGoodAnswer(question?.correctAnswer == 2)
                    }
                }
            }


            item {
                CustomLargeButton(
                    text = question?.thirdResponse ?: "",
                    buttonColor = decideButtonColor(question?.correctAnswer == 3),
                    enabled = !isAnswered,
                ) {
                    if (isClueVisible) {
                        removeClue()
                    } else {
                        saveIsGoodAnswer(question?.correctAnswer == 3)
                    }
                }
            }

        }

        HintPlank(
            modifier = Modifier.align(Alignment.BottomCenter),
            isVisible = isClueVisible,
            clueText = question?.hint ?: ""
        )
        HintButton(
            modifier = Modifier.align(Alignment.BottomEnd),
            isClueVisible = isClueVisible,
            onClick = onHintClicked
        )

        if (isAdLoading) {
            AdLoadingBlockingView()
        }
    }
}

@Composable
fun AdLoadingBlockingView() {
    Log.d("QuestionScreen", "AdLoadingView: showed")
    Box(
        Modifier
            .fillMaxSize()
            .clickable(
                enabled = true,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                //Block Click elsewhere
            }
    ) {
        CircularProgressIndicator(Modifier.align(Alignment.Center), color = Color.White)
    }
}

@Composable
fun LeafQuestionFrame(modifier: Modifier = Modifier, question: QuestionUiModel?, positionId: Int?) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.leaf_frame),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = modifier.height(200.dp)
        )

        //QUESTION BODY
        Text(
            text = question?.question ?: "",
            modifier = Modifier
                .padding(start = 30.dp, top = 5.dp, end = 30.dp, bottom = 10.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
        )

    }

}

//TODO In V2
@Composable
fun HintPlank(modifier: Modifier = Modifier, isVisible: Boolean, clueText: String) {

    Box(
        modifier = modifier.wrapContentSize(Alignment.Center),
    ) {
        Image(
            painter = painterResource(id = R.drawable.sign_frame_2),
            contentDescription = null,
            modifier = modifier
                .size(300.dp, 200.dp),
            contentScale = ContentScale.FillBounds,
            alpha = if (isVisible) 1f else 0f
        )

        Text(
            text = clueText,
            modifier = modifier
                .width(300.dp)
                .height(200.dp)
                .padding(top = 30.dp, bottom = 30.dp),
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 25.sp),
            color = if (isVisible) Color.White.copy(alpha = 1F) else Color.White.copy(alpha = 0F),
        )

    }
}

//TODO IN V2
@Composable
fun HintButton(modifier: Modifier = Modifier, isClueVisible: Boolean, onClick: () -> Unit) {
    var oneShotClicked by remember {
        mutableStateOf(false)
    }
    Image(
        painter = painterResource(id = R.drawable.interrogation_mark),
        contentDescription = null,
        modifier = modifier
            .size(35.dp)
            .clickable(enabled = !isClueVisible && !oneShotClicked) {
                oneShotClicked = true
                onClick()
            }
    )
}

@Preview
@Composable
private fun QuestionScreenPreview() {
    QuestionScreen(
        themeId = "Les bases",
        levelId = "",
        positionId = null,
        navigateToNextQuestion = { s: String, s1: String, i: Int -> },
        navigateToEndScreen = {}
    )
}