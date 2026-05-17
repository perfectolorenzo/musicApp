package com.example.musicapp.model

import com.example.musicapp.data.AlbumsId
import com.example.musicapp.data.StringsId

data class BandDetail(
    val mainAlbum: AlbumsId,
    val description: List<StringsId>,
    val tags: List<String>,
    val relatedAlbums: List<AlbumsId>
)