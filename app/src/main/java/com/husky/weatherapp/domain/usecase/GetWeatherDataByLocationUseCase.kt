package com.husky.weatherapp.domain.usecase

import android.location.Location
import com.husky.weatherapp.data.repository.WeatherRepository
import com.husky.weatherapp.domain.model.LocationEntity
import com.husky.weatherapp.domain.model.WeatherResponse

class GetWeatherDataByLocationUseCase(private val repository: WeatherRepository) {
    suspend operator fun invoke(location: LocationEntity): Result<WeatherResponse> {
        return repository.getCurrentWeather(location.latitude, location.longitude)
    }

    suspend fun locationOnly(location: Location): Result<WeatherResponse> {
        return repository.getCurrentWeather(location.latitude, location.longitude)
    }
}