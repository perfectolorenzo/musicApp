package com.example.musicapp.data.detailProviders

import com.example.musicapp.data.*
import com.example.musicapp.model.BandDetail

object AphxDetailProvider {

    fun getDetail(): BandDetail {
        val albums = DatasourceAphxPics().loadAlbumsAphx()
        val description = DatasourceAphxStrings().loadStringsAphx()
        val related = DatasourceAePics().loadAlbumsAe()

        return BandDetail(
            mainAlbum = albums.first(),
            description = description,
            tags = listOf("idm", "ambient", "electronic"),
            relatedAlbums = related
        )
    }
}
