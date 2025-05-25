package com.husky.weatherapp

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.navigation.compose.rememberNavController
import com.husky.weatherapp.presentation.navigation.NavigationController
import com.husky.weatherapp.presentation.navigation.NavigationControllerImpl
import com.husky.weatherapp.presentation.navigation.graph.RootGraph
import com.husky.weatherapp.presentation.ui.theme.WeatherAppTheme
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        requestPermissions()
        setContent {
            WeatherAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    innerPadding
                    val navController = koinInject<NavigationController>()
                    val navHostController = rememberNavController()
                    (navController as? NavigationControllerImpl)?.setNavController(
                        navHostController
                    )
                    RootGraph(navController = navHostController)
                }
            }
        }
    }

    fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this, arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ), 0
        )
    }
}