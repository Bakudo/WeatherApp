package com.husky.weatherapp.presentation.screen.details

import androidx.compose.runtime.Composable
import com.husky.weatherapp.presentation.base.ScreenHolder

@Composable
fun DetailsScreen(viewModel: DetailsScreenViewModel, onEvent: OnUIEventDetailsScreen) {
    ScreenHolder(viewModel) {
        WeatherDetailsScreenContent(viewModel.uiState, onEvent)
    }
}