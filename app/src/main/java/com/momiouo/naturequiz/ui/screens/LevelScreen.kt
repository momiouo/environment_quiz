package com.momiouo.naturequiz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.momiouo.naturequiz.ui.common.CustomLargeButton
import com.momiouo.naturequiz.ui.theme.Orange
import fr.momiouo.naturequiz.R


@Composable
fun LevelScreen(
    themeId: String?,
    navigateToQuestion: (String, String) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        BackgroundImageMenu() //TODO write this in common
        LevelScreenContent(themeId, navigateToQuestion)
        FlowerWaterDeco(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun LevelScreenContent(
    themeId: String?,
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

        CustomLargeButton(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = stringResource(R.string.niveau_1),
            buttonColor = Orange
        ) {
            if (themeId != null) {
                navigateToQuestion(themeId, "1")
            }
        }

        // Buttons for niveau2 and niveau3 will be dynamiccaly added here later ...
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
    LevelScreen("") { _, _ -> }
}