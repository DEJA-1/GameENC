package com.example.gameenc.presentation.screen.favorite.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.gameenc.common.AppColors
import com.example.gameenc.domain.model.MyGame
import com.example.gameenc.presentation.screen.game.components.info_section.Chip
import com.example.gameenc.presentation.screen.viewmodel.GameViewModel

@Composable
fun FavGameListSection(
    modifier: Modifier = Modifier,
    games: List<MyGame> = emptyList(),
    selectedGame: MutableState<MyGame>,
    viewModel: GameViewModel,
    onGameClicked: () -> Unit
) {

    val context = LocalContext.current

    Column(
        modifier = modifier,
        horizontalAlignment = CenterHorizontally
    ) {

        LazyColumn() {
            items(games) {
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 8.dp)
                        .clickable {
                            selectedGame.value = it
                            onGameClicked()
                        },
                    shape = RoundedCornerShape(12.dp),
                    elevation = 4.dp
                ) {

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .border(
                                width = 2.dp,
                                color = AppColors.mMain,
                                shape = RoundedCornerShape(12.dp)
                            ),
                        contentAlignment = Alignment.TopEnd
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(it.background_image)
                                .crossfade(true)
                                .build(),
                            contentDescription = "Game Image"
                        )

                        Chip(
                            icon = Icons.Rounded.Delete,
                            text = "",
                            textPaddingStart = 0.dp,
                            iconSize = 24.dp,
                            iconTint = AppColors.textWhite,
                            boxBackground = AppColors.mRed,
                            contentPadding = 10.dp,
                            onClick = {
                                viewModel.deleteGameFromDb(it)
                                Toast.makeText(context, "Game deleted from favorites!", Toast.LENGTH_SHORT).show()
                            }
                        )

                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(AppColors.mMain)
                                .clip(RoundedCornerShape(12.dp))
                                .padding(15.dp)
                                .align(Alignment.BottomStart)
                        ) {

                            Text(
                                text = it.name,
                                fontWeight = FontWeight.ExtraBold,
                                fontStyle = FontStyle.Italic,
                                color = Color.Black,
                                fontSize = 14.sp
                            )

                        }
                    }
                }
            }
        }
    }
}