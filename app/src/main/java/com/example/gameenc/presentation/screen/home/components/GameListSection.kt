package com.example.gameenc.presentation.screen.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.gameenc.common.AppColors
import com.example.gameenc.domain.model.MyGame

@Preview
@Composable
fun GameListSection(
    tag: String = "RPG",
    games: List<MyGame> = emptyList(),
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            modifier = Modifier.padding(bottom = 15.dp, top = 32.dp),
            text = tag.uppercase(),
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            fontSize = 32.sp,
            color = AppColors.textWhite)

        LazyColumn() {
            items(games) {
                Card(modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                    shape = RoundedCornerShape(12.dp),
                    elevation = 4.dp,
                    border = BorderStroke(2.dp, AppColors.mMain)) {

                    AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                        .data(it.background_image)
                        .crossfade(true)
                        .build(),
                        contentDescription = "Game Image")

                    Box(contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .padding(start = 35.dp, end = 35.dp)
                            .background(AppColors.mMain)
                            .border(2.dp, Color.Black, RoundedCornerShape(12.dp))) {

                        Text(
                            text = it.name,
                            fontWeight = FontWeight.ExtraBold,
                            fontStyle = FontStyle.Italic,
                            color = Color.Black,
                            fontSize = 32.sp)

                    }
                }
            }
        }
    }
}