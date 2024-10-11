package com.momiouo.naturequiz.ui.screens.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.momiouo.naturequiz.ui.common.AdmobBanner
import com.momiouo.naturequiz.ui.common.BackgroundImage
import fr.momiouo.naturequiz.R

@Composable
fun MenuScreen(
    menuViewModel: MenuViewModel = hiltViewModel(),
    navigateToLevelScreen: (Int) -> Unit
) {
    BackgroundImage(backgroundResource = R.drawable.our_mainbg) {
        MenuScreenContent(
            menuItemList = menuViewModel.menuItemList,
            navigateToLevelScreen = navigateToLevelScreen
        )
    }
}

@Composable
fun MenuScreenContent(
    menuItemList: List<ButtonTheme>,
    navigateToLevelScreen: (Int) -> Unit
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
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 20.dp)
            )
        }

        items(menuItemList) { btnObj ->
            Box(modifier = Modifier
                .clickable {
                    navigateToLevelScreen(btnObj.id)
                }
                .height(200.dp)
                .padding(bottom = 20.dp)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center),
                    painter = painterResource(id = btnObj.imgSrc),
                    contentDescription = context.getString(R.string.menu_button_background),
                    contentScale = ContentScale.FillBounds,
                    alignment = Alignment.Center
                )
                Text(
                    modifier = Modifier
                        .padding(top = btnObj.topPadding.dp)
                        .fillParentMaxWidth(),
                    text = stringResource(id = btnObj.text),
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
            if (btnObj.id == 3) {
                AdmobBanner(modifier = Modifier.padding(bottom = 20.dp))
            }
        }
    }
}

@Preview
@Composable
fun MenuScreenPreview() {
    val menuItemList = listOf(
        ButtonTheme(
            1,
            R.string.les_bases,
            R.drawable.basicsbackground,
            10
        ),
        ButtonTheme(
            2,
            R.string.les_chiffres_cl_s,
            R.drawable.keydatabackground,
            25
        ),
        ButtonTheme(
            6,
            R.string.climate_change,
            R.drawable.climatechangebackground,
            15
        ),
        ButtonTheme(
            7,
            R.string.le_tri_et_la_d_composition,
            R.drawable.sortingbackground,
            140
        )
    )
    MenuScreenContent(
        menuItemList = menuItemList
    ) { }
}