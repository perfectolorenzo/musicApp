package com.example.musicapp.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.musicapp.model.BandDetail
import com.example.musicapp.myComponents.AlbumImage
import com.example.musicapp.myComponents.LazyRowComponent
import com.example.musicapp.myComponents.StringsList
import com.example.musicapp.myComponents.TagsFlow

/**
 * @author="Perfecto"
 * @param
 * @function
 */

@Composable
fun DetailScreenPage(
    detail: BandDetail,
    modifier: Modifier = Modifier
) {
    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            AlbumImage(detail.mainAlbum)

            Text(
                text = "Detalle",
                modifier = Modifier.padding(vertical = 12.dp)
            )

            TagsFlow(tags = detail.tags)

            StringsList(items = detail.description)

            LazyRowComponent(albums = detail.relatedAlbums)
        }
    }
}
