package com.example.musicapp.ui.components.scaffold

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScaffold(
    topBar: @Composable (() -> Unit)? = null,
    bottomBar: @Composable (() -> Unit)? = null,
    floatingActionButton: @Composable (() -> Unit)? = null,
    content: @Composable (Modifier) -> Unit
) {
    Scaffold(
        topBar = { topBar?.invoke() },
        bottomBar = { bottomBar?.invoke() },
        floatingActionButton = { floatingActionButton?.invoke() }
    ) { innerPadding ->
        content(Modifier.padding(innerPadding))
    }
}


