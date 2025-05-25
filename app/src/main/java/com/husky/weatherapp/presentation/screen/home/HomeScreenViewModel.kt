package com.husky.weatherapp.presentation.screen.home

import androidx.lifecycle.viewModelScope
import com.husky.weatherapp.data.repository.WeatherRepository
import com.husky.weatherapp.presentation.base.BaseViewModel
import com.husky.weatherapp.presentation.navigation.NavigationController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val navigationController: NavigationController,
    private val repository: WeatherRepository,
) : BaseViewModel<UIStateHomeScreen, UIEventHomeScreen>() {

    override fun getDefaultUIState(): UIStateHomeScreen = DEFAULT_UI_STATE

    override fun onEvent(event: UIEventHomeScreen) {
        when (event) {
            UIEventHomeScreen.Placeholder -> {
//                navigationController.navigateTo(NavigationRoute.WeatherDetailsRoute())
                viewModelScope.launch(Dispatchers.IO) {
                    val result = repository.getCurrentWeather(52.23560295113302, 20.998363572142697)
                    result.onSuccess {
                        println(it)
                    }
                    result.onFailure {
                        println(it)
                    }
                }
            }
        }
    }


    companion object {
        val DEFAULT_UI_STATE = UIStateHomeScreen("test state")
    }
}