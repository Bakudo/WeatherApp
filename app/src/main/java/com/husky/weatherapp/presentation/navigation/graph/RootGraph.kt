package com.husky.weatherapp.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.husky.weatherapp.presentation.navigation.custom.CustomNavType
import com.husky.weatherapp.presentation.navigation.route.NavigationRoute
import com.husky.weatherapp.presentation.navigation.route.NavigationRoute.HomeRoute
import com.husky.weatherapp.presentation.navigation.route.WeatherParams
import com.husky.weatherapp.presentation.screen.details.DetailsScreen
import com.husky.weatherapp.presentation.screen.details.DetailsScreenViewModel
import com.husky.weatherapp.presentation.screen.home.HomeScreen
import com.husky.weatherapp.presentation.screen.home.HomeScreenViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import kotlin.reflect.typeOf

@Composable
fun RootGraph(
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {
        composable<HomeRoute> {
            val viewModel: HomeScreenViewModel = koinViewModel()
            HomeScreen(viewModel, onEvent = viewModel::onEvent)
        }

        composable<NavigationRoute.WeatherDetailsRoute>(
            typeMap = mapOf(
                typeOf<WeatherParams>() to CustomNavType.WeatherDetailsNavType
            )
        ) { backStackEntry ->
            val navParams = backStackEntry.toRoute<NavigationRoute.WeatherDetailsRoute>()
            val viewModel: DetailsScreenViewModel = koinViewModel {
                parametersOf(navParams.detailParams.data)
            }
            DetailsScreen(uiState = viewModel.uiState, onEvent = { viewModel.onEvent(it) })
        }
    }
}
