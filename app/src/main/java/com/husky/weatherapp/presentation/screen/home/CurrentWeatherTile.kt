package com.husky.weatherapp.presentation.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.husky.weatherapp.data.mapper.WeatherCodeMapper
import com.husky.weatherapp.domain.value.CityId

@Composable
fun CurrentWeatherTile(uiState: UIStateHomeScreen, onWeatherClick: OnClickId) {
    uiState.selectedCity?.let { city ->
        uiState.currentWeather?.let { weather ->
            val conditions = WeatherCodeMapper.getWeatherCondition(weather.weather_code)
            WeatherTile(
                modifier = Modifier.clickable {
                    onWeatherClick(CityId(city.id))
                },
                location = city.getDisplayName(),
                weather.temperature_2m.toString(),
                conditions.description,
                conditions.icon
            )
        }
    }
}

