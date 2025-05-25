package com.husky.weatherapp.data.remote.dto

data class WeatherResponseDto(
    val latitude: Double,
    val longitude: Double,
    val current: CurrentWeatherDto,
    val daily: DailyForecastDto?
)
