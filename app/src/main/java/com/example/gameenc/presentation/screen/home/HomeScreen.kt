package com.example.gameenc.presentation.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gameenc.navigation.Screen

@Composable
fun HomeScreen(navController: NavHostController) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Home Screen",
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center
            )
            
            Button(modifier = Modifier.size(200.dp),
                onClick = { navController.navigate(route = Screen.Game.route) }) {

                Text(text = "Game screen",
                textAlign = TextAlign.Center)

            }
        }
        

    }

}