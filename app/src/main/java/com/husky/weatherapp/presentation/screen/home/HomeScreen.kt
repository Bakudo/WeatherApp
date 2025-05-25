package com.husky.weatherapp.presentation.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.husky.weatherapp.presentation.base.ScreenHolder

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel, onEvent: OnUIEventHomeScreen) {
    ScreenHolder(viewModel) {
        when (viewModel.uiState.dataState) {
            is DataState.ERROR -> {}
            DataState.IDLE -> HomeScreenContent(viewModel.uiState, onEvent)
            DataState.LOADING -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(50.dp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }


}