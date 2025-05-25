package com.husky.weatherapp.data.mapper

object WeatherCodeMapper {
    fun getWeatherCondition(code: Int): WeatherCondition {
        return weatherConditions[code] ?: WeatherCondition(
            description = "Unknown",
            icon = "❓",
            category = WeatherCategory.UNKNOWN
        )
    }

    private val weatherConditions = mapOf(
        // Clear Sky
        0 to WeatherCondition("Clear sky", "☀️", WeatherCategory.CLEAR),
        1 to WeatherCondition("Mainly clear", "🌤️", WeatherCategory.CLEAR),
        2 to WeatherCondition("Partly cloudy", "⛅", WeatherCategory.CLOUDY),
        3 to WeatherCondition("Overcast", "☁️", WeatherCategory.CLOUDY),

        // Fog
        45 to WeatherCondition("Fog", "🌫️", WeatherCategory.FOG),
        48 to WeatherCondition("Depositing rime fog", "🌫️", WeatherCategory.FOG),

        // Drizzle
        51 to WeatherCondition("Light drizzle", "🌦️", WeatherCategory.DRIZZLE),
        53 to WeatherCondition("Moderate drizzle", "🌦️", WeatherCategory.DRIZZLE),
        55 to WeatherCondition("Dense drizzle", "🌧️", WeatherCategory.DRIZZLE),

        // Rain
        61 to WeatherCondition("Slight rain", "🌧️", WeatherCategory.RAIN),
        63 to WeatherCondition("Moderate rain", "🌧️", WeatherCategory.RAIN),
        65 to WeatherCondition("Heavy rain", "⛈️", WeatherCategory.RAIN),

        // Snow
        71 to WeatherCondition("Slight snow", "🌨️", WeatherCategory.SNOW),
        73 to WeatherCondition("Moderate snow", "❄️", WeatherCategory.SNOW),
        75 to WeatherCondition("Heavy snow", "❄️", WeatherCategory.SNOW),

        // Showers
        80 to WeatherCondition("Slight rain showers", "🌦️", WeatherCategory.SHOWERS),
        81 to WeatherCondition("Moderate rain showers", "🌧️", WeatherCategory.SHOWERS),
        82 to WeatherCondition("Violent rain showers", "⛈️", WeatherCategory.SHOWERS),

        // Thunderstorm
        95 to WeatherCondition("Thunderstorm", "⛈️", WeatherCategory.THUNDERSTORM),
        96 to WeatherCondition("Thunderstorm with hail", "⛈️", WeatherCategory.THUNDERSTORM),
        99 to WeatherCondition("Thunderstorm with heavy hail", "⛈️", WeatherCategory.THUNDERSTORM)
    )
}

data class WeatherCondition(
    val description: String,
    val icon: String,
    val category: WeatherCategory
)

enum class WeatherCategory {
    CLEAR, CLOUDY, FOG, DRIZZLE, RAIN, SNOW, SHOWERS, THUNDERSTORM, UNKNOWN
}