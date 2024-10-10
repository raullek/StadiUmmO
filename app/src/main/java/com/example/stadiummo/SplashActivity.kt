package com.example.stadiummo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.example.core_design.theme.StadiumoTheme
import com.example.stadiummo.ui.splash.SplashScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    var showSplashScreen = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        lifecycleScope.launch {
            delay(2000) //Simulates checking if the user is logged in
            showSplashScreen = false
        }
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                showSplashScreen
            }

        }

        setContent {
            SplashScreen()

        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}