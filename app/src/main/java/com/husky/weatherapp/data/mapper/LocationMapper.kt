package com.husky.weatherapp.data.mapper

import com.husky.weatherapp.data.remote.dto.GeocodingResponseDto
import com.husky.weatherapp.domain.model.LocationEntity

object LocationMapper {

    fun mapToDomain(dto: GeocodingResponseDto): List<LocationEntity> {
        return dto.results?.map { locationDto ->
            LocationEntity(
                id = locationDto.id,
                name = locationDto.name,
                latitude = locationDto.latitude,
                longitude = locationDto.longitude,
                country = locationDto.country,
                admin1 = locationDto.admin1,
                admin2 = locationDto.admin2,
                population = locationDto.population,
                timezone = locationDto.timezone
            )
        } ?: emptyList()
    }
}