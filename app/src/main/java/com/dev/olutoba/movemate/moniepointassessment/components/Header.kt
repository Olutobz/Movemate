package com.dev.olutoba.movemate.moniepointassessment.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun Header(
    modifier: Modifier = Modifier,
    text: String,
    color: Color
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.titleMedium.copy(
            color = color,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
    )
}


@Composable
fun SubHeader(
    modifier: Modifier = Modifier,
    text: String,
    color: Color
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.titleSmall.copy(
            color = color,
            fontSize = 14.sp,
            fontWeight = FontWeight.W500
        )
    )
}