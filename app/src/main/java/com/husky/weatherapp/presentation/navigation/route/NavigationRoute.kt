package com.husky.weatherapp.presentation.navigation.route

import com.husky.weatherapp.domain.model.CurrentWeather
import com.husky.weatherapp.domain.model.LocationEntity
import kotlinx.serialization.Serializable

@Serializable
sealed interface NavigationRoute {
    @Serializable
    data object HomeRoute : NavigationRoute

    @Serializable
    data class WeatherDetailsRoute(val detailParams: WeatherParams = WeatherParams()) :
        NavigationRoute
}

@Serializable
data class WeatherParams(
    val weather: CurrentWeather? = null,
    val location: LocationEntity? = null,
)
