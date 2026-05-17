package com.example.musicapp.pages.detail

import androidx.compose.runtime.Composable
import com.example.musicapp.data.detailProviders.ToolDetailProvider
import com.example.musicapp.pages.DetailScreenPage

@Composable
fun ToolDetailScreenPage() {
    DetailScreenPage(detail = ToolDetailProvider.getDetail())
}
