package com.example.acalanto

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(navController: NavHostController = rememberNavController()){
    NavHost(
        navController = navController,
        startDestination = "SplashPage"
    ){
        composable("SplashPage"){
            SplashPage(navController = navController)
        }
        composable("HomePage"){

        }
        composable("MusicPage"){

        }
    }
}