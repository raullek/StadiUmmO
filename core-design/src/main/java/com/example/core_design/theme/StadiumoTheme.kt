package com.example.core_design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun StadiumoTheme(
    typography: StadiumoTypography = StadiumoTheme.typography,
    dimens: StadiumoDimension = StadiumoTheme.dimens,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when(darkTheme){
        true-> baseDarkPalette
        else -> baseLightPalette
    }


    CompositionLocalProvider(
        LocalStadiumoColorScheme provides colorScheme,
        LocalStadiumoTypography provides typography,
        LocalStadiumoDimensions provides dimens,
        content = content
        )

}

object StadiumoTheme {

    val colorScheme: StadiumoColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalStadiumoColorScheme.current

    val typography: StadiumoTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalStadiumoTypography.current

    val dimens: StadiumoDimension
        @Composable
        @ReadOnlyComposable
        get() = LocalStadiumoDimensions.current
}