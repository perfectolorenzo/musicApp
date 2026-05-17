package com.example.musicapp.myComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.musicapp.data.AlbumsId
import com.example.musicapp.data.DatasourceAlbumsPics
import com.example.musicapp.styles.imageModifier

/**
 * @author="Perfecto"
 * @param
 * @function
 */

@Composable
fun AlbumsGrid(
    albums: List<AlbumsId>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        contentPadding = PaddingValues(1.dp),
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(1.dp),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(1.dp),
        modifier = modifier
    ) {
        items(albums) { album ->
            AlbumImage(album)
        }
    }
}

@Composable
fun AlbumImage(album: AlbumsId) {
    Image(
        painter = painterResource(album.discsResourceId),
        contentDescription = null,
        contentScale = ContentScale.Inside,
        modifier = imageModifier
    )
}

@Composable
fun GridViewComponent() {
    val albums = DatasourceAlbumsPics().loadAlbumsBands()
    AlbumsGrid(albums)
}
