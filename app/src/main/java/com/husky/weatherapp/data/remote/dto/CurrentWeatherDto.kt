package com.husky.weatherapp.data.remote.dto

data class CurrentWeatherDto(
    val temperature_2m: Double,
    val relative_humidity_2m: Int,
    val wind_speed_10m: Double,
    val weather_code: Int,
    val time: String
)