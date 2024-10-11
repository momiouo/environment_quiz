package com.momiouo.naturequiz.ui.screens.level

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.momiouo.naturequiz.ui.common.BackgroundImage
import com.momiouo.naturequiz.ui.common.CustomLargeButton
import com.momiouo.naturequiz.ui.theme.Orange
import fr.momiouo.naturequiz.R


@Composable
fun LevelScreen(
    levelViewModel: LevelViewModel = hiltViewModel(),
    themeId: Int?,
    navigateToQuestion: (Int, String) -> Unit
) {

    val levelUiState by levelViewModel.levelUiState.collectAsStateWithLifecycle()

    BackgroundImage(backgroundResource = R.drawable.our_mainbg_flower) {

        when (val levelState = levelUiState) {
            is LevelUiState.Loaded -> LevelScreenContent(
                themeId,
                levelState.levelNumber,
                navigateToQuestion
            )

            LevelUiState.Loading -> Text(text = stringResource(id = R.string.loading))
        }
    }
}

@Composable
fun LevelScreenContent(
    themeId: Int?,
    levelNumber: Int,
    navigateToQuestion: (Int, String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Text(
            text = themeId.toString() ?: "",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp),
            color = Color.White
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(levelNumber) {
                CustomLargeButton(
                    text = stringResource(R.string.niveau, it + 1),
                    buttonColor = Orange
                ) {
                    if (themeId != null) {
                        navigateToQuestion(themeId, (it + 1).toString())
                    }
                }
            }
        }


    }
}

@Preview
@Composable
fun PreviewThemeActivity() {
    LevelScreen(themeId = 1, navigateToQuestion = { _, _ -> })
}