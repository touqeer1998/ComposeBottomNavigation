package com.example.composebottomnavigation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings

sealed class NavItem {
    object Home : Item(
        path = NavRoute.Home.route, title = "Home", icon = Icons.Default.Home
    )

    object Profile : Item(
        path = NavRoute.Profile.route, title = "Profile", icon = Icons.Default.Person
    )

    object Settings : Item(
        path = NavRoute.Settings.route, title = "Settings", icon = Icons.Default.Settings
    )
}