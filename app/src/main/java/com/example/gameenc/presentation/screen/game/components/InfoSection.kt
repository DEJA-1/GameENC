package com.example.gameenc.presentation.screen.game.components

import android.graphics.Paint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gameenc.common.AppColors

@Composable
fun InfoSection() {


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

    }
}