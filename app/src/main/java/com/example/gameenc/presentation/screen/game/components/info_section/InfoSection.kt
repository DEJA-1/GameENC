package com.example.gameenc.presentation.screen.game.components.info_section

import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gameenc.common.AppColors
import com.example.gameenc.domain.model.MyGame
import kotlinx.coroutines.selects.select

@Composable
fun InfoSection(
    selectedGame: MyGame,
) {

    Column(
        horizontalAlignment = CenterHorizontally) {

        Text(
            modifier = Modifier.padding(bottom = 15.dp, top = 32.dp),
            text = "INFO",
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            fontSize = 28.sp,
            color = AppColors.textWhite,
            textAlign = TextAlign.Center)

        Row() {
            Chip(
                icon = Icons.Rounded.Star,
                selectedGame = selectedGame,
                text = selectedGame.rating.toString()
            )

            Chip(
                icon = Icons.Rounded.Favorite,
                selectedGame = selectedGame,
                text = selectedGame.ratings_count.toString()
            )

            Chip(
                icon = Icons.Rounded.DateRange,
                selectedGame = selectedGame,
                text = selectedGame.released
            )

        }

    }
}