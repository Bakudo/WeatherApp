package com.husky.weatherapp.domain.usecase

import com.husky.weatherapp.domain.model.LocationEntity

class SearchByCityNameUseCase {
    suspend operator fun invoke(cityName: String): Result<List<LocationEntity>> {
        return Result.success(emptyList())
    }
}