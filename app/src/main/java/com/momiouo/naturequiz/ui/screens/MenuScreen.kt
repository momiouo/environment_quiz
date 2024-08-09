package com.momiouo.naturequiz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.momiouo.naturequiz.R

@Composable
fun MenuScreen(navigateToLevelScreen: (String) -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        BackgroundImageMenu() //TODO write this in common
        MenuScreenContent()
    }
}

@Composable
fun MenuScreenContent() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "Quiz",
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 20.dp)
            )
        }

        items(
            listOf(
                ButtonTheme("Random", R.drawable.randombackground),
                ButtonTheme("Les Bases", R.drawable.basicsbackground),
                ButtonTheme("Les Chiffres Clés", R.drawable.keydatabackground),
                ButtonTheme("Les Animaux", R.drawable.animalsbackground),
                ButtonTheme("Les Tops News", R.drawable.topnewsbackground),
                ButtonTheme("Digital", R.drawable.digitalbackground),
                ButtonTheme("Le Tri et la Décomposition", R.drawable.sortingbackground),
                ButtonTheme("Climate Change", R.drawable.climatechangebackground),
            )
        ) { btnObj ->
            Box(modifier = Modifier
                .clickable { }
                .fillMaxWidth(.95f)
                .height(200.dp)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(),
                    painter = painterResource(id = btnObj.imgSrc),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth,
                    alignment = Alignment.Center
                )
                Text(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillParentMaxWidth(),
                    text = btnObj.text,
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }

        }

        item {
            Image(
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = null,
                modifier = Modifier
                    .size(45.dp)
                    .padding(top = 15.dp, bottom = 5.dp)
            )
        }
    }
}

@Composable
fun BackgroundImageMenu() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.our_mainbg),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
    }
}

data class ButtonTheme(
    val text: String,
    val imgSrc: Int
)

@Preview
@Composable
fun MenuScreenPreview() {
    MenuScreen { }
}