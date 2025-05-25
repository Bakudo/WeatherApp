package com.husky.weatherapp.presentation.screen.home

import android.location.Location
import com.husky.weatherapp.domain.model.CurrentWeather

data class UIStateHomeScreen(
    val currentLocation: Location? = null,
    val cityQuery: String? = null,
    val currentWeather: CurrentWeather? = null
)
