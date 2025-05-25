package com.husky.weatherapp.presentation.screen.home

sealed interface UIEventHomeScreen {
    data object Placeholder : UIEventHomeScreen
}

typealias OnUIEventHomeScreen = (UIEventHomeScreen) -> Unit
