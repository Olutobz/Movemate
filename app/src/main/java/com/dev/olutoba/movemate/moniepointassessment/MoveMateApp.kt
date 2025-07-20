package com.dev.olutoba.movemate.moniepointassessment

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dev.olutoba.movemate.moniepointassessment.navigation.MoveMateBottomBar
import com.dev.olutoba.movemate.moniepointassessment.navigation.MoveMateNavigation
import com.dev.olutoba.movemate.moniepointassessment.ui.rememberMoveMateAppState
import com.dev.olutoba.movemate.moniepointassessment.ui.theme.MoveMateTheme


@Composable
fun MoveMateApp() {
    MoveMateTheme {
        val appState = rememberMoveMateAppState()
        Scaffold(
            bottomBar = {
                if (appState.shouldShowBottomBar) {
                    MoveMateBottomBar(
                        items = appState.bottomBarTabs,
                        currentRoute = appState.currentRoute!!,
                        navigateToRoute = appState::navigateToBottomBarRoute
                    )
                }
            }
        ) { paddingValues ->
            MoveMateNavigation(
                navController = appState.navController,
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}
