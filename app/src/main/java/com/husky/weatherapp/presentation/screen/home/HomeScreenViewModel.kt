package com.husky.weatherapp.presentation.screen.home

import com.husky.weatherapp.presentation.base.BaseViewModel
import com.husky.weatherapp.presentation.navigation.NavigationController
import com.husky.weatherapp.presentation.navigation.route.NavigationRoute

class HomeScreenViewModel(
    private val navigationController: NavigationController
) : BaseViewModel<UIStateHomeScreen, UIEventHomeScreen>() {

    override fun getDefaultUIState(): UIStateHomeScreen = DEFAULT_UI_STATE

    override fun onEvent(event: UIEventHomeScreen) {
        when (event) {
            UIEventHomeScreen.Placeholder -> navigationController.navigateTo(NavigationRoute.WeatherDetailsRoute())
        }
    }


    companion object {
        val DEFAULT_UI_STATE = UIStateHomeScreen("test state")
    }
}