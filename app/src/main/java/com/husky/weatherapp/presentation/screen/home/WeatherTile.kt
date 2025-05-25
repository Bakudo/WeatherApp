package com.husky.weatherapp.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.husky.weatherapp.R

@Composable
fun WeatherTile(
    modifier: Modifier,
    location: String,
    temperature: String,
    weatherCondition: String,
    icon: String
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(shape = RoundedCornerShape(16.dp), color = White)
            .padding(16.dp)
            .then(modifier)
    ) {
        TextRow(stringResource(R.string.location), location)
        TextRow(stringResource(R.string.temperature), temperature)
        TextRow(stringResource(R.string.condition), weatherCondition)
        TextRow(stringResource(R.string.icon), icon)
    }
}

@Composable
fun TextRow(label: String, value: String) {
    Text(modifier = Modifier.fillMaxWidth(), text = "$label : $value")
}