package com.example.gameenc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gameenc.presentation.screen.game.GameScreen
import com.example.gameenc.presentation.screen.home.HomeScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.Game.route
        ) {
            GameScreen(navController = navController)
        }

    }

}