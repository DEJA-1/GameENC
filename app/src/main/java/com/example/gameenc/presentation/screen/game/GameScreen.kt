package com.example.gameenc.presentation.screen.game

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gameenc.common.AppColors
import com.example.gameenc.presentation.GameViewModel

@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppColors.mBackground
    ) {

        Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

            Text(text = viewModel.selectedGame.value.name,
            color = Color.White,
            style = MaterialTheme.typography.h1)

        }

    }

}