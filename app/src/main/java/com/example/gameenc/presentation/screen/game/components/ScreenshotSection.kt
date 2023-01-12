package com.example.gameenc.presentation.screen.game.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.gameenc.data.remote.response.ShortScreenshot

@Composable
fun ScreenshotSection(
    images: List<ShortScreenshot>,
) {
    LazyRow() {
        items(images) {

            Card(modifier = Modifier
                .width(150.dp)
                .height(100.dp)
                .padding(top = 16.dp, start = 8.dp, end = 8.dp),
                elevation = 4.dp) {

                AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                    .data(it.image)
                    .crossfade(true)
                    .build(),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = "game screenshot")

            }

        }
    }

}