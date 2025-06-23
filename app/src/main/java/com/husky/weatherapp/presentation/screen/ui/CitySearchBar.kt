package com.husky.weatherapp.presentation.screen.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.husky.weatherapp.R
import com.husky.weatherapp.domain.model.LocationEntity
import com.husky.weatherapp.presentation.screen.ui.UISearchEvent.UserInput

@Composable
fun SearchBarRow(
    enteredCity: String?,
    queryHistory: List<String>,
    canShowLastUsedQueries: Boolean,
    onEvent: OnUISearchEvent,
) {
    Column(verticalArrangement = Arrangement.Center) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            PrimaryEditText(text = enteredCity, modifier = Modifier.fillMaxWidth(), placeholder = {
                Text(
                    stringResource(R.string.city_search_placeholder), style = TextStyle(
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontSize = TextUnit(18f, TextUnitType.Sp),
                    )
                )
            }, onTextChanged = { onEvent(UserInput(it)) }, onEnterPressed = {
                onEvent(UISearchEvent.OnUserEnterPressed)
            })
            Spacer(modifier = Modifier.width(12.dp))
        }
        if (canShowLastUsedQueries) {
            LastQueriesList(queryHistory)
        }
    }
}

@Composable
fun LastQueriesList(queryHistory: List<String>) {
    Column(
        modifier = Modifier
            .size(100.dp)
            .background(color = Color.Red),
        verticalArrangement = Arrangement.Center
    ) {
        queryHistory.forEach { query ->
            HistoryQueryItem(query) { }
        }
    }
}

@Composable
fun HistoryQueryItem(query: String, onClick: OnHistoryClick) {
    Box(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(shape = RoundedCornerShape(8.dp), color = White)
            .padding(horizontal = 8.dp)
            .clickable { onClick(query) },
        contentAlignment = Alignment.CenterStart
    ) {
        Text(query)
    }
}

typealias OnHistoryClick = (String) -> Unit

sealed interface UISearchEvent {
    data class UserInput(val query: String = "") : UISearchEvent
    data object OnUserEnterPressed : UISearchEvent
    data object OnClearClicked : UISearchEvent
}

typealias OnUISearchEvent = (UISearchEvent) -> Unit