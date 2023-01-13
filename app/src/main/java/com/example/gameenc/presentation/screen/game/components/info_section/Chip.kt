package com.example.gameenc.presentation.screen.game.components.info_section

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gameenc.common.AppColors
import com.example.gameenc.domain.model.MyGame

@Composable
fun Chip(
    modifier: Modifier = Modifier,
    boxModifier: Modifier = Modifier,
    icon: ImageVector,
    text: String,
    fontSize: TextUnit = 16.sp,
    iconSize: Dp = 24.dp,
    iconTint: Color = AppColors.mMain,
    boxBackground: Color = AppColors.mBackground,
    textPaddingStart: Dp = 6.dp,
    contentPadding: Dp = 15.dp,
    boxPadding: Dp = 4.dp,
    onClick: () -> Unit = {}
) {
    Box(modifier = boxModifier
        .padding(boxPadding)
        .clip(RoundedCornerShape(12.dp))

        .background(boxBackground)
        .clickable {
            onClick()
        }
        .padding(contentPadding)
    ) {

        Row() {
            Icon(modifier = modifier.size(iconSize),
                imageVector = icon,
                contentDescription = "star image",
                tint = iconTint
            )
            Text(
                modifier = modifier.padding(start = textPaddingStart),
                text = text,
                color = AppColors.textWhite,
                fontWeight = FontWeight.ExtraBold,
                fontStyle = FontStyle.Italic,
                fontSize = fontSize
            )

        }
    }

}