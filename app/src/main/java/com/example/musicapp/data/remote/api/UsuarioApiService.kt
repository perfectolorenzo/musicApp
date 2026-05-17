//package com.example.musicapp.data.remote.api
//
//import com.example.musicapp.data.remote.dto.UsuarioDto
//import retrofit2.Response
//import retrofit2.http.GET
//
//interface UsuarioApiService {
//
//
//    @GET("json/users")
//    suspend fun obtenerUsuarios(): Response<UsuarioDto>
//}

//package com.example.musicapp.data.remote.api
//
//import com.example.musicapp.data.remote.dto.UsuarioDto
//import retrofit2.Response
//import retrofit2.http.GET
//
//interface UsuarioApiService {
//
//    @GET("json/users")
//    suspend fun obtenerUsuarios(): Response<List<UsuarioDto>>
//}

package com.example.musicapp.data.remote.api

import com.example.musicapp.data.remote.dto.UsuarioDto
import retrofit2.Response
import retrofit2.http.*

interface UsuarioApiService {

    @GET("json/users")
    suspend fun obtenerUsuarios(): Response<List<UsuarioDto>>

    // Obtener usuario por ID
    @GET("json/users/{id}")
    suspend fun obtenerUsuarioPorId(
        @Path("id") id: Int
    ): Response<UsuarioDto>

    // Actualizar usuario
    @PUT("json/users/{id}")
    suspend fun actualizarUsuario(
        @Path("id") id: Int,
        @Body usuario: UsuarioDto
    ): Response<UsuarioDto>
}
