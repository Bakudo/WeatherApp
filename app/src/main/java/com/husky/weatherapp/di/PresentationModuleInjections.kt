package com.husky.weatherapp.di

import com.husky.weatherapp.presentation.navigation.NavigationController
import com.husky.weatherapp.presentation.navigation.NavigationControllerImpl
import com.husky.weatherapp.presentation.screen.details.DetailsScreenViewModel
import com.husky.weatherapp.presentation.screen.home.HomeScreenViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModuleInjections = module {
    viewModelOf(::HomeScreenViewModel)
    viewModelOf(::DetailsScreenViewModel)
    singleOf(::NavigationControllerImpl) { bind<NavigationController>() }

}