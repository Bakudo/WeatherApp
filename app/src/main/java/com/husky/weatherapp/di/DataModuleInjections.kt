package com.husky.weatherapp.di

import com.husky.weatherapp.data.remote.api.WeatherApiService
import com.husky.weatherapp.data.repository.WeatherRepository
import com.husky.weatherapp.data.repository.WeatherRepositoryImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModuleInjections = module {
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }
    single<Retrofit>(named("weather")) {
        Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<WeatherApiService> {
        get<Retrofit>(named("weather")).create(WeatherApiService::class.java)
    }

    single<WeatherRepository> { WeatherRepositoryImpl(get()) }
}