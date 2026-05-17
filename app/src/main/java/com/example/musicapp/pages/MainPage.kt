//package com.example.musicapp.pages
//
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.musicapp.myComponents.LazyColumnComponent
//
//
//@Composable
//fun MainScreenPage(modifier: Modifier = Modifier) {
//
//    LazyColumnComponent()
//
//}
//
//@Preview
//@Composable
//fun MainPreviewPage() {
//
//    MainScreenPage()
//
//}

package com.example.musicapp.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.musicapp.myComponents.BottomBar
import com.example.musicapp.myComponents.LazyColumnComponent
import com.example.musicapp.myComponents.LazyRowComponent
import com.example.musicapp.myComponents.AlbumsGrid
import com.example.musicapp.myComponents.TagsFlow
import com.example.musicapp.myComponents.FloatingCameraButton
import com.example.musicapp.data.*

@Composable
fun MainScreenPage(modifier: Modifier = Modifier) {

    Scaffold(
        bottomBar = { BottomBar() },
        floatingActionButton = {
            FloatingCameraButton(onClick = { /* abrir cámara */ })
        }
    ) { innerPadding ->

        Column(modifier = Modifier.padding(innerPadding)) {

            // Sección 1: LazyRow de álbumes
            LazyRowComponent(
                albums = DatasourceAePics().loadAlbumsAe()
            )

            // Sección 2: Grid de imágenes
            AlbumsGrid(
                albums = DatasourceAlbumsPics().loadAlbumsBands()
            )

            // Sección 3: Tags
            TagsFlow(
                tags = listOf("rock", "metal", "idm", "ambient")
            )

            // Sección 4: LazyColumn de bandas
            LazyColumnComponent()
        }
    }
}
