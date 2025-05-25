package com.husky.weatherapp.data.repository

import com.husky.weatherapp.domain.model.WeatherResponse

interface WeatherRepository {
    suspend fun getCurrentWeather(lat: Double, lon: Double): Result<WeatherResponse>
}