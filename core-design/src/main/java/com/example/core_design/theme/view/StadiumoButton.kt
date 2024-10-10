package com.example.core_design.theme.view

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.example.core_design.theme.StadiumoColorScheme
import com.example.core_design.theme.StadiumoTheme

@Composable
fun StadiumoButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.shape
) {
    Button(onClick = { /*TODO*/ }) {

    }
}


object ButtonDefaults {
    internal val StadiumoColorScheme.buttonColors: StadiumoButtonColor
        get() {
            return StadiumoButtonColor(
                containerColor = StadiumoTheme.colorScheme.primary,
                contentColor = StadiumoTheme.colorScheme.background,
                disabledContentColor = Color.Black,
                disabledContainerColor = Color.Gray

            )
        }

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
class StadiumoButtonColor constructor(
    val containerColor: Color,
    val contentColor: Color,
    val disabledContainerColor: Color,
    val disabledContentColor: Color,
)