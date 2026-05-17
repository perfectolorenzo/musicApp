package com.example.musicapp.pages.detail

import androidx.compose.runtime.Composable
import com.example.musicapp.data.detailProviders.BocDetailProvider
import com.example.musicapp.pages.DetailScreenPage

@Composable
fun BocDetailScreenPage() {
    DetailScreenPage(detail = BocDetailProvider.getDetail())
}
