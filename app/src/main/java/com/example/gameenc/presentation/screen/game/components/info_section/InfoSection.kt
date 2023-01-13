package com.example.gameenc.presentation.screen.game.components.info_section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gameenc.common.AppColors
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
            fontSize = 26.sp,
            iconSize = 0.dp
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
            iconSize = 32.dp
        )

        Chip(
            icon = Icons.Rounded.Home,
            text = selectedGame.platforms.joinToString { it.platform_info.name },
            iconSize = 32.dp
        )
    }
}