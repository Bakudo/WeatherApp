package com.husky.weatherapp.presentation.screen.home

import android.location.Location
import androidx.lifecycle.viewModelScope
import com.husky.weatherapp.data.repository.WeatherRepository
import com.husky.weatherapp.data.system.LocationService
import com.husky.weatherapp.domain.usecase.SearchForCityList
import com.husky.weatherapp.presentation.base.BaseViewModel
import com.husky.weatherapp.presentation.navigation.NavigationController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val navigationController: NavigationController,
    private val repository: WeatherRepository,
    private val locationProvider: LocationService,
    private val searchForCityList: SearchForCityList,
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
            is UIEventHomeScreen.CityQuery -> fetchCityLocations(event.query)
        }
    }


    private fun fetchCityLocations(cityQuery: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = searchForCityList.invoke(cityQuery)
            result.onSuccess { res ->
                res.forEach {
                    println("${it.admin1} ,${it.admin2}")
                }
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
        val DEFAULT_UI_STATE = UIStateHomeScreen(null)
    }
}