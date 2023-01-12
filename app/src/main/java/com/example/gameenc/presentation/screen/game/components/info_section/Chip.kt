package com.example.gameenc.presentation.screen.game.components.info_section

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.gameenc.common.AppColors
import com.example.gameenc.domain.model.MyGame

@Composable
fun Chip(
    icon: ImageVector,
    selectedGame: MyGame,
    text: String
) {
    Box(modifier = Modifier
        .padding(4.dp)
        .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(12.dp))
        .clip(RoundedCornerShape(12.dp))

        .background(AppColors.mMain)
        .clickable {

        }
        .padding(15.dp)
    ) {

        Row() {
            Text(
                modifier = Modifier.padding(end = 2.dp),
                text = text,
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold,
                fontStyle = FontStyle.Italic)

            Icon(imageVector = icon, contentDescription = "star image")
        }
    }

}