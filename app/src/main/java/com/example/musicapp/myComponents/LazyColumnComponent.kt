package com.example.musicapp.myComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.musicapp.data.BandsId
import com.example.musicapp.data.DatasourceMainScreenPics
import com.example.musicapp.styles.lazyColumnCardModifier
import com.example.musicapp.styles.styleTextCards

/**
 * @author="Perfecto"
 * @param
 * @function
 */
@Composable
fun LazyColumnComponent(modifier: Modifier = Modifier) {
    val cardsList = DatasourceMainScreenPics().LoadImagesId()

    Box(modifier = lazyColumnCardModifier) {
        LazyColumn(modifier = modifier) {
            items(cardsList) { item ->
                BandCard(item)
            }
        }
    }
}

@Composable
fun BandCard(band: BandsId) {
    Card(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(band.imageResourceId),
            contentDescription = stringResource(band.stringResourceId),
            contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(band.stringResourceId),
            style = styleTextCards,
            modifier = Modifier.padding(8.dp)
        )
    }
}
