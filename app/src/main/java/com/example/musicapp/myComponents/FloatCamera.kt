package com.example.musicapp.myComponents

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.graphics.Color
import com.example.musicapp.R

/**
 * Botón flotante de cámara unificado
 * Retro, simple y consistente
 */

@Composable
fun FloatCamera(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier,
        containerColor = Color(0xFF003B8E),   // Azul retro Commodore
        contentColor = Color.White
    ) {
        Icon(
            imageVector = Icons.Filled.AddAPhoto,
            contentDescription = stringResource(R.string.sacar_foto)
        )
    }
}
