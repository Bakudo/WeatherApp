package com.husky.weatherapp.presentation.base

interface ViewModelInterface<UIState, UIEvent> {

    val uiState: UIState

    fun onEvent(event: UIEvent)

}