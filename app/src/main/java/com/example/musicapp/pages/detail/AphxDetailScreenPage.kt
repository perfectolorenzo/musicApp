package com.example.musicapp.pages.detail

import androidx.compose.runtime.Composable
import com.example.musicapp.data.detailProviders.AphxDetailProvider
import com.example.musicapp.pages.DetailScreenPage

@Composable
fun AphxDetailScreenPage() {
    DetailScreenPage(detail = AphxDetailProvider.getDetail())
}
