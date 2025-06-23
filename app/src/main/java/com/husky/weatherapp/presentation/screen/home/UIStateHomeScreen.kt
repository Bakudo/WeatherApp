package com.husky.weatherapp.presentation.screen.home

import android.location.Location
import com.husky.weatherapp.domain.model.CurrentWeather
import com.husky.weatherapp.domain.model.CurrentWeatherForecast
import com.husky.weatherapp.domain.model.LocationEntity
import com.husky.weatherapp.presentation.screen.home.Constants.possibleQueriesSavedCount
import java.util.LinkedList

data class UIStateHomeScreen(
    val currentLocation: Location? = null,
    val cityQuery: String? = null,
    val citiesFromQuery: List<LocationEntity>,
    val selectedCity: LocationEntity? = null,
    val currentWeather: CurrentWeather? = null,
    val forecastedWeather: List<CurrentWeatherForecast>,
    val dataState: DataState = DataState.IDLE,
    val lastUsedQueries: List<String> = listOf<String>(),
    val canShowLastUsedQueries: Boolean = false
) {

    fun addQuery(query: String): UIStateHomeScreen {
        val updatedQueries = LinkedList(lastUsedQueries)
        updatedQueries.addLast(query)

        // Remove oldest if over capacity
        if (updatedQueries.size > possibleQueriesSavedCount) {
             updatedQueries.removeFirst()
        }
        print("UpdatedQuery "+updatedQueries)
        return copy(lastUsedQueries = updatedQueries)
    }

    fun updateQuerryVisibility(): UIStateHomeScreen {
        val canSHow = lastUsedQueries.isNotEmpty() ?: false
        return copy(canShowLastUsedQueries = canSHow)
    }

}

sealed interface DataState {
    data object IDLE : DataState
    data object LOADING : DataState
    data class ERROR(val message: String) : DataState
}

data object Constants {
    const val possibleQueriesSavedCount: Int = 3

}