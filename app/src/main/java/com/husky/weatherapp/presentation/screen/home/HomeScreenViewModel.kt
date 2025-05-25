package com.husky.weatherapp.presentation.screen.home

import android.location.Location
import androidx.lifecycle.viewModelScope
import com.husky.weatherapp.data.system.LocationService
import com.husky.weatherapp.domain.model.CurrentWeatherForecast
import com.husky.weatherapp.domain.model.DailyForecast
import com.husky.weatherapp.domain.usecase.GetWeatherDataByLocationUseCase
import com.husky.weatherapp.domain.usecase.SearchForCityList
import com.husky.weatherapp.presentation.base.BaseViewModel
import com.husky.weatherapp.presentation.navigation.NavigationController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val navigationController: NavigationController,
    private val locationProvider: LocationService,
    private val searchForCityList: SearchForCityList,
    private val getWeatherForCity: GetWeatherDataByLocationUseCase,
) : BaseViewModel<UIStateHomeScreen, UIEventHomeScreen>() {

    override fun getDefaultUIState(): UIStateHomeScreen = DEFAULT_UI_STATE

    override fun handleCreated() {
        super.handleCreated()
    }

    override fun handleResumed() {
        super.handleResumed()

        viewModelScope.launch {
            val location = locationProvider.getCurrentLocation()
            location.onSuccess { newLocation ->
                println(newLocation)
                if (canUpdateLocation(newLocation)) {
                    newState = uiState.copy(currentLocation = newLocation)
//                    loadCurrentForecast(newLocation)
                } else {
                    println("Location is the same")
                }

            }
            location.onFailure {
                println(it)
            }
        }
    }

    private fun canUpdateLocation(newLocation: Location): Boolean =
        uiState.currentLocation?.latitude != newLocation.latitude || uiState.currentLocation?.longitude != newLocation.longitude

    override fun handleStarted() {
        super.handleStarted()
    }

    override fun onEvent(event: UIEventHomeScreen) {
        when (event) {
            is UIEventHomeScreen.CityQuery -> {
                newState = uiState.copy(cityQuery = event.query)
                fetchCityLocations(event.query)
            }

            is UIEventHomeScreen.CitySelected -> {
                uiState.citiesFromQuery.firstOrNull { it.id == event.cityId }?.let { selectedCity ->
                    newState = uiState.copy(
                        selectedCity = selectedCity,
                        cityQuery = null,
                        citiesFromQuery = emptyList()
                    )
                    println("City selected: ${selectedCity.getDisplayName()}")
                    fetchWeatherForSelectedCity()
                }
            }
        }
    }

    private fun fetchWeatherForSelectedCity() {
        uiState.selectedCity?.let { city ->
            viewModelScope.launch(Dispatchers.IO) {
                val weather = getWeatherForCity.invoke(city)
                weather.onSuccess {
                    newState =
                        uiState.copy(
                            currentWeather = it.current,
                            forecastedWeather = it.daily?.toObjectsList() ?: emptyList()
                        )
                    println("Weather $it")
                }
            }
        }
    }

    private fun fetchCityLocations(cityQuery: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = searchForCityList.invoke(cityQuery)
            result.onSuccess { cities ->
                newState = uiState.copy(citiesFromQuery = cities)
            }
        }
//        viewModelScope.launch(Dispatchers.IO) {
//            val result = repository.getCurrentWeather(location.latitude, location.longitude)
//            result.onSuccess {
//                println("Location loaded : $it")
//            }
//            result.onFailure {
//                println("Location failure : $it")
//            }
//        }
    }


    companion object {
        val DEFAULT_UI_STATE = UIStateHomeScreen(citiesFromQuery = emptyList(), forecastedWeather = emptyList())
    }
}

fun DailyForecast.toObjectsList(): List<CurrentWeatherForecast> =
    buildList<CurrentWeatherForecast> {
        time.forEachIndexed { index, time ->
            add(
                CurrentWeatherForecast(
                    time = time,
                    tempMin = temperature_2m_min.getOrElse(index) { 0.0 },
                    tempMax = temperature_2m_max.getOrElse(index) { 0.0 },
                    weather_code = weather_code.getOrElse(index) { 0 }
                )
            )
        }
    }
