package com.example.composebottomnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.composebottomnavigation.navigation.NavGraph
import com.example.composebottomnavigation.screens.component.BottomNavigationBar
import com.example.composebottomnavigation.ui.theme.ComposeBottomNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ComposeBottomNavigationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigationBar(navController = navController) }
                ) {
                    val padding = it
                    NavGraph(navController = navController)
                }
            }
        }
    }
}