package com.momiouo.naturequiz.ui.screens.menu

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ButtonTheme(
    val id: Int,
    @StringRes val text: Int,
    @DrawableRes val imgSrc: Int,
    val topPadding: Int,
)