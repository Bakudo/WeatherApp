package com.husky.weatherapp.domain.model

data class CurrentWeatherForecast(
    val time: String,
    val tempMin: Double,
    val tempMax: Double,
    val weather_code: Int,
)