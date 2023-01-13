package com.example.gameenc.presentation.screen.game.components.info_section

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gameenc.domain.model.MyGame

@Composable
fun InfoSection(
    selectedGame: MyGame,
) {

    Column(
        horizontalAlignment = CenterHorizontally
    ) {

        Chip(
            icon = Icons.Rounded.Edit,
            text = selectedGame.name,
            fontSize = 32.sp,
            imageSize = 0.dp
        )

        Row() {
            Chip(
                icon = Icons.Rounded.Star,
                text = selectedGame.rating.toString()
            )

            Chip(
                icon = Icons.Rounded.Favorite,
                text = selectedGame.ratings_count.toString()
            )

            Chip(
                icon = Icons.Rounded.DateRange,
                text = selectedGame.released
            )

        }

        Chip(
            icon = Icons.Rounded.ShoppingCart,
            text = selectedGame.stores.joinToString { it.store.name },
            imageSize = 32.dp
        )

        Chip(
            icon = Icons.Rounded.Home,
            text = selectedGame.platforms.joinToString { it.platform_info.name },
            imageSize = 32.dp
        )


//        Test(icon = Icons.Rounded.Star, selectedGame = selectedGame, text = selectedGame.rating.toString())

    }
}