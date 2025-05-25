package com.husky.weatherapp.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.husky.weatherapp.domain.model.LocationEntity
import com.husky.weatherapp.domain.value.CityId

@Composable
fun CityResultList(cities: List<LocationEntity>, onClickId: OnClickId) {

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(items = cities, key = { city -> city.id }) { location ->
            CityResultItem(location, onClickId)
        }
    }

}


@Composable
fun CityResultItem(location: LocationEntity, onClick: OnClickId) {
    Box(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(shape = RoundedCornerShape(8.dp), color = White)
            .padding(horizontal = 8.dp)
            .clickable { onClick(CityId(location.id)) },
        contentAlignment = Alignment.CenterStart
    ) {
        Text(location.getDisplayName())
    }
}


typealias OnClickId = (CityId) -> Unit