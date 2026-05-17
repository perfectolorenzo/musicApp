package com.example.musicapp.ui.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun AppBottomBar() {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = { /* TODO */ },
            icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
            label = { Text("Inicio") }
        )
    }
}


