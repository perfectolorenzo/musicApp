package com.example.musicapp.pages.detail

import androidx.compose.runtime.Composable
import com.example.musicapp.data.detailProviders.KyussDetailProvider
import com.example.musicapp.pages.DetailScreenPage

@Composable
fun KyussDetailScreenPage() {
    DetailScreenPage(detail = KyussDetailProvider.getDetail())
}
