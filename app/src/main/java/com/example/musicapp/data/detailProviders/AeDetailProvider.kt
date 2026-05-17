package com.example.musicapp.data.detailProviders

import androidx.compose.runtime.Composable
import com.example.musicapp.data.DatasourceAePics
import com.example.musicapp.data.DatasourceAeStrings
import com.example.musicapp.data.DatasourceAphxPics
import com.example.musicapp.model.BandDetail
import com.example.musicapp.pages.DetailScreenPage

/**
 * @author="Perfecto"
 * @param
 * @function
 */
object AeDetailProvider {

    fun getDetail(): BandDetail {
        val albums = DatasourceAePics().loadAlbumsAe()
        val description = DatasourceAeStrings().loadStringsAe()
        val related = DatasourceAphxPics().loadAlbumsAphx()

        return BandDetail(
            mainAlbum = albums.first(),
            description = description,
            tags = listOf("idm", "experimental", "electronic"),
            relatedAlbums = related
        )
    }

    @Composable
    fun AeDetailScreenPage() {
        DetailScreenPage(detail = getDetail())
    }

}