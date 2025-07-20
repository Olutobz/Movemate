package com.dev.olutoba.movemate.moniepointassessment.ui.status

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.olutoba.movemate.R
import com.dev.olutoba.movemate.moniepointassessment.DetailState
import com.dev.olutoba.movemate.moniepointassessment.components.MoveMateButton
import com.dev.olutoba.movemate.moniepointassessment.components.SlideInUpContainer
import com.dev.olutoba.movemate.moniepointassessment.components.SlideInVertical
import com.dev.olutoba.movemate.moniepointassessment.ui.theme.Green100
import java.text.DecimalFormat


@Composable
fun StatusScreen(onHomeClicked: () -> Unit) {
    var currentState by remember { mutableStateOf(DetailState.INVISIBLE) }
    val amount = remember { Animatable(0f) }
    val targetValue = 1500

    LaunchedEffect(targetValue) {
        amount.animateTo(
            targetValue.toFloat(),
            animationSpec = tween(
                durationMillis = 1500,
                easing = LinearEasing
            )
        )
    }

    LaunchedEffect(key1 = currentState) {
        currentState = DetailState.VISIBLE
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SlideInUpContainer(currentState == DetailState.VISIBLE) {
            Image(
                painter = painterResource(id = R.drawable.movemate),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        SlideInUpContainer(
            currentState == DetailState.VISIBLE,
            enter = SlideInVertical + scaleIn(
                animationSpec = tween(500, easing = FastOutSlowInEasing)
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_box_package),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
        }

        SlideInUpContainer(
            currentState == DetailState.VISIBLE
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Total Estimated Amount",
                    style = MaterialTheme.typography.subtitle2.copy(fontSize = 24.sp)
                )

                AmountCounterText(amount.value)

                Text(
                    text = "This Amount is Estimated this will vary\nif your change your location or weight",
                    style = MaterialTheme.typography.subtitle2.copy(color = Color.Gray)
                )
            }
        }

        SlideInUpContainer(
            currentState == DetailState.VISIBLE
        ) {

            MoveMateButton(
                text = "Back to home",
                onClick = onHomeClicked,
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}

@Composable
fun AmountCounterText(amount: Float) {
    Row(verticalAlignment = Alignment.Bottom) {
        Text(
            text = formatAmount(amount),
            style = MaterialTheme.typography.subtitle2.copy(fontSize = 24.sp, color = Green100)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "USD", color = Green100, fontSize = 20.sp)
    }
}

@Preview
@Composable
fun PreviewStatusScreen() {
    StatusScreen {

    }
}

fun formatAmount(value: Number): String {
    val df = DecimalFormat("$##,###,##0")
    return df.format(value)
}
