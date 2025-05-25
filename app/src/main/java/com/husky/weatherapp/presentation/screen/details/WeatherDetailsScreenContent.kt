package com.husky.weatherapp.presentation.screen.details

import androidx.compose.runtime.Composable
import com.husky.weatherapp.data.mapper.WeatherCodeMapper

@Composable
fun WeatherDetailsScreenContent(uiState: UIStateDetailsScreen, onEvent: OnUIEventDetailsScreen) {
    uiState.location?.let { location ->
        uiState.weather?.let { weather ->
            val  condition = WeatherCodeMapper.getWeatherCondition(weather.weather_code)
            WeatherTileDetailed(
                location = location.getDisplayName(),
                temperature = weather.temperature_2m.toString(),
                weatherCondition = condition.description,
                winSpeed = weather.wind_speed_10m,
                humidity = weather.relative_humidity_2m,
                icon = condition.icon
            )
        }
    }
}