package com.example.core_design.theme.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.core_design.theme.StadiumoColorScheme
import com.example.core_design.theme.StadiumoTheme

@Composable
fun StadiumoButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = BtnDefaults.shape,
    colors: StadiumoButtonColor = BtnDefaults.buttonColors(),
    elevation: StadiumoButtonElevation = BtnDefaults.buttonElevation(),
    borderStroke: BorderStroke? = null,
    contentPadding: PaddingValues = BtnDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit

) {
    Button(
        onClick = onClick::invoke,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = colors.mapToMaterialColorModel(),
        elevation = elevation.mapToMaterialElevationModel(),
        border = borderStroke,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )
}


object BtnDefaults {
    private val ButtonHorizontalPadding = 24.dp
    private val ButtonVerticalPadding = 8.dp


    @Composable
    fun buttonColors(): StadiumoButtonColor = StadiumoTheme.colorScheme.buttonColors

    internal val StadiumoColorScheme.buttonColors: StadiumoButtonColor
        get() {
            return defaultButtonColorsCached ?: StadiumoButtonColor(
                containerColor = Color(0xFF32B768),
                contentColor = Color.White,
                disabledContentColor = Color.Black,
                disabledContainerColor = Color.Gray
            ).also { defaultButtonColorsCached = it }
        }

    @Composable
    fun buttonColors(
        containerColor: Color = Color.Unspecified,
        contentColor: Color = Color.Unspecified,
        disabledContainerColor: Color = Color.Unspecified,
        disabledContentColor: Color = Color.Unspecified,
    ): StadiumoButtonColor = StadiumoTheme.colorScheme.buttonColors.copy(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )


    val shape: Shape @Composable get() = RoundedCornerShape(0, 0, 0, 0)

    @Composable
    fun buttonElevation(
        defaultElevation: Dp = 0.0.dp,
        pressedElevation: Dp = 0.0.dp,
        focusedElevation: Dp = 0.0.dp,
        hoveredElevation: Dp = 1.0.dp,
        disabledElevation: Dp = 1.0.dp,
    ): StadiumoButtonElevation = StadiumoButtonElevation(
        defaultElevation = defaultElevation,
        pressedElevation = pressedElevation,
        focusedElevation = focusedElevation,
        hoveredElevation = hoveredElevation,
        disabledElevation = disabledElevation,
    )

    val ContentPadding =
        PaddingValues(
            start = ButtonHorizontalPadding,
            top = ButtonVerticalPadding,
            end = ButtonHorizontalPadding,
            bottom = ButtonVerticalPadding
        )

}

//    onClick: () -> Unit,
//    modifier: Modifier = Modifier,
//    enabled: Boolean = true,
//    shape: Shape = ButtonDefaults.shape,
//    colors: ButtonColors = ButtonDefaults.buttonColors(),
//    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
//    border: BorderStroke? = null,
//    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
//    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
//    content: @Composable RowScope.() -> Unit

@Immutable
data class StadiumoButtonColor constructor(
    val containerColor: Color,
    val contentColor: Color,
    val disabledContainerColor: Color,
    val disabledContentColor: Color,
) {
    @Composable
    fun mapToMaterialColorModel(): ButtonColors = ButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContentColor = disabledContentColor,
        disabledContainerColor = disabledContainerColor
    )

}

@Stable
data class StadiumoButtonElevation internal constructor(
    private val defaultElevation: Dp,
    private val pressedElevation: Dp,
    private val focusedElevation: Dp,
    private val hoveredElevation: Dp,
    private val disabledElevation: Dp,
) {

    @Composable
    fun mapToMaterialElevationModel(): ButtonElevation = ButtonDefaults.buttonElevation(
        defaultElevation = defaultElevation,
        pressedElevation = pressedElevation,
        focusedElevation = focusedElevation,
        hoveredElevation = hoveredElevation,
        disabledElevation = disabledElevation
    )
}