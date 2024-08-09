package com.momiouo.naturequiz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.momiouo.naturequiz.R
import kotlinx.coroutines.delay


@Composable
fun LoadingScreen(
    navigateToMenuScreen: () -> Unit
) {
    val loadingScreenDelay = 3_000L

    //Maybe not the best way to navigate ... should be controlled by a val in viewModel...
    LaunchedEffect(Unit) {
        delay(loadingScreenDelay)
        navigateToMenuScreen()
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        BackgroundImage()
        LoadingScreenContent()
        FlowerImage(modifier = Modifier.align(Alignment.BottomEnd))
    }
}

@Composable
fun LoadingScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LogoWithSpinAnimation()
    }
}

@Composable
fun LogoWithSpinAnimation() {
    var rotation by remember { mutableFloatStateOf(0f) }

    LaunchedEffect(Unit) {
        while (true) {
            rotation += 5f
            if (rotation >= 360f) {
                rotation = 0f
            }
            delay(16) // Adjust the speed of the rotation here
        }
    }

    Box(
        modifier = Modifier
            .size(200.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.load_earth),
            contentDescription = "",
            modifier = Modifier
                .graphicsLayer {
                    rotationZ = rotation
                },
            contentScale = ContentScale.Fit,
        )
    }
}

@Composable
fun BackgroundImage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.our_bg),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun FlowerImage(modifier: Modifier) {
    Image(
        painter = painterResource(R.drawable.flower_tree),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = modifier.size(200.dp)
    )
}

@Preview
@Composable
private fun LoadingScreenPreview() {
    LoadingScreen(navigateToMenuScreen = {})
}
