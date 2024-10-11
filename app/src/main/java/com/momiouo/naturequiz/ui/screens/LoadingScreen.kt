package com.momiouo.naturequiz.ui.screens

import androidx.compose.foundation.Image
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
import com.momiouo.naturequiz.ui.common.BackgroundImage
import fr.momiouo.naturequiz.R
import kotlinx.coroutines.delay


@Composable
fun LoadingScreen(
    navigateToMenuScreen: () -> Unit
) {
    val loadingScreenDelay = 1_500L

    //Maybe not the best way to navigate ... should be controlled by a val in viewModel...
    LaunchedEffect(Unit) {
        delay(loadingScreenDelay)
        navigateToMenuScreen()
    }


    BackgroundImage(backgroundResource = R.drawable.our_bg_branch) {
        LogoWithSpinAnimation(modifier = Modifier.align(Alignment.Center))
    }

}

@Composable
fun LogoWithSpinAnimation(modifier: Modifier = Modifier) {
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

    Image(
        painter = painterResource(R.drawable.load_earth),
        contentDescription = "",
        modifier = modifier
            .size(200.dp)
            .graphicsLayer {
                rotationZ = rotation
            },
        contentScale = ContentScale.Fit,
    )
}

@Preview
@Composable
private fun LoadingScreenPreview() {
    LoadingScreen(navigateToMenuScreen = {})
}
