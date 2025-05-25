package com.husky.weatherapp.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.husky.weatherapp.data.mapper.WeatherCodeMapper
import com.husky.weatherapp.data.mapper.WeatherMapper
import com.husky.weatherapp.presentation.screen.ui.SearchBarRow
import com.husky.weatherapp.presentation.screen.ui.UISearchEvent

@Composable
fun HomeScreenContent(uiState: UIStateHomeScreen, onEvent: OnUIEventHomeScreen) {
    Column(Modifier) {

        SearchBarRow(uiState.cityQuery) { searchEvent ->
            when (searchEvent) {
                UISearchEvent.OnClearClicked -> {}
                is UISearchEvent.UserInput -> onEvent(UIEventHomeScreen.CityQuery(searchEvent.query))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        CityResultList(uiState.citiesFromQuery) {
            onEvent(UIEventHomeScreen.CitySelected(it))
        }

        uiState.selectedCity?.let { city ->
            uiState.currentWeather?.let { weather ->
                val conditions = WeatherCodeMapper.getWeatherCondition(weather.weather_code)
                WeatherTile(
                    location = city.getDisplayName(),
                    weather.temperature_2m.toString(),
                    conditions.description,
                    conditions.icon
                )
            }
        }
    }
}
