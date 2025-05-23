package com.example.acalanto

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Home : Screen("home")
    data object Music : Screen("music")
}

@Composable
fun Navigation(navController: NavHostController = rememberNavController()){
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ){
        composable(Screen.Splash.route){
            SplashPage(navController = navController)
        }
        composable(Screen.Home.route){
            HomePage(navController = navController)
        }
        composable(Screen.Music.route){
            MusicPage(navController = navController)
        }
    }
}