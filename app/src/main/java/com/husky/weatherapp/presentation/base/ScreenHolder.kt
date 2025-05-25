package com.husky.weatherapp.presentation.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.currentStateAsState

@Composable
fun <UIState, UIEvent> ScreenHolder(
    viewModel: BaseViewModel<UIState, UIEvent>,
    contentTopPadding: Dp = 0.dp,
    content: @Composable () -> Unit,
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val lifecycleState by lifecycle.currentStateAsState()

    LaunchedEffect(lifecycleState) {
        viewModel.handleLifecycleState(lifecycleState)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = contentTopPadding)
    ) {
        content()
    }
}