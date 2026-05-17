package com.example.musicapp.ui.usuario_detail

import com.example.musicapp.domain.model.Usuario

data class UsuarioDetailUiState(
    val isLoading: Boolean = false,
    val usuario: Usuario? = null,
    val error: String? = null
)

