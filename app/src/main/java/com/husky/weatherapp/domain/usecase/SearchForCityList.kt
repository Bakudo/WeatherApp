package com.husky.weatherapp.domain.usecase

import com.husky.weatherapp.data.repository.LocationRepository
import com.husky.weatherapp.domain.model.LocationEntity
import okio.IOException

class SearchForCityList(private val repository: LocationRepository) {
    suspend operator fun invoke(cityName: String): Result<List<LocationEntity>> {
        if (cityName.isBlank() || cityName.length < 2) {
            return Result.failure(IllegalArgumentException("City name must be at least 2 characters"))
        }
        return try {
            val result = repository.searchCities(cityName.trim())
            result.map { locations ->
                locations.filter { it.population != null }
                    .take(5)
            }
        } catch (e: Exception) {
            when (e) {
                is IOException -> Result.failure(NetworkException("Network connectivity issue"))
                else -> Result.failure(SearchException("Unable to search for cities"))
            }
        }
    }
}

class NetworkException(message: String) : Exception(message)
class SearchException(message: String) : Exception(message)
