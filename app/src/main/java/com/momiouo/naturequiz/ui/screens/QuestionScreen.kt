package com.momiouo.naturequiz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.momiouo.naturequiz.ui.common.CustomLargeButton
import com.momiouo.naturequiz.ui.theme.Orange
import fr.momiouo.naturequiz.R
import kotlinx.coroutines.delay

@Composable
fun QuestionScreen(
    themeId: String?,
    levelId: String?,
    positionId: Int?,
    navigateToNextQuestion: (theme: String, level: String, position: Int) -> Unit,
    questionViewModel: QuestionViewModel = hiltViewModel(),
    navigateToEndScreen: () -> Unit
) {

    val questionUiState by questionViewModel.questionUiState.collectAsStateWithLifecycle()

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

    //TODO Refacto handle this logic outside of the screen ...
    LaunchedEffect(questionUiState) {
        when (val questionState = questionUiState) {
            is QuestionUiState.Loaded -> {
                if (questionState.isAnswered) {
                    delay(1_000L)
                    navigateToNextQuestion(themeId ?: "", levelId ?: "", positionId?.plus(1) ?: 0)
                }
            }

            QuestionUiState.Loading -> Unit
            QuestionUiState.Finished -> navigateToEndScreen()
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        BackgroundImageMenu() //TODO write this in common
        when (val questionState = questionUiState) {
            is QuestionUiState.Loaded -> InGameScreenContent(
                themeId,
                questionState.question,
                questionState.isAnswered,
                positionId,
                saveIsGoodAnswer,
                decideButtonColor,
            )

            QuestionUiState.Loading, QuestionUiState.Finished -> Text(text = stringResource(id = R.string.loading))
        }

//        HintPlank(modifier = Modifier.align(Alignment.BottomCenter))
        HintButton(modifier = Modifier.align(Alignment.BottomEnd))
    }
}

@Composable
fun InGameScreenContent(
    themeId: String?,
    question: QuestionUiModel?,
    isAnswered: Boolean,
    positionId: Int?,
    saveIsGoodAnswer: (Boolean) -> Unit,
    decideButtonColor: (Boolean) -> Color,
) {

    Column(
        verticalArrangement = Arrangement.Top
    ) {

        //TITRE
        Text(
            text = themeId ?: "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            textAlign = TextAlign.Center,
            fontSize = 45.sp,
            color = Color.White
        )

        LeafQuestionFrame(modifier = Modifier.fillMaxWidth(), question, positionId)

        CustomLargeButton(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = question?.firstResponse ?: "",
            buttonColor = decideButtonColor(question?.correctAnswer == 1),
            enabled = !isAnswered,
        ) {
            saveIsGoodAnswer(question?.correctAnswer == 1)
        }

        CustomLargeButton(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = question?.secondResponse ?: "",
            buttonColor = decideButtonColor(question?.correctAnswer == 2),
            enabled = !isAnswered,
        ) {
            saveIsGoodAnswer(question?.correctAnswer == 2)
        }

        CustomLargeButton(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = question?.thirdResponse ?: "",
            buttonColor = decideButtonColor(question?.correctAnswer == 3),
            enabled = !isAnswered,
        ) {
            saveIsGoodAnswer(question?.correctAnswer == 3)
        }

    }
}

@Composable
fun LeafQuestionFrame(modifier: Modifier = Modifier, question: QuestionUiModel?, positionId: Int?) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.leaf_frame),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = modifier
                .fillMaxWidth()
                .height(120.dp)
        )

        //QUESTION PRE-
        Column {
            Text(
                text = stringResource(R.string.question, positionId?.plus(1) ?: 0),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 15.dp),
                fontSize = 23.sp,
                color = Color.White
            )

            //QUESTION BODY
            Text(
                text = question?.question ?: "",
                modifier = Modifier
                    //                .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                color = Color.White
            )
        }
    }

}

//TODO In V2
//@Composable
//fun HintPlank(modifier: Modifier = Modifier) {
//    // Invisible plank
//    Image(
//        painter = painterResource(id = R.drawable.sign_frame_2),
//        contentDescription = null,
//        modifier = modifier
//            .size(300.dp, 200.dp),
//        contentScale = ContentScale.FillBounds,
//        alpha = 0f // Invisible
//    )
//
//    // Invisible text on plank => TODO use a variable to show or not this text in a compose way
//    Text(
//        text = "Your Invisible Text",
//        modifier = modifier
//            .padding(30.dp),
//        fontSize = 18.sp,
//        fontWeight = FontWeight.Bold,
//        textAlign = TextAlign.Center,
//        color = Color.Black.copy(alpha = 0F),//Invisible
//    )
//}

//TODO IN V2
@Composable
fun HintButton(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.interrogation_mark_disabled),
        contentDescription = null,
        modifier = modifier
            .size(35.dp)
    )
}

@Preview
@Composable
private fun QuestionScreenPreview() {
    QuestionScreen(
        "Les bases", "",
        positionId = null,
        navigateToNextQuestion = { s: String, s1: String, i: Int -> },
        navigateToEndScreen = {},
    )
}