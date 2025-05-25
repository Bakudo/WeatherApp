package com.husky.weatherapp.presentation.screen.details

import com.husky.weatherapp.presentation.base.BaseViewModel

class DetailsScreenViewModel : BaseViewModel<UIStateDetailsScreen, UIEventDetailsScreen>() {

    override fun getDefaultUIState(): UIStateDetailsScreen = DEFAULT_UI_STATE


    override fun onEvent(event: UIEventDetailsScreen) {
    }


    companion object {
        val DEFAULT_UI_STATE = UIStateDetailsScreen("test state")
    }
}