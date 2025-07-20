package com.dev.olutoba.movemate.moniepointassessment.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dev.olutoba.movemate.R

val inter = FontFamily(
    Font(R.font.inter_thin, FontWeight.Thin),
    Font(R.font.inter_extra_light, FontWeight.ExtraLight),
    Font(R.font.inter_light, FontWeight.Light),
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_semi_bold, FontWeight.SemiBold),
    Font(R.font.inter_extra_bold, FontWeight.ExtraBold),
    Font(R.font.inter_black, FontWeight.Black),
)

// Set of Material typography styles to start with
val Typography: Typography = Typography(
    displaySmall = TextStyle( // was h5
        fontFamily = inter,
        fontSize = 20.sp,
        fontWeight = FontWeight.ExtraBold
    ),
    titleMedium = TextStyle( // was subtitle1
        fontFamily = inter,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal
    ),
    titleSmall = TextStyle( // was subtitle2
        fontFamily = inter,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    ),
    bodyLarge = TextStyle( // was body1
        fontFamily = inter,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal
    ),
    bodyMedium = TextStyle( // was body2
        fontFamily = inter,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    ),
    labelLarge = TextStyle( // was button
        fontFamily = inter,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    ),
    labelMedium = TextStyle( // was caption
        fontFamily = inter,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal
    ),
    labelSmall = TextStyle( // was overline
        fontFamily = inter,
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal
    )
)
