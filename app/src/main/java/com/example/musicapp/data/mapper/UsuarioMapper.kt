package com.example.musicapp.data.mapper



import com.example.musicapp.data.remote.dto.UsuarioDto
import com.example.musicapp.domain.model.Usuario

fun UsuarioDto.toDomain(): Usuario {
    return Usuario(
        id = this.id,
        nombre = this.name,
        password = this.passwd
    )
}
