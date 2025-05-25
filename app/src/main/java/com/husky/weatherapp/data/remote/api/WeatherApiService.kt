package com.husky.weatherapp.data.remote.api

import com.husky.weatherapp.data.remote.dto.WeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("v1/forecast")
    suspend fun getCurrentWeather(
        @Query("latitude") lat: Double,
        @Query("longitude") lon: Double,
        @Query("current") current: String = "",
        @Query("daily") daily: String = "",
        @Query("forecast_days") days: Int = 5,
        @Query("timezone") timezone: String = "auto"
    ): WeatherResponseDto
}