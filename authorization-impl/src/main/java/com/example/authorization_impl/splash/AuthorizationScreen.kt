package com.example.authorization_impl.splash

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.authorization_impl.R
import com.example.core_design.theme.StadiumoTheme
import com.example.core_design.theme.view.StadiumoButton
import com.example.core_utils.getActivity
import com.example.home_impl.HomeActivity

@Composable
fun AuthorizationScreen(navHostController: NavHostController, onAuthorizationClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
            .padding(horizontal = 16.dp, vertical = 32.dp)
    ) {
        val text = remember { mutableStateOf("Phone Number") }

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(124.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.ill_sublogo),
            contentDescription = "Apps logo"
        )
        Spacer(modifier = Modifier.padding(36.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            value = text.value,
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
            onValueChange = { nextText ->
                text.value = nextText
            }

        )
        Spacer(modifier = Modifier.weight(1F))
        StadiumoButton(modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
            shape = RoundedCornerShape(12),
            onClick = {
             onAuthorizationClick.invoke()
            }
        ) {
            Text(
                modifier = Modifier.height(20.dp),
                text = "Continue"
            )

        }

    }
}


@Preview
@Composable
fun AuthorizationPreview() {
    StadiumoTheme {
        // AuthorizationScreen(rememberNavController())
    }
}