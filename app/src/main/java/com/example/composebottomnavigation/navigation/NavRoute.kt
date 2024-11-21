package com.example.composebottomnavigation.navigation

sealed class NavRoute(val route: String) {

    data object Home : NavRoute("home")

    data object Profile : NavRoute("profile") {
        fun buildRoute(id: Int, showDetails: Boolean) = "profile/$id/$showDetails"
    }

    data object Settings : NavRoute("settings")
}