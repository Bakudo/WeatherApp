package com.husky.weatherapp.presentation.screen.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryEditText(
    text: String?,
    modifier: Modifier = Modifier,
    trailingIcon: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    onTextChanged: OnTextChanged,
    onEnterPressed: OnEnterPressed
) {

    val focusManager = LocalFocusManager.current


    val clickModifier = Modifier.onPreviewKeyEvent {
        if (it.type == KeyEventType.KeyUp && it.key == Key.Enter) {
            focusManager.moveFocus(FocusDirection.Next)
            onEnterPressed()
            true
        } else {
            false
        }
    }

    val text: String = text ?: ""
    var textFieldValue by remember {
        mutableStateOf(
            TextFieldValue(
                text = text, selection = TextRange(text.length)
            )
        )
    }
    LaunchedEffect(text) {
        if (text != textFieldValue.text) {
            textFieldValue = textFieldValue.copy(text = text)
        }
    }

    val roundness = 8.dp
    TextField(
        modifier = modifier.then(
            Modifier
                .background(color = Color(0xFFF0F4FA), shape = RoundedCornerShape(roundness))
                .then(clickModifier)
        ), value = textFieldValue, colors = TextFieldDefaults.colors(
            focusedTextColor = Color(0xFF3A506B),
            unfocusedTextColor = Color(0xFF3A506B),
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
            errorContainerColor = Color.Transparent,
        ), onValueChange = { newValue ->
            textFieldValue = newValue
            onTextChanged(newValue.text)
        }, trailingIcon = trailingIcon,
        singleLine = true,
        placeholder = placeholder
    )
}

typealias OnTextChanged = (String) -> Unit
typealias OnEnterPressed = () -> Unit
