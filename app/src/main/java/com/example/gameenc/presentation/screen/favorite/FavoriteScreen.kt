package com.example.gameenc.presentation.screen.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gameenc.common.AppColors
import com.example.gameenc.navigation.Screen
import com.example.gameenc.presentation.screen.favorite.components.FavGameListSection
import com.example.gameenc.presentation.screen.viewmodel.GameViewModel

@Composable
fun FavoriteScreen(navController: NavController, viewModel: GameViewModel) {

    val gameList = viewModel.gameListFromDb.collectAsState().value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.mBackground),
        contentAlignment = Alignment.Center
    ) {
        if (gameList.isEmpty()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "List is empty.",
                    fontWeight = FontWeight.ExtraBold,
                    color = AppColors.mMain)
                Text(text = "Add some games to favorites :).",
                    fontWeight = FontWeight.ExtraLight,
                    color = AppColors.mMain)
            }
        } else {
            FavGameListSection(modifier = Modifier.padding(16.dp),
                selectedGame = viewModel.selectedGame,
                games = gameList,
                viewModel = viewModel
            ) {
                navController.navigate(Screen.Game.route)
            }
        }
    }

}