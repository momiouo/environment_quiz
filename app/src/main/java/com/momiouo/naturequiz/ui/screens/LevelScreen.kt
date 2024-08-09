package com.momiouo.naturequiz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.momiouo.naturequiz.R


@Composable
fun LevelScreen(themeId: String?) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        BackgroundImageMenu() //TODO write this in common
        LevelScreenContent()
        BackButton(modifier = Modifier.align(Alignment.BottomEnd))
        FlowerWaterDeco(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun LevelScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Text(
            text = "Niveau",
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp),
            color = Color.White
        )

        Button(
            onClick = { /* Handle button click */ },
            modifier = Modifier
                .width(275.dp)
                .height(IntrinsicSize.Min)
                .align(Alignment.CenterHorizontally)
                .padding(top = 70.dp)
                .clip(shape = CircleShape)
                .background(Color(0xFFFFA500)),
            colors = ButtonDefaults.buttonColors().copy(containerColor = Color(0xFFFFA500)),
            content = {
                Text(
                    text = "Niveau 1",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
        )

        // Buttons for niveau2 and niveau3 will be dynamiccaly added here later ...
    }


}

@Composable
fun BackButton(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.back_arrow),
        contentDescription = null,
        modifier = modifier
            .size(45.dp)
            .padding(8.dp)
    )
}

@Composable
fun FlowerWaterDeco(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.flower_water_deco),
        contentDescription = null,
        modifier = modifier
            .padding(top = 300.dp)
            .size(60.dp)
    )
}

@Preview
@Composable
fun PreviewThemeActivity() {
    LevelScreen(themeId)
}