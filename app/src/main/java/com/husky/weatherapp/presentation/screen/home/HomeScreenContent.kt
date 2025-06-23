package com.husky.weatherapp.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.husky.weatherapp.presentation.screen.home.UIEventHomeScreen.CityQuery
import com.husky.weatherapp.presentation.screen.home.UIEventHomeScreen.CitySelected
import com.husky.weatherapp.presentation.screen.home.UIEventHomeScreen.ClickedOnCurrentWeather
import com.husky.weatherapp.presentation.screen.home.UIEventHomeScreen.PressedEnterOnSearchBar
import com.husky.weatherapp.presentation.screen.ui.SearchBarRow
import com.husky.weatherapp.presentation.screen.ui.UISearchEvent

@Composable
fun HomeScreenContent(uiState: UIStateHomeScreen, onEvent: OnUIEventHomeScreen) {
    Column(Modifier) {

        SearchBarRow(uiState.cityQuery,uiState.lastUsedQueries,uiState.canShowLastUsedQueries) { searchEvent ->
            when (searchEvent) {
                UISearchEvent.OnClearClicked -> {}
                is UISearchEvent.UserInput -> onEvent(CityQuery(searchEvent.query))
                UISearchEvent.OnUserEnterPressed -> onEvent(PressedEnterOnSearchBar)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        CityResultList(uiState.citiesFromQuery) {
            onEvent(CitySelected(it))
        }

        if (uiState.currentWeather != null) {
            CurrentWeatherTile(uiState) {
                onEvent(ClickedOnCurrentWeather(it))
            }
            CurrentCityForecast(uiState)
        }
    }
}

