package com.husky.weatherapp.presentation.navigation.route

import com.husky.weatherapp.domain.entity.WeatherDetailsEntity
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
data class WeatherParams(val data: WeatherDetailsEntity? = null)
