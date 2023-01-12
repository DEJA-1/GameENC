package com.example.gameenc.presentation.screen.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gameenc.common.AppColors
import com.example.gameenc.presentation.screen.viewmodel.GameViewModel
import com.example.gameenc.presentation.screen.game.components.ImageSection
import com.example.gameenc.presentation.screen.game.components.InfoSection
import com.example.gameenc.presentation.screen.game.components.ScreenshotSection

@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel) {

    val images = viewModel.selectedGame.value.short_screenshots.toMutableList()
    images.removeFirst()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.mBackground),
    ) {

        Column(modifier = Modifier.padding(bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

            ImageSection(selectedGame = viewModel.selectedGame.value)

            Divider(modifier = Modifier.fillMaxWidth(),
                color = AppColors.mMain,
                thickness = 3.dp)

            ScreenshotSection(images = images)
            InfoSection()

        }

    }

}