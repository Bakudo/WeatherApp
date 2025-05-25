package com.husky.weatherapp.presentation.screen.details

import com.husky.weatherapp.presentation.base.BaseViewModel
import com.husky.weatherapp.presentation.navigation.route.NavigationRoute

class DetailsScreenViewModel : BaseViewModel<UIStateDetailsScreen, UIEventDetailsScreen>() {

    override fun getDefaultUIState(): UIStateDetailsScreen = DEFAULT_UI_STATE

    override fun handleNavigation() {
        super.handleNavigation()
        getParams<NavigationRoute.WeatherDetailsRoute> { navParams ->
            val params = navParams.detailParams
            params.location?.let {
                params.weather?.let {
                    newState = uiState.copy(weather = params.weather, location = params.location)
                }
            }
        }
    }

    override fun onEvent(event: UIEventDetailsScreen) {
    }


    companion object {
        val DEFAULT_UI_STATE = UIStateDetailsScreen()
    }
}