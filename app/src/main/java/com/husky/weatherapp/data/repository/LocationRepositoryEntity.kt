package com.husky.weatherapp.data.repository

import com.husky.weatherapp.data.mapper.LocationMapper
import com.husky.weatherapp.data.remote.api.GeocodingApiService
import com.husky.weatherapp.domain.model.LocationEntity

class LocationRepositoryImpl(
    private val geocodingApiService: GeocodingApiService
) : LocationRepository {

    override suspend fun searchCities(query: String): Result<List<LocationEntity>> {
        return try {
            val response = geocodingApiService.searchCities(query)
            val locations = LocationMapper.mapToDomain(response)
            Result.success(locations)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}