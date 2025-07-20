package com.dev.olutoba.movemate.moniepointassessment.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.olutoba.movemate.R
import com.dev.olutoba.movemate.moniepointassessment.DetailState
import com.dev.olutoba.movemate.moniepointassessment.components.FadeIn
import com.dev.olutoba.movemate.moniepointassessment.components.Section
import com.dev.olutoba.movemate.moniepointassessment.components.SlideInHorizontalRTL
import com.dev.olutoba.movemate.moniepointassessment.components.SlideInUpContainer
import com.dev.olutoba.movemate.moniepointassessment.components.TrackingCard
import com.dev.olutoba.movemate.moniepointassessment.navigation.AnimatedAppBar
import com.dev.olutoba.movemate.moniepointassessment.ui.theme.OffWhite


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var currentState by remember { mutableStateOf(DetailState.INVISIBLE) }
    LaunchedEffect(key1 = currentState) {
        currentState = DetailState.VISIBLE
    }

    Column(Modifier.fillMaxSize()) {
        AnimatedAppBar(currentState = currentState) {
            HomeAppBar()
        }
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.background(OffWhite)
        ) {

            SlideInUpContainer(currentState == DetailState.VISIBLE) {
                Spacer(modifier = Modifier.height(16.dp))
                Section(modifier = Modifier, header = "Tracking") {
                    TrackingCard()
                }
            }

            SlideInUpContainer(
                currentState == DetailState.VISIBLE,
                enter = FadeIn + SlideInHorizontalRTL
            ) {
                Section(modifier = Modifier, header = "Available vehicles") {
                    LazyRow(
                        modifier = Modifier,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        item {
                            AvailableVehicleCard(
                                title = "Ocean freight",
                                subtitle = "International"
                            )
                        }

                        item {
                            AvailableVehicleCard(
                                title = "Cargo freight",
                                subtitle = "Reliable"
                            )
                        }

                        item {
                            AvailableVehicleCard(
                                title = "Air freight",
                                subtitle = "International"
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun AvailableVehicleCard(
    title: String,
    subtitle: String
) {
    Card(shape = RoundedCornerShape(16.dp)) {
        Box(Modifier.fillMaxHeight()) {
            Column(Modifier.padding(horizontal = 16.dp, vertical = 4.dp)) {
                Text(
                    modifier = Modifier.padding(end = 16.dp),
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp)
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.titleSmall.copy(fontSize = 12.sp)
                )
            }

            Image(
                modifier = Modifier
                    .height(height = 100.dp)
                    .width(width = 100.dp)
                    .offset(x = 5.dp, y = 10.dp)
                    .align(Alignment.BottomEnd),
                painter = painterResource(id = R.drawable.ship),
                contentDescription = null,
            )
        }
    }
}