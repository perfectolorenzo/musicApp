package com.example.musicapp.ui.usuario_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun UsuarioListScreen(
    modifier: Modifier = Modifier,
    onUsuarioClick: (Int) -> Unit,
    viewModel: UsuarioListViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    when {
        state.isLoading -> {
            Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        state.error != null -> {
            Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Error: ${state.error}")
            }
        }

        else -> {
            Column(modifier.padding(16.dp)) {
                state.usuarios.forEach { usuario ->
                    Text(
                        text = usuario.nombre,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onUsuarioClick(usuario.id) }
                            .padding(12.dp)
                    )
                    Divider()
                }
            }
        }
    }
}


