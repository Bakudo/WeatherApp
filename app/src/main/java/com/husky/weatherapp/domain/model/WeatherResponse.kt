package com.husky.weatherapp.domain.model

data class WeatherResponse(
    val latitude: Double,
    val longitude: Double,
    val current: CurrentWeather,
    val daily: DailyForecast?
)