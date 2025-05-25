package com.husky.weatherapp.presentation.navigation.custom

import com.husky.weatherapp.presentation.navigation.route.WeatherParams
import kotlin.reflect.typeOf

object CustomNavType {
    val MemeEditorNavType = SerializableNavType<WeatherParams>(
        type = typeOf<WeatherParams>(),
        isNullableAllowed = false
    )
}