package com.example.composebottomnavigation.screens.component

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composebottomnavigation.navigation.NavItem
import com.example.composebottomnavigation.navigation.NavRoute

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(NavItem.Home, NavItem.Profile, NavItem.Settings)

    val currentBackStackEntry by navController.currentBackStackEntryAsState()

    val currentRoute = currentBackStackEntry?.destination?.route

    val selectedItem = items.indexOfFirst { it.path == currentRoute }

    var selectedNavItem by rememberSaveable {
        mutableIntStateOf(if (selectedItem >= 0) selectedItem else 0)
    }

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(selected = selectedItem == index, onClick = {
                selectedNavItem = index
                val route = if (item.path == NavRoute.Profile.route) {
                    NavRoute.Profile.route.plus("/123/false")
                } else {
                    item.path
                }
                navController.navigate(route) {
                    navController.graph.startDestinationRoute?.let { startDestinationRoute ->
                        popUpTo(startDestinationRoute) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }, icon = {
                Icon(imageVector = item.icon, contentDescription = "${item.title} icon")
            }, label = {
                Text(text = item.title)
            })
        }
    }
}