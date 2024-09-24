package com.example.core_design.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class StadiumoTypography {

    val h1: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = FontFamily.Default,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 38.sp,
        )
    val h2: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = FontFamily.Default,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 32.sp,
        )
    val h3: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = FontFamily.Default,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 30.sp,
        )
}

internal val LocalStadiumoTypography = staticCompositionLocalOf { StadiumoTypography() }