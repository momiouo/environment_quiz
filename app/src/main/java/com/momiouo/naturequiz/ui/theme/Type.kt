package com.momiouo.naturequiz.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import fr.momiouo.naturequiz.R

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.simsonfont)),
        fontWeight = FontWeight.Normal,
        fontSize = 50.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp,
        textAlign = TextAlign.Center,
        color = Color.White
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.simsonfont)),
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Center,
        color = Color.White
    ),
//    labelSmall = TextStyle(
//        fontFamily = FontFamily(Font(R.font.simsonfont)),
//        fontWeight = FontWeight.Normal,
//        fontSize = 11.sp,
//        lineHeight = 16.sp,
//        letterSpacing = 0.5.sp
//    )
)