package com.example.gameenc.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gameenc.common.AppColors
import com.example.gameenc.navigation.Screen
import com.example.gameenc.presentation.screen.viewmodel.GameViewModel
import com.example.gameenc.presentation.screen.home.components.CategorySection
import com.example.gameenc.presentation.screen.home.components.GameListSection
import com.example.gameenc.presentation.screen.home.components.HeaderSection

@Composable
fun HomeScreen(navController: NavHostController, viewModel: GameViewModel) {


    val gameListFiltered = viewModel.gameList.value.results.filter { it.tags.any { tag -> tag.name == viewModel.selectedCategory.value } }
    val tagList = gameListFiltered.map { it.tags }.flatten().distinctBy { it.name }.toMutableList()


    if (!viewModel.isLoading.value) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(AppColors.mBackground)
        ) {

            Column(modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                HeaderSection()
                CategorySection(tags = tagList, selectedCategory = viewModel.selectedCategory, selectedCategoryIndex = viewModel.selectedCategoryIndex)
                GameListSection(
                    games = gameListFiltered,
                    selectedCategory = viewModel.selectedCategory,
                    selectedGame = viewModel.selectedGame,
                    onClick = {
                        navController.navigate(Screen.Game.route)
                    })
            }
        }
    } else {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(AppColors.mBackground),
            contentAlignment = Alignment.Center) {

            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                strokeWidth = 5.dp,
                color = AppColors.mMain
            )
        }
    }


}