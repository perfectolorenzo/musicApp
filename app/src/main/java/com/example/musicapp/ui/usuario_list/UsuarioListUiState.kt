package com.example.musicapp.ui.usuario_list

import com.example.musicapp.domain.model.Usuario

data class UsuarioListUiState(
    val isLoading: Boolean = false,
    val usuarios: List<Usuario> = emptyList(),
    val error: String? = null
)
