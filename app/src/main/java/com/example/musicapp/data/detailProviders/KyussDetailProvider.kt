package com.example.musicapp.data.detailProviders

import com.example.musicapp.data.*
import com.example.musicapp.model.BandDetail

object KyussDetailProvider {

    fun getDetail(): BandDetail {
        val albums = DatasourceKyussPics().loadAlbumsKyuss()
        val description = DatasourceKyussStrings().loadStringsKyuss()
        val related = DatasourceToolPics().loadAlbumsTool()

        return BandDetail(
            mainAlbum = albums.first(),
            description = description,
            tags = listOf("stoner", "desert rock", "heavy"),
            relatedAlbums = related
        )
    }
}
