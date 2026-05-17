package com.example.musicapp.data.detailProviders

import com.example.musicapp.data.*
import com.example.musicapp.model.BandDetail

object BocDetailProvider {

    fun getDetail(): BandDetail {
        val albums = DatasourceBocPics().loadAlbumsBoc()
        val description = DatasourceBocStrings().loadStringsBoc()
        val related = DatasourceAphxPics().loadAlbumsAphx()

        return BandDetail(
            mainAlbum = albums.first(),
            description = description,
            tags = listOf("idm", "downtempo", "ambient"),
            relatedAlbums = related
        )
    }
}
