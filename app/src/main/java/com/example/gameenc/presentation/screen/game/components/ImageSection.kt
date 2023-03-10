package com.example.gameenc.presentation.screen.game.components

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.gameenc.common.AppColors
import com.example.gameenc.domain.model.MyGame
import com.example.gameenc.presentation.screen.game.components.info_section.Chip
import com.example.gameenc.presentation.screen.viewmodel.GameViewModel

@Composable
fun ImageSection(
    selectedGame: MyGame,
    viewModel: GameViewModel
) {

    val context = LocalContext.current

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(250.dp),
    contentAlignment = Alignment.BottomEnd) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(selectedGame.background_image)
                .crossfade(true)
                .build(),
            contentDescription = "Game image",
            contentScale = ContentScale.FillBounds
        )

        Chip(
            icon = Icons.Rounded.Favorite,
            text = "",
            textPaddingStart = 0.dp,
            iconSize = 24.dp,
            iconTint = AppColors.textWhite,
            boxBackground = AppColors.mRed,
            onClick = {
                viewModel.insertGameToDb(selectedGame)
                Toast.makeText(context, "Game added to favorites!", Toast.LENGTH_SHORT).show()
            }
        )
    }

}