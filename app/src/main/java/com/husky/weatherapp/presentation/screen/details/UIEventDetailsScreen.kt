package com.husky.weatherapp.presentation.screen.details

sealed interface UIEventDetailsScreen {
    data object Placeholder : UIEventDetailsScreen
}

typealias OnUIEventDetailsScreen = (UIEventDetailsScreen) -> Unit
