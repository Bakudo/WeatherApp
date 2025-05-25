package com.husky.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.husky.weatherapp.presentation.navigation.NavigationController
import com.husky.weatherapp.presentation.navigation.NavigationControllerImpl
import com.husky.weatherapp.presentation.navigation.graph.RootGraph
import com.husky.weatherapp.presentation.ui.theme.WeatherAppTheme
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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
}