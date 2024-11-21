package com.example.composebottomnavigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composebottomnavigation.screens.HomeScreen
import com.example.composebottomnavigation.screens.ProfileScreen
import com.example.composebottomnavigation.screens.SettingsScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoute.Home.route) {
        addHomeScreen(navController, this)
        addProfileScreen(navController, this)
        addSettingsScreen(navController, this)
    }
}

fun addHomeScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(route = NavRoute.Home.route) {
        HomeScreen(navigateToProfile = { id, showDetails ->
            navController.navigate(
                NavRoute.Profile.buildRoute(id, showDetails)
            )
        }, navigateToSettings = {
            navController.navigate(NavRoute.Settings.route)
        })
    }
}

fun addProfileScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Profile.route.plus("/{id}/{showDetails}"), arguments = listOf(
            navArgument(name = "id") {
                type = NavType.IntType
            },
            navArgument(name = "showDetails") {
                type = NavType.BoolType
            },
        )
    ) { navBackStackEntry ->
        val id = navBackStackEntry.arguments?.getInt("id").toString().toInt()
        val showDetails =
            navBackStackEntry.arguments?.getBoolean("showDetails").toString().toBoolean()
        ProfileScreen(id = id,
            showDetails = showDetails,
            navigateToSettings = { navController.navigate(NavRoute.Settings.route) })
    }
}

fun addSettingsScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(NavRoute.Settings.route) {
        SettingsScreen(navigateToHome = { navController.navigate(NavRoute.Home.route) })
    }
}