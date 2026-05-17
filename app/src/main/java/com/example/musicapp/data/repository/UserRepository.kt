//package com.example.musicapp.data.repository
//
//
//
//import com.example.musicapp.data.UserDataStore
//import com.example.musicapp.data.remote.RetrofitClient
//import com.example.musicapp.data.remote.dto.UsuarioDto
//import kotlinx.coroutines.flow.Flow
//import retrofit2.Response
//
//class UserRepository(
//    private val dataStore: UserDataStore
//) {
//
//    // -------------------------
//    // 1) DATOS LOCALES (DataStore)
//    // -------------------------
//
//    val userName: Flow<String> = dataStore.userName
//    val fullName: Flow<String> = dataStore.fullName
//    val city: Flow<String> = dataStore.city
//    val country: Flow<String> = dataStore.country
//    val email: Flow<String> = dataStore.email
//    val bio: Flow<String> = dataStore.bio
//
//    suspend fun saveUserData(
//        userName: String,
//        fullName: String,
//        city: String,
//        country: String,
//        email: String,
//        bio: String
//    ) {
//        dataStore.saveUserData(
//            userName = userName,
//            fullName = fullName,
//            city = city,
//            country = country,
//            email = email,
//            bio = bio
//        )
//    }
//
//    // -------------------------
//    // 2) DATOS REMOTOS (API)
//    // -------------------------
//
//    suspend fun obtenerUsuariosRemotos(): Response<UsuarioDto> {
//        return RetrofitClient.usuarioApi.obtenerUsuarios()
//    }
//}

//package com.example.musicapp.data.repository
//
//import com.example.musicapp.data.UserDataStore
//import com.example.musicapp.data.remote.api.UsuarioApiService
//import com.example.musicapp.data.remote.dto.UsuarioDto
//import kotlinx.coroutines.flow.Flow
//import retrofit2.Response
//
//class UserRepository(
//    private val dataStore: UserDataStore,
//    private val usuarioApi: UsuarioApiService
//) {
//
//    // -------------------------
//    // 1) DATOS LOCALES
//    // -------------------------
//
//    val userName: Flow<String> = dataStore.userName
//    val fullName: Flow<String> = dataStore.fullName
//    val city: Flow<String> = dataStore.city
//    val country: Flow<String> = dataStore.country
//    val email: Flow<String> = dataStore.email
//    val bio: Flow<String> = dataStore.bio
//
//    suspend fun saveUserData(
//        userName: String,
//        fullName: String,
//        city: String,
//        country: String,
//        email: String,
//        bio: String
//    ) {
//        dataStore.saveUserData(
//            userName = userName,
//            fullName = fullName,
//            city = city,
//            country = country,
//            email = email,
//            bio = bio
//        )
//    }
//
//    // -------------------------
//    // 2) DATOS REMOTOS
//    // -------------------------
//
//    suspend fun obtenerUsuariosRemotos(): Response<List<UsuarioDto>> {
//        return usuarioApi.obtenerUsuarios()
//    }
//}

//package com.example.musicapp.data.repository
//
//import com.example.musicapp.data.UserDataStore
//import com.example.musicapp.data.mapper.toDomain
//import com.example.musicapp.data.remote.api.UsuarioApiService
//import com.example.musicapp.domain.model.Usuario
//import kotlinx.coroutines.flow.Flow
//
//class UserRepository(
//    private val dataStore: UserDataStore,
//    private val usuarioApi: UsuarioApiService
//) {
//
//    // -------------------------
//    // 1) DATOS LOCALES
//    // -------------------------
//
//    val userName: Flow<String> = dataStore.userName
//    val fullName: Flow<String> = dataStore.fullName
//    val city: Flow<String> = dataStore.city
//    val country: Flow<String> = dataStore.country
//    val email: Flow<String> = dataStore.email
//    val bio: Flow<String> = dataStore.bio
//
//    suspend fun saveUserData(
//        userName: String,
//        fullName: String,
//        city: String,
//        country: String,
//        email: String,
//        bio: String
//    ) {
//        dataStore.saveUserData(
//            userName = userName,
//            fullName = fullName,
//            city = city,
//            country = country,
//            email = email,
//            bio = bio
//        )
//    }
//
//    // -------------------------
//    // 2) DATOS REMOTOS (DOMINIO)
//    // -------------------------
//
//    suspend fun obtenerUsuarios(): List<Usuario> {
//        val response = usuarioApi.obtenerUsuarios()
//
//        if (!response.isSuccessful || response.body() == null) {
//            throw Exception("Error al obtener usuarios: ${response.code()}")
//        }
//
//        return response.body()!!.map { it.toDomain() }
//    }
//}

package com.example.musicapp.data.repository

import com.example.musicapp.data.UserDataStore
import com.example.musicapp.data.mapper.toDomain
import com.example.musicapp.data.remote.api.UsuarioApiService
import com.example.musicapp.data.remote.dto.UsuarioDto
import com.example.musicapp.domain.model.Usuario
import com.example.musicapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepository(
    private val dataStore: UserDataStore,
    private val usuarioApi: UsuarioApiService
) {

    // -------------------------
    // 1) DATOS LOCALES
    // -------------------------

    val userName: Flow<String> = dataStore.userName
    val fullName: Flow<String> = dataStore.fullName
    val city: Flow<String> = dataStore.city
    val country: Flow<String> = dataStore.country
    val email: Flow<String> = dataStore.email
    val bio: Flow<String> = dataStore.bio

    suspend fun saveUserData(
        userName: String,
        fullName: String,
        city: String,
        country: String,
        email: String,
        bio: String
    ) {
        dataStore.saveUserData(
            userName = userName,
            fullName = fullName,
            city = city,
            country = country,
            email = email,
            bio = bio
        )
    }

    // -------------------------
    // 2) DATOS REMOTOS (Flow + Resource)
    // -------------------------

    fun obtenerUsuarios(): Flow<Resource<List<Usuario>>> = flow {

        emit(Resource.Loading)

        try {
            val response = usuarioApi.obtenerUsuarios()

            if (!response.isSuccessful || response.body() == null) {
                emit(Resource.Error("Error HTTP: ${response.code()}"))
                return@flow
            }

            val usuarios = response.body()!!.map { it.toDomain() }
            emit(Resource.Success(usuarios))

        } catch (e: Exception) {
            emit(Resource.Error("Error de red: ${e.message}", e))
        }
    }

    fun obtenerUsuarioPorId(id: Int): Flow<Resource<Usuario>> = flow {
        emit(Resource.Loading)

        try {
            val response = usuarioApi.obtenerUsuarioPorId(id)

            if (!response.isSuccessful || response.body() == null) {
                emit(Resource.Error("Error HTTP: ${response.code()}"))
                return@flow
            }

            emit(Resource.Success(response.body()!!.toDomain()))

        } catch (e: Exception) {
            emit(Resource.Error("Error de red: ${e.message}", e))
        }
    }

    fun actualizarUsuario(usuario: Usuario): Flow<Resource<Usuario>> = flow {
        emit(Resource.Loading)

        try {
            // Convertimos dominio → DTO
            val dto = UsuarioDto(
                id = usuario.id,
                name = usuario.nombre,
                passwd = usuario.password
            )

            val response = usuarioApi.actualizarUsuario(usuario.id, dto)

            if (!response.isSuccessful || response.body() == null) {
                emit(Resource.Error("Error HTTP: ${response.code()}"))
                return@flow
            }

            emit(Resource.Success(response.body()!!.toDomain()))

        } catch (e: Exception) {
            emit(Resource.Error("Error de red: ${e.message}", e))
        }
    }

}
