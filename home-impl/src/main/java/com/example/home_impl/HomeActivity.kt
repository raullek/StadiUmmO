package com.example.home_impl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.core_design.theme.StadiumoTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            val homeTab = TabItem(
                title = "Home", selectedIcon = Icons.Filled.Home, unselectedIcon = Icons.Outlined.Home
            )
            val alertsTab = TabItem(
                title = "Alerts",
                selectedIcon = Icons.Filled.Notifications,
                unselectedIcon = Icons.Outlined.Notifications,
            )
            val settingsTab = TabItem(
                title = "Settings", selectedIcon = Icons.Filled.Settings, unselectedIcon = Icons.Outlined.Settings
            )
            val tabList = listOf(homeTab, alertsTab, settingsTab)


            StadiumoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = StadiumoTheme.colorScheme.background
                ) {
                    Scaffold(bottomBar = { TabView(tabList, navController) }) { padding ->
                        NavHost(navController = navController, startDestination = "Home") {
                            composable(homeTab.title) {
                                Text(modifier = Modifier.padding(padding), text = "Home")
                            }
                            composable(alertsTab.title) {
                                Text(modifier = Modifier.padding(padding), text = "Alerts")
                            }
                            composable(settingsTab.title) {
                                Text(
                                    modifier = Modifier.padding(padding),
                                    text = "Settings"
                                )
                            }
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun TabView(
    tabBarItems: List<TabItem>, navController: NavController
) {
    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }

    NavigationBar {
        // looping over each tab to generate the views and navigation for each item
        tabBarItems.forEachIndexed { index, tabBarItem ->
            NavigationBarItem(selected = selectedTabIndex == index, onClick = {
                selectedTabIndex = index
                navController.navigate(tabBarItem.title)
            }, icon = {
                TabBarIconView(
                    isSelected = selectedTabIndex == index,
                    selectedIcon = tabBarItem.selectedIcon,
                    unselectedIcon = tabBarItem.unselectedIcon,
                    title = tabBarItem.title,
                    badgeAmount = tabBarItem.badgeAmount
                )
            }, label = { Text(tabBarItem.title) })
        }
    }

}


@Composable
fun TabBarIconView(
    isSelected: Boolean, selectedIcon: ImageVector, unselectedIcon: ImageVector, title: String, badgeAmount: Int? = null
) {
    BadgedBox(badge = { TabBarBadgeView(badgeAmount) }) {
        Icon(
            imageVector = if (isSelected) {
                selectedIcon
            } else {
                unselectedIcon
            }, contentDescription = title
        )
    }
}

@Composable
fun TabBarBadgeView(count: Int? = null) {
    if (count != null) {
        Badge {
            Text(count.toString())
        }
    }
}

data class TabItem(
    val title: String, val selectedIcon: ImageVector, val unselectedIcon: ImageVector, val badgeAmount: Int? = null
)



