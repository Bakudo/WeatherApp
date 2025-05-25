package com.husky.weatherapp.data.repository

import com.husky.weatherapp.data.mapper.WeatherMapper
import com.husky.weatherapp.data.remote.api.WeatherApiService
import com.husky.weatherapp.domain.model.WeatherResponse

class WeatherRepositoryImpl(
    private val weatherApiService: WeatherApiService,
) : WeatherRepository {

    override suspend fun getCurrentWeather(lat: Double, lon: Double): Result<WeatherResponse> {
        return try {
            val response = weatherApiService.getCurrentWeather(lat, lon)
            val domainModel = WeatherMapper.mapWeatherResponseToDomain(response)
            Result.success(domainModel)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}