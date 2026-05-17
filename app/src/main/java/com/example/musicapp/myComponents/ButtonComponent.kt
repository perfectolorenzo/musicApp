package com.example.musicapp.myComponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.lang.reflect.Modifier

/**
 * @author= "Perfecto"
 * @param
 * @function
 */

/**
 * Botón genérico reutilizable
 */
@Composable
fun CustomButton(
    text: String,
    modifier: Modifier = Modifier,
    tonal: Boolean = false,
    onClick: () -> Unit
) {
    val shape = RoundedCornerShape(20.dp)

    if (tonal) {
        FilledTonalButton(
            onClick = onClick,
            modifier = modifier.fillMaxWidth(),
            shape = shape
        ) {
            Text(text)
        }
    } else {
        Button(
            onClick = onClick,
            modifier = modifier.fillMaxWidth(),
            shape = shape
        ) {
            Text(text)
        }
    }
}
