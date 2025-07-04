package com.husky.weatherapp.di

import com.husky.weatherapp.domain.usecase.GetWeatherDataByLocationUseCase
import com.husky.weatherapp.domain.usecase.SearchForCityList
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModuleInjections = module {
    singleOf(::SearchForCityList)
    singleOf(::GetWeatherDataByLocationUseCase)
}