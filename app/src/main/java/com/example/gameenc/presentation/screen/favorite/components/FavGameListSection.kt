package com.example.gameenc.presentation.screen.favorite.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
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

@Composable
fun FavGameListSection(
    games: List<MyGame> = emptyList(),
    selectedGame: MutableState<MyGame>,
    onClick: () -> Unit
) {

    Column(
        horizontalAlignment = CenterHorizontally) {

        LazyColumn() {
            items(games) {
                Card(modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 8.dp)
                    .clickable {
                        selectedGame.value = it
                        onClick()
                    },
                    shape = RoundedCornerShape(12.dp),
                    elevation = 4.dp) {

                    Box(modifier = Modifier.clip(RoundedCornerShape(12.dp))) {
                        AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                            .data(it.background_image)
                            .crossfade(true)
                            .build(),
                            contentDescription = "Game Image")

                        Box(contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(AppColors.mMain)
                                .clip(RoundedCornerShape(12.dp))
//                                .padding(start = 32.dp, end = 32.dp, bottom = 15.dp)

//                                .border(width = 2.dp, color = AppColors.mMain, shape = RoundedCornerShape(4.dp))
                                .padding(15.dp)
                                .align(Alignment.BottomStart)) {

                            Text(
                                text = it.name,
                                fontWeight = FontWeight.ExtraBold,
                                fontStyle = FontStyle.Italic,
                                color = Color.Black,
                                fontSize = 14.sp)

                        }
                    }
                }
            }
        }
    }
}