package com.momiouo.naturequiz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import fr.momiouo.naturequiz.R

@Composable
fun AnswerQuestionScreen(
    answerQuestionViewModel: AnswerQuestionViewModel = hiltViewModel(),
) {

    val answerQuestionUiState by answerQuestionViewModel.questionUiState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        BackgroundImageMenu() //TODO write this in common

        Image(
            painter = painterResource(R.drawable.green_leaf),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.TopEnd)
        )

        when (val uiState = answerQuestionUiState) {
            is AnswerQuestionUiState.Loaded -> AnswerQuestionScreenContent(
                modifier = Modifier,
                uiState.question?.question ?: "",
                uiState.question?.explanation ?: ""
            )

            AnswerQuestionUiState.Loading -> CircularProgressIndicator(
                modifier = Modifier.align(
                    Alignment.Center
                ), color = Color.White
            )
        }



        Image(
            painter = painterResource(R.drawable.watering_tree_sm),
            contentDescription = null,
            modifier = Modifier
                .size(160.dp)
                .align(Alignment.BottomStart)
        )

        Image(
            painter = painterResource(R.drawable.red_leaf_forward),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp, 65.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
fun AnswerQuestionScreenContent(
    modifier: Modifier = Modifier,
    question: String,
    explanation: String
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Result",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Text(
            text = "Question : $question",
            modifier = Modifier.padding(top = 15.dp),
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Explication : $explanation",
            modifier = Modifier.padding(top = 5.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
private fun AnswerQuestionPreview() {
    AnswerQuestionScreenContent(question = "question ...", explanation = "explication ...")
}