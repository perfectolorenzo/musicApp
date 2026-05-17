package com.example.musicapp.ui.usuario_detail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun UsuarioDetailScreen(
    id: Int,
    modifier: Modifier = Modifier,
    onEditarClick: () -> Unit,
    viewModel: UsuarioDetailViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(id) {
        viewModel.cargarUsuario(id)
    }

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

        state.usuario != null -> {
            Column(modifier.padding(16.dp)) {
                Text("ID: ${state.usuario.id}", style = MaterialTheme.typography.titleLarge)
                Text("Nombre: ${state.usuario.nombre}")
                Text("Password: ${state.usuario.password}")

                Spacer(Modifier.height(20.dp))

                Button(onClick = onEditarClick) {
                    Text("Editar usuario")
                }
            }
        }
    }
}


