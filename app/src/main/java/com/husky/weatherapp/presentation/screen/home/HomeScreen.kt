package com.husky.weatherapp.presentation.screen.home

import androidx.compose.runtime.Composable
import com.husky.weatherapp.presentation.base.ScreenHolder

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel, onEvent: OnUIEventHomeScreen) {
    ScreenHolder(viewModel) {
        HomeScreenContent(viewModel.uiState, onEvent)
    }


}