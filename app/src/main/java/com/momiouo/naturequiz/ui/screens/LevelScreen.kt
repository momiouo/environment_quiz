package com.momiouo.naturequiz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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


@Composable
fun LevelScreen(
    themeId: String?,
    navigateToQuestion: (String, String) -> Unit,
    levelViewModel: LevelViewModel = hiltViewModel()
) {

    val levelUiState by levelViewModel.levelUiState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        BackgroundImageMenu() //TODO write this in common
        when (val levelState = levelUiState) {
            is LevelUiState.Loaded -> LevelScreenContent(
                themeId,
                levelState.levelNumber,
                navigateToQuestion
            )

            LevelUiState.Loading -> Text(text = stringResource(id = R.string.loading))
        }
        FlowerWaterDeco(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun LevelScreenContent(
    themeId: String?,
    levelNumber: Int,
    navigateToQuestion: (String, String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Text(
            text = themeId ?: "",
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
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

@Composable
fun FlowerWaterDeco(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.flower_water_deco),
        contentDescription = null,
        modifier = modifier
            .size(300.dp)
    )
}

@Preview
@Composable
fun PreviewThemeActivity() {
    LevelScreen(themeId = "", navigateToQuestion = { _, _ -> })
}