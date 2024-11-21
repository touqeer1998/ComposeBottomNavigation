package com.example.composebottomnavigation.navigation

sealed class NavRoute(val route: String) {

    data object Home : NavRoute("home")

    data object Profile : NavRoute("profile") {
        val id = "id"
        val showDetails = "showDetails"
    }

    data object Settings : NavRoute("settings")
}