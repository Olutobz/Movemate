package com.dev.olutoba.movemate.moniepointassessment.navigation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import com.dev.olutoba.movemate.moniepointassessment.DetailState
import com.dev.olutoba.movemate.moniepointassessment.components.AnimationDuration
import com.dev.olutoba.movemate.moniepointassessment.components.SlideInUpContainer


@Composable
fun AnimatedAppBar(currentState: DetailState, content: @Composable () -> Unit) {
    SlideInUpContainer(
        currentState == DetailState.VISIBLE,
        enter = fadeIn(animationSpec = tween(delayMillis = 500)) + slideInVertically(
            animationSpec = tween(
                AnimationDuration, easing = LinearEasing, delayMillis = 100
            )
        ),
        exitTransition = fadeOut() + slideOutVertically(
            animationSpec = tween(
                AnimationDuration, easing = LinearEasing, delayMillis = 100
            )
        )
    ) {
        content()
    }
}