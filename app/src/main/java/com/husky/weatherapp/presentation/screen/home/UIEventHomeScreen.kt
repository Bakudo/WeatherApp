package com.husky.weatherapp.presentation.screen.home

sealed interface UIEventHomeScreen {
    data class CityQuery(val query: String) : UIEventHomeScreen
}

typealias OnUIEventHomeScreen = (UIEventHomeScreen) -> Unit
