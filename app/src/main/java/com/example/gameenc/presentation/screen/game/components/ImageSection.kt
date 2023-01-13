package com.example.gameenc.presentation.screen.game.components

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

@Composable
fun ImageSection(selectedGame: MyGame) {

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(250.dp)) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(selectedGame.background_image)
                .crossfade(true)
                .build(),
            contentDescription = "Game image",
            contentScale = ContentScale.FillBounds
        )

        Chip(modifier = Modifier.align(Alignment.BottomEnd),
            icon = Icons.Rounded.Favorite,
            text = "",
            textPaddingStart = 0.dp,
            iconSize = 24.dp,
            iconTint = AppColors.textWhite,
            boxBackground = AppColors.mRed
        )
    }

}