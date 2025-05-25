package com.husky.weatherapp.presentation.screen.home

import android.location.Location
import com.husky.weatherapp.domain.model.CurrentWeather
import com.husky.weatherapp.domain.model.CurrentWeatherForecast
import com.husky.weatherapp.domain.model.LocationEntity

data class UIStateHomeScreen(
    val currentLocation: Location? = null,
    val cityQuery: String? = null,
    val citiesFromQuery: List<LocationEntity>,
    val selectedCity: LocationEntity? = null,
    val currentWeather: CurrentWeather? = null,
    val forecastedWeather: List<CurrentWeatherForecast>,
    val dataState: DataState = DataState.IDLE
)

sealed interface DataState {
    data object IDLE : DataState
    data object LOADING : DataState
    data class ERROR(val message: String) : DataState
}