package com.husky.weatherapp.presentation.screen.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeatherTileDetailed(
    location: String,
    temperature: String,
    weatherCondition: String,
    winSpeed: Double,
    humidity: Int,
    icon: String
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(shape = RoundedCornerShape(16.dp), color = White)
            .padding(16.dp)
    ) {
        Text(modifier = Modifier.fillMaxWidth(), text = location, fontSize = 36.sp)
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = temperature,
            fontSize = 36.sp
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = weatherCondition,
            fontSize = 26.sp
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = icon,
            fontSize = 46.sp
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = winSpeed.toString(),
            fontSize = 26.sp
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = humidity.toString(),
            fontSize = 26.sp
        )

    }
}
