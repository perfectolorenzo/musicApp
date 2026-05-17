package com.example.musicapp.di



import com.example.musicapp.data.remote.RetrofitClient
import com.example.musicapp.data.remote.api.UsuarioApiService
import com.example.musicapp.data.repository.UserRepository
import com.example.musicapp.data.UserDataStore
import com.google.android.datatransport.runtime.dagger.Provides
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // -------------------------
    // 1) API SERVICES
    // -------------------------

    @Provides
    @Singleton
    fun provideUsuarioApiService(): UsuarioApiService {
        return RetrofitClient.usuarioApi
    }

    // -------------------------
    // 2) REPOSITORIES
    // -------------------------

    @Provides
    @Singleton
    fun provideUserRepository(
        dataStore: UserDataStore,
        usuarioApi: UsuarioApiService
    ): UserRepository {
        return UserRepository(
            dataStore = dataStore,
            usuarioApi = usuarioApi
        )
    }
}
