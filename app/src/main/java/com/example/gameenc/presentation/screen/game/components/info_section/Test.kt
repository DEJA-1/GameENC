package com.example.gameenc.presentation.screen.game.components.info_section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.gameenc.common.AppColors
import com.example.gameenc.domain.model.MyGame

@Composable
fun Test(
    icon: ImageVector,
    selectedGame: MyGame,
    text: String
) {

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 32.dp)
//        .clip(RoundedCornerShape(12.dp))
        .background(AppColors.mBackground)
        .padding(15.dp)) {

        Row() {
            Text(
                modifier = Modifier.padding(end = 2.dp),
                text = text,
                color = AppColors.textWhite,
                fontWeight = FontWeight.ExtraBold,
                fontStyle = FontStyle.Italic)

            Icon(imageVector = icon, contentDescription = "star image", tint = AppColors.mMain)
        }
    }

}