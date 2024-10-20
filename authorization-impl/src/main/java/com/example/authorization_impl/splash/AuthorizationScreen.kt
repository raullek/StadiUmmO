package com.example.authorization_impl.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.authorization_impl.R
import com.example.core_design.theme.StadiumoTheme

@Composable
fun AuthorizationScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.ill_sublogo),
            contentDescription = "Apps logo"
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            value = "",
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_user_16),
                    contentDescription = "user icon"
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = StadiumoTheme.colorScheme.background,
                focusedContainerColor = StadiumoTheme.colorScheme.background,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(12),
            onValueChange = {
            }
        )
    }
}


@Preview
@Composable
fun AuthorizationPreview() {
    StadiumoTheme {
        AuthorizationScreen()
    }
}