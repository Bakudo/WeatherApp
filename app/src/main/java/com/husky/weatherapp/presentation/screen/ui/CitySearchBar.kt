package com.husky.weatherapp.presentation.screen.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.husky.weatherapp.R
import com.husky.weatherapp.presentation.screen.ui.UISearchEvent.UserInput

@Composable
fun SearchBarRow(
    enteredCity: String?,
    onEvent: OnUISearchEvent,
) {
    Column(verticalArrangement = Arrangement.Center) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            PrimaryEditText(
                text = enteredCity,
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        stringResource(R.string.city_search_placeholder),
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontWeight = FontWeight.Normal,
                            fontSize = TextUnit(18f, TextUnitType.Sp),
                        )
                    )
                })
            {
                onEvent(UserInput(it))
            }
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
}

sealed interface UISearchEvent {
    data class UserInput(val query: String = "") : UISearchEvent
    data object OnClearClicked : UISearchEvent
}

typealias OnUISearchEvent = (UISearchEvent) -> Unit