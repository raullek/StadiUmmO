package com.example.core_design.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

internal val baseLightPalette = StadiumoColorScheme(
    primary = Color(0xFF32B768),
    onPrimary = Color(0xFF4954B9),
    error = Color(0xFFFF0000),
    onError = Color(0xFFFF0000),
    success = Color(0xFF22854C),
    onSuccess = Color(0xFF22854C),
    warning = Color(0xFFFFA500),
    onWarning = Color(0xFFFFA500),
    background = Color(0xFFFFFFFF),
    onBackground = Color(0xFFEFF1FF),
    surface = Color(0x123323123),
    onSurface = Color(0x123323123),
    outline = Color(0x123323123),
    isLight = true,
)

internal val baseDarkPalette = StadiumoColorScheme(
    primary = Color(0xFF32B768),
    onPrimary = Color(0xFF4954B9),
    error = Color(0xFFFF0000),
    onError = Color(0xFFFF0000),
    success = Color(0xFF22854C),
    onSuccess = Color(0xFF22854C),
    warning = Color(0xFFFFA500),
    onWarning = Color(0xFFFFA500),
    background = Color(0xFFFFFFFF),
    onBackground = Color(0xFFEFF1FF),
    surface = Color(0x123323123),
    onSurface = Color(0x123323123),
    outline = Color(0x123323123),
    isLight = false,
)

internal val LocalStadiumoColorScheme = staticCompositionLocalOf<StadiumoColorScheme> { error("No color provided") }
