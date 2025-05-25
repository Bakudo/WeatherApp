package com.husky.weatherapp.presentation.base

import androidx.compose.runtime.MutableState
import kotlin.reflect.KProperty

class UIStateDelegate<CustomState>(private val state: MutableState<CustomState>) {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): CustomState = state.value

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: CustomState) {
        state.value = value
    }
}
