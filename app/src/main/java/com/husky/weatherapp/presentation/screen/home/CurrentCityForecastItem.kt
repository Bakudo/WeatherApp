package com.husky.weatherapp.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.husky.weatherapp.R
import com.husky.weatherapp.data.mapper.WeatherCodeMapper
import com.husky.weatherapp.domain.model.CurrentWeatherForecast

@Composable
fun CurrentCityForecastItem(forecast: CurrentWeatherForecast) {
    Column(
        Modifier.Companion
            .fillMaxWidth()
            .background(Color.Companion.White.copy(0.5f))
    ) {
        val condition = WeatherCodeMapper.getWeatherCondition(forecast.weather_code)
        TextRow(stringResource(R.string.date), forecast.time)
        TextRow(
            "${stringResource(R.string.mintemp)}/${stringResource(R.string.maxtemp)}",
            "${forecast.tempMin}/${forecast.tempMax}"
        )
        TextRow(stringResource(R.string.condition_short), condition.description)
        TextRow(stringResource(R.string.icon), condition.icon)
    }
}