package com.example.musicapp.myComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.musicapp.data.AlbumsId
import com.example.musicapp.styles.imageModifier

/**
 * @author="Perfecto"
 * @param
 * @function
 */

@Composable
fun LazyRowComponent(
    albums: List<AlbumsId>,
    modifier: Modifier = Modifier
) {
    LazyRow(modifier = modifier.padding(8.dp)) {
        items(albums) { album ->
            AlbumCard(album)
        }
    }
}

@Composable
fun AlbumCard(album: AlbumsId) {
    Box(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(album.discsResourceId),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = imageModifier
        )
    }
}
