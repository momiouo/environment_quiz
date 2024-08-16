package com.momiouo.naturequiz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import fr.momiouo.naturequiz.R

@Composable
fun EndScreen(
    theme: String,
    level: String,
    navigateToQuestionScreen: (theme: String, level: String) -> Unit,
    navigateToMenuScreen: () -> Unit,
    endViewModel: EndViewModel = hiltViewModel()
) {

    val endUiState by endViewModel.endUiState.collectAsStateWithLifecycle()

    LaunchedEffect(endUiState) {
        when (endUiState) {
            is EndUiState.Loaded -> endViewModel.resetIsGoodAnswerCounter()
            EndUiState.Loading -> Unit
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        BackgroundImageMenu() //TODO write this in common
        when (val endState = endUiState) {
            is EndUiState.Loaded -> EndScreenContent(
                theme = theme,
                level = level,
                score = endState.score.toString(),
                text = stringResource(id = endState.text),
                navigateToMenuScreen = navigateToMenuScreen,
                navigateToQuestionScreen = navigateToQuestionScreen
            )

            EndUiState.Loading -> Text(text = stringResource(R.string.loading))
        }
    }
}

@Composable
fun EndScreenContent(
    theme: String,
    level: String,
    score: String,
    text: String,
    navigateToMenuScreen: () -> Unit,
    navigateToQuestionScreen: (theme: String, level: String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        //TODO name this Image and put them outside ...
        Image(
            painter = painterResource(id = R.drawable.tree),
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.BottomCenter)
                .padding(top = 5.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.home),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.BottomEnd)
                .padding(top = 5.dp)
                .clickable {
                    navigateToMenuScreen()
                }
        )
        Image(
            painter = painterResource(id = R.drawable.undo),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.BottomStart)
                .padding(top = 5.dp)
                .clickable {
                    navigateToQuestionScreen(theme, level)
                }
        )

        Column(
            modifier = Modifier
                .wrapContentHeight()
                .align(Alignment.TopCenter)
        ) {
            Text(
                text = stringResource(R.string.end_of_quiz),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 20.dp),
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )

            Text(
                text = stringResource(id = R.string.scoretotal) + score + "%",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 60.dp),
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White
            )

            Text(
                text = text,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 80.dp),
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Green,
                textAlign = TextAlign.Center
            )


        }

    }
}

@Preview
@Composable
private fun EndActivityPreview() {
    EndScreen(
        theme = "",
        level = "",
        navigateToQuestionScreen = { theme, level ->
        },
        navigateToMenuScreen = {}
    )
}