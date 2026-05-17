package com.example.musicapp.myComponents

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.musicapp.R

/**
 * @author="Perfecto"
 * @param
 * @function
 */

@Composable
fun TopBar(
    onInicioClick: () -> Unit = {},
    onLinksClick: () -> Unit = {},
    onSalirClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = "MusicApp") },
        navigationIcon = {
            IconButton(onClick = { expanded = true }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menú"
                )
            }
        },
        actions = {
            IconButton(onClick = onSettingsClick) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Ajustes"
                )
            }
        }
    )

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        DropdownMenuItem(
            text = { Text(stringResource(R.string.inicio)) },
            onClick = {
                expanded = false
                onInicioClick()
            }
        )
        DropdownMenuItem(
            text = { Text(stringResource(R.string.links)) },
            onClick = {
                expanded = false
                onLinksClick()
            }
        )
        DropdownMenuItem(
            text = { Text(stringResource(R.string.salir)) },
            onClick = {
                expanded = false
                onSalirClick()
            }
        )
    }
}
