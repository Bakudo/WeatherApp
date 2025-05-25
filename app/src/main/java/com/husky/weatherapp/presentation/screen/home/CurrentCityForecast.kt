package com.husky.weatherapp.presentation.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun CurrentCityForecast(uiState: UIStateHomeScreen) {
    val forecast = uiState.forecastedWeather
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(items = forecast, key = { it.time }) {
            CurrentCityForecastItem(it)
        }
    }
}