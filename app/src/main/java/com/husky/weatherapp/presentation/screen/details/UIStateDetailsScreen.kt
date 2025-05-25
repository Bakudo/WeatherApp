package com.husky.weatherapp.presentation.screen.details

import com.husky.weatherapp.domain.model.CurrentWeather
import com.husky.weatherapp.domain.model.LocationEntity


data class UIStateDetailsScreen(
    val location: LocationEntity? = null,
    val weather: CurrentWeather? = null
)
