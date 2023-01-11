package com.example.gameenc.presentation.screen.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gameenc.common.AppColors

@Preview
@Composable
fun HeaderSection() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
    ) {

        Text(
            buildAnnotatedString {

                withStyle(style = SpanStyle(
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Italic,
                    color = AppColors.textWhite,
                    fontSize = 32.sp
                )) {
                    append("GAME")
                }

                withStyle(style = SpanStyle(
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Italic,
                    color = AppColors.mMain,
                    fontSize = 16.sp
                )) {
                    append("ENC")
                }
            }
        )
        Icon(
            modifier = Modifier.size(24.dp)
                .clickable {

                },
            imageVector = Icons.Rounded.Search, contentDescription = "Search icon",
            tint = AppColors.mMain,
        )
    }
}