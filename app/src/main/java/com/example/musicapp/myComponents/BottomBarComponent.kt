package com.example.musicapp.myComponents

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import com.example.musicapp.R

/**
 * @author="Perfecto"
 * @param
 */
data class BottomBarItem(
    val label: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)

@Composable
fun BottomBar(
    selectedIndex: Int = 0,
    onItemSelected: (Int) -> Unit = {}
) {
    val items = listOf(
        BottomBarItem(stringResource(R.string.inicio), Icons.Default.Home),
        BottomBarItem(stringResource(R.string.buscar), Icons.Default.Search),
        BottomBarItem(stringResource(R.string.perfil), Icons.Default.Person)
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
    ) {
        items.forEachIndexed { index, item ->
            val selected = selectedIndex == index

            NavigationBarItem(
                selected = selected,
                onClick = { onItemSelected(index) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            )
        }
    }
}
