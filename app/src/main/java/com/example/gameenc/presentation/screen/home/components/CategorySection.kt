package com.example.gameenc.presentation.screen.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.gameenc.common.AppColors
import com.example.gameenc.data.remote.response.Genre
import com.example.gameenc.data.remote.response.Tag


@Composable
fun CategorySection(
    tags: List<Tag>,
    selectedCategory: MutableState<String>,
    selectedCategoryIndex: MutableState<Int>
) {

    LazyRow {
        items(tags.size) {
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
                    .clickable {
                        selectedCategoryIndex.value = it
                        selectedCategory.value = tags[it].name.uppercase()
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedCategoryIndex.value == it)
                            AppColors.mMain
                        else
                            AppColors.mSecond
                    )
                    .padding(15.dp)
            ) {
                Text(text = tags[it].name.uppercase(),
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Italic)
            }
        }
    }

}