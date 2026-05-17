package com.example.musicapp.ui.usuario_edit

import com.example.musicapp.domain.model.Usuario

data class UsuarioEditUiState(
    val isLoading: Boolean = false,
    val usuarioActualizado: Usuario? = null,
    val error: String? = null,
    val success: Boolean = false
)

