package com.example.gameenc.navigation

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Game: Screen(route = "game_screen")
    object Favorite: Screen(route = "favorite_screen")
}
