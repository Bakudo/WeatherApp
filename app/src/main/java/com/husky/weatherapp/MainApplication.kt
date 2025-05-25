package com.husky.weatherapp

import android.app.Application
import com.husky.weatherapp.di.dataModuleInjections
import com.husky.weatherapp.di.domainModuleInjections
import com.husky.weatherapp.di.presentationModuleInjections
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MainApplication)
            modules(
                listOf(
                    presentationModuleInjections,
                    dataModuleInjections,
                    domainModuleInjections
                )
            )
        }
    }

}