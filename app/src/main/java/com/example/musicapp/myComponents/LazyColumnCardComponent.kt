package com.example.musicapp.myComponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.musicapp.data.StringsId

/**
 * @author="Perfecto"
 * @param
 * @function
 */

@Composable
fun StringsList(
    items: List<StringsId>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(items) { item ->
            StringCard(item)
        }
    }
}

@Composable
fun StringCard(item: StringsId) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Text(
            text = stringResource(item.stringResourceId),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(12.dp)
        )
    }
}
