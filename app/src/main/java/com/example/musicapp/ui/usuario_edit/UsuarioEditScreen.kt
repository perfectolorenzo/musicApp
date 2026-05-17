package com.example.musicapp.ui.usuario_edit

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.musicapp.domain.model.Usuario

@Composable
fun UsuarioEditScreen(
    id: Int,
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    viewModel: UsuarioEditViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    var nombre by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier.padding(16.dp)) {

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                viewModel.actualizarUsuario(
                    Usuario(id = id, nombre = nombre, password = password)
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar cambios")
        }

        if (state.isLoading) {
            CircularProgressIndicator()
        }

        if (state.success) {
            Text("Usuario actualizado correctamente")
            LaunchedEffect(Unit) {
                onBack()
            }
        }

        if (state.error != null) {
            Text("Error: ${state.error}")
        }
    }
}


