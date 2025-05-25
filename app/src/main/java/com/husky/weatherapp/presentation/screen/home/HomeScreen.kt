package com.husky.weatherapp.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(uiState: UIStateHomeScreen, onEvent: OnUIEventHomeScreen) {
    Column {

        Text("This is home screen with state : $uiState")
        Box(Modifier.size(60.dp).background(color = Color.Red.copy(.4f)).clickable{
            onEvent(UIEventHomeScreen.Placeholder)
        })
    }

}