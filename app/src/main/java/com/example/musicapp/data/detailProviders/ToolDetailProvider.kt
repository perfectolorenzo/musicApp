package com.example.musicapp.data.detailProviders

import com.example.musicapp.data.*
import com.example.musicapp.model.BandDetail

object ToolDetailProvider {

    fun getDetail(): BandDetail {
        val albums = DatasourceToolPics().loadAlbumsTool()
        val description = DatasourceToolStrings().loadStringsTool()
        val related = DatasourceKyussPics().loadAlbumsKyuss()

        return BandDetail(
            mainAlbum = albums.first(),
            description = description,
            tags = listOf("progressive", "metal", "experimental"),
            relatedAlbums = related
        )
    }
}
