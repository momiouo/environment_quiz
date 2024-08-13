package com.momiouo.naturequiz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
        MenuScreenContent(navigateToLevelScreen)
    }
}

@Composable
fun MenuScreenContent(
    navigateToLevelScreen: (String) -> Unit
) {
    val context = LocalContext.current
    
    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            Text(
                text = stringResource(R.string.themes),
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
                ButtonTheme(context.getString(R.string.le_tri_et_la_d_composition), R.drawable.sortingbackground, 140),
                ButtonTheme(context.getString(R.string.les_bases), R.drawable.basicsbackground, 10),
                ButtonTheme(context.getString(R.string.les_chiffres_cl_s), R.drawable.keydatabackground, 25),
                ButtonTheme(context.getString(R.string.les_animaux), R.drawable.animalsbackground, 10),
                ButtonTheme(context.getString(R.string.les_tops_news), R.drawable.topnewsbackground, 10),
                ButtonTheme(context.getString(R.string.digital), R.drawable.digitalbackground, 10),
                ButtonTheme(context.getString(R.string.climate_change), R.drawable.climatechangebackground, 15),
            )
        ) { btnObj ->
            Box(modifier = Modifier
                .clickable {
                    navigateToLevelScreen(btnObj.text)
                }
                .height(200.dp)
                .padding(bottom = 20.dp)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center),
                    painter = painterResource(id = btnObj.imgSrc),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    alignment = Alignment.Center
                )
                Text(
                    modifier = Modifier
                        .padding(top = btnObj.textPadding.dp)
                        .fillParentMaxWidth(),
                    text = btnObj.text,
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }

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
    val imgSrc: Int,
    val textPadding: Int,
)

@Preview
@Composable
fun MenuScreenPreview() {
    MenuScreen { }
}