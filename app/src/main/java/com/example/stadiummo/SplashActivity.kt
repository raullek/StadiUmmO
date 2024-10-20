package com.example.stadiummo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    var showSplashScreen = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            delay(1500) //Simulates checking if the user is logged in
            showSplashScreen = false
        }
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                showSplashScreen
            }
            setOnExitAnimationListener {
                startActivity(
                    Intent(
                        this@MainActivity,
                        com.example.authorization_impl.AuthorizationActivity::class.java
                    )
                )
                finish()
            }

        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}