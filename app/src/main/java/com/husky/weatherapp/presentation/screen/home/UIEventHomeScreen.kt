package com.husky.weatherapp.presentation.screen.home

import com.husky.weatherapp.domain.value.CityId

sealed interface UIEventHomeScreen {
    data class CityQuery(val query: String) : UIEventHomeScreen
    data class CitySelected(val cityId: CityId) : UIEventHomeScreen
    data class ClickedOnCurrentWeather(val cityId: CityId) : UIEventHomeScreen
}

typealias OnUIEventHomeScreen = (UIEventHomeScreen) -> Unit
