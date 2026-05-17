package com.example.musicapp.myComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * @author="Perfecto"
 * @param
 * @function
 */

@Composable
fun TagsFlow(
    tags: List<String>,
    modifier: Modifier = Modifier,
    onTagClick: (String) -> Unit = {}
) {
    FlowRow(modifier = modifier.padding(8.dp)) {
        tags.forEach { tag ->
            TagItem(
                text = tag,
                onClick = { onTagClick(tag) }
            )
        }
    }
}

@Composable
fun TagItem(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    FilterChip(
        modifier = modifier.padding(end = 4.dp),
        onClick = onClick,
        border = BorderStroke(1.dp, Color(0xFF3B3A3C)),
        label = { Text(text) },
        selected = false
    )
}
