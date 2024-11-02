package com.example.authorization_impl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.authorization_impl.navigation.AuthorizationNavHost
import com.example.core_design.theme.StadiumoTheme
import com.example.stadiummo.ui.splash.OnboardingScreen

class AuthorizationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            StadiumoTheme {
                val navController = rememberNavController()
                AuthorizationNavHost(navController = navController)
                //    OnboardingScreen()
            }
        }
    }
}
