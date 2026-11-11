package com.momiouo.naturequiz.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomLargeButton(
    modifier: Modifier = Modifier,
    text: String,
    buttonColor: Color,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    // Dynamic text sizing to avoid overflowing when answers are lengthy
    val answerFontSize = when {
        text.length > 55 -> 14.sp
        text.length > 35 -> 16.sp
        text.length > 20 -> 19.sp
        else -> 23.sp
    }
    val answerLineHeight = (answerFontSize.value * 1.25).sp

    Button(
        onClick = onClick,
        modifier = modifier
            .widthIn(min = 275.dp, max = 320.dp)
            .height(IntrinsicSize.Min)
            .padding(top = 16.dp)
            .clip(shape = CircleShape)
            .background(buttonColor),
        colors = ButtonDefaults.buttonColors().copy(containerColor = buttonColor),
        enabled = enabled,
        content = {
            Text(
                text = text,
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = answerFontSize,
                    lineHeight = answerLineHeight
                ),
                textAlign = TextAlign.Center,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
        }
    )
}