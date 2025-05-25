package com.husky.weatherapp.domain.model

data class LocationEntity(
    val id: Int,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val country: String,
    val admin1: String?, // this is state
    val admin2: String?, // this is province
    val population: Int?,
    val timezone: String?
) {
    fun getDisplayName(): String {
        return buildString {
            append(name)
            admin1?.let { append(", $it") }
            append(", $country")
        }
    }
}