package com.husky.weatherapp.data.remote.dto

data class LocationDto(
    val id: Int,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val country: String,
    val admin1: String?, // this is state
    val admin2: String?, // this is province
    val population: Int?,
    val timezone: String?
)