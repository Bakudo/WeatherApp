package com.husky.weatherapp.presentation.base

import android.location.Location
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.husky.weatherapp.presentation.navigation.NavigationController
import com.husky.weatherapp.presentation.navigation.route.NavigationRoute
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseViewModel<UIState, UIEvent> :
    ViewModel(),
    KoinComponent,
    ViewModelInterface<UIState, UIEvent> {

    val navController: NavigationController by inject()

    abstract fun getDefaultUIState(): UIState

    /**
     * delegation for uiState,
     * so we don't need to do uiState.value = value, just uiState = value
     */
    override var uiState: UIState by UIStateDelegate(mutableStateOf(getDefaultUIState()))

    init {
        handleNavigation()
    }

    open fun handleLifecycleState(lifecycleState: Lifecycle.State) {
        when (lifecycleState) {
            Lifecycle.State.CREATED -> {
                handleCreated()
            }

            Lifecycle.State.STARTED -> {
                handleStarted()
            }

            Lifecycle.State.RESUMED -> handleResumed()
            else -> {}
        }
    }

    protected open fun handleResumed() {}
    protected open fun handleCreated() {}
    protected open fun handleStarted() {}


    /**
     * shortcut for setting value to state
     * example :
     * newState = uiState.value.copy(...)
     * or
     * newState = uiState.copy(...) if delegation has been used
     */
    var newState: UIState = uiState
        set(value) {
            uiState = value
        }

    protected open fun handleNavigation() {

    }

    protected inline fun <reified T> getParams(callback: (para: T) -> Unit) {
        val backStackEntry =
            navController.getCurrentNavController()?.currentBackStackEntry ?: return
        callback(backStackEntry.toRoute<T>())
    }

    protected fun navigateTo(navRoute: NavigationRoute) = navController.navigateTo(navRoute)

    protected fun goBack() = navController.navigateBack()

}
