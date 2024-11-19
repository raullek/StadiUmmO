package com.example.authorization_impl.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.authorization_impl.di.AuthorizationComponentHolder
import com.example.authorization_impl.splash.AuthorizationScreen
import com.example.home_api.HomeApi
import com.example.stadiummo.ui.splash.OnboardingScreen


enum class Screen {
    ONBOARDING,
    AUTHORIZATION,
}

sealed class NavigationItem(val route: String) {
    data object Onboarding : NavigationItem(Screen.ONBOARDING.name)
    data object Authorization : NavigationItem(Screen.AUTHORIZATION.name)
}

@Composable
fun AuthorizationNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Onboarding.route,
) {
    val context = LocalContext.current as? Activity

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Onboarding.route) {
            OnboardingScreen(navController)
        }
        composable(NavigationItem.Authorization.route) {
            val authorizationComponent = remember {
                AuthorizationComponentHolder.getComponent()
            }
            AuthorizationScreen(navController) {
                context?.let {
                    authorizationComponent.homeLauncher.launch(it)
                    it.finish()
                }
            }
        }
    }
}