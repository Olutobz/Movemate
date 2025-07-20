package com.dev.olutoba.movemate.moniepointassessment.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.dev.olutoba.movemate.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoveMateCenterAppBar(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = White,
        ),
        title = {
            Text(
                title,
                style = MaterialTheme.typography
                    .titleMedium
                    .copy(fontWeight = FontWeight.SemiBold, color = White)
            )
        },
        navigationIcon = {
            IconButton(onClick = onClick) {
                Icon(
                    painterResource(id = R.drawable.ic_chevron_left),
                    contentDescription = null,
                    tint = White
                )
            }
        }
    )
}