package com.husky.weatherapp.presentation.screen.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailsScreen(uiState: UIStateDetailsScreen, onEvent: OnUIEventDetailsScreen) {
    Text("This is home screen with state : $uiState")
}