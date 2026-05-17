package com.example.musicapp.pages.detail

import androidx.compose.runtime.Composable
import com.example.musicapp.data.detailProviders.AeDetailProvider
import com.example.musicapp.pages.DetailScreenPage

@Composable
fun AeDetailScreenPage() {
    DetailScreenPage(detail = AeDetailProvider.getDetail())
}
