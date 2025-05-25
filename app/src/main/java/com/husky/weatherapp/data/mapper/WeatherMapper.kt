package com.husky.weatherapp.data.mapper

import com.husky.weatherapp.data.remote.dto.CurrentWeatherDto
import com.husky.weatherapp.data.remote.dto.DailyForecastDto
import com.husky.weatherapp.data.remote.dto.WeatherResponseDto
import com.husky.weatherapp.domain.model.CurrentWeather
import com.husky.weatherapp.domain.model.DailyForecast
import com.husky.weatherapp.domain.model.WeatherResponse

object WeatherMapper {

    fun mapWeatherResponseToDomain(dto: WeatherResponseDto): WeatherResponse {
        return WeatherResponse(
            latitude = dto.latitude,
            longitude = dto.longitude,
            current = mapCurrentWeatherToDomain(dto.current),
            daily = dto.daily?.let { mapDailyForecastToDomain(it) }
        )
    }

    private fun mapCurrentWeatherToDomain(dto: CurrentWeatherDto): CurrentWeather {
        return CurrentWeather(
            temperature_2m = dto.temperature_2m,
            relative_humidity_2m = dto.relative_humidity_2m,
            wind_speed_10m = dto.wind_speed_10m,
            weather_code = dto.weather_code,
            time = dto.time
        )
    }

    private fun mapDailyForecastToDomain(dto: DailyForecastDto): DailyForecast {
        return DailyForecast(
            time = dto.time,
            temperature_2m_max = dto.temperature_2m_max,
            temperature_2m_min = dto.temperature_2m_min,
            weather_code = dto.weather_code
        )
    }
}