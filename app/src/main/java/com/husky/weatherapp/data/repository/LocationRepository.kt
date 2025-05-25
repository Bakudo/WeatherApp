package com.husky.weatherapp.data.repository

import com.husky.weatherapp.domain.model.LocationEntity

interface LocationRepository {
    suspend fun searchCities(query: String): Result<List<LocationEntity>>
}
