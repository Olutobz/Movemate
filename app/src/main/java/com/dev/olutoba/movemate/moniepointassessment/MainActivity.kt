package com.dev.olutoba.movemate.moniepointassessment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dev.olutoba.movemate.R
import com.dev.olutoba.movemate.moniepointassessment.ui.theme.MoveMateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = getColor(R.color.purple_700)
            MoveMateTheme {
                MoveMateApp()
            }
        }
    }
}