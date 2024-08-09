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
fun QuestionScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        BackgroundImageMenu() //TODO write this in common
        InGameScreenContent()
        HintPlank(modifier = Modifier.align(Alignment.BottomCenter))
        HintButton(modifier = Modifier.align(Alignment.BottomEnd))
    }
}

@Composable
fun InGameScreenContent() {
    Column(
        verticalArrangement = Arrangement.Top
    ) {

        //TITRE
        Text(
            text = "THEMES",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            textAlign = TextAlign.Center,
            fontSize = 45.sp,
//                    fontFamily = FontFamily(R.font.simsonfont),
            color = Color.White
        )

        LeafQuestionFrame(modifier = Modifier.fillMaxWidth())

    }
}

@Composable
fun LeafQuestionFrame(modifier: Modifier = Modifier) {
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
                text = "Question ? :",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 15.dp),
                fontSize = 23.sp,
                color = Color.White
                //                    fontFamily = FontFamily(R.font.simsonfont)
            )

            //QUESTION BODY
            Text(
                text = ".........",
                modifier = Modifier
                    //                .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                color = Color.White
                //                    fontFamily = FontFamily(R.font.simsonfont)
            )
        }
    }

}

@Composable
fun HintPlank(modifier: Modifier = Modifier) {
    // Invisible plank
    Image(
        painter = painterResource(id = R.drawable.sign_frame_2),
        contentDescription = null,
        modifier = modifier
            .size(300.dp, 200.dp),
//            .align(Alignment.BottomCenter),
        contentScale = ContentScale.FillBounds,
//        alpha = 0f // Invisible
    )

    // Invisible text on plank => TODO use a variable to show or not this text in a compose way
    Text(
        text = "Your Invisible Text",
        modifier = modifier
//            .align(Alignment.Center)
            .padding(30.dp),
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
//                fontFamily = FontFamily(R.font.simsonfont),
        textAlign = TextAlign.Center,
//        color = Color.Black.copy(alpha = 0F),//Invisible
//                alpha = 0f // Invisible
    )
}

@Composable
fun HintButton(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.interrogation_mark_disabled),
        contentDescription = null,
        modifier = modifier
            .size(35.dp)
//            .align(Alignment.BottomEnd)
    )
}

@Preview
@Composable
private fun QuestionScreenPreview() {
    QuestionScreen()
}