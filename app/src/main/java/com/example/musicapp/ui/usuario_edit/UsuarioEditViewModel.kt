package com.example.musicapp.ui.usuario_edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicapp.data.repository.UserRepository
import com.example.musicapp.domain.model.Usuario
import com.example.musicapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsuarioEditViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(UsuarioEditUiState())
    val uiState: StateFlow<UsuarioEditUiState> = _uiState

    fun actualizarUsuario(usuario: Usuario) {
        viewModelScope.launch {
            repository.actualizarUsuario(usuario).collect { result ->

                when (result) {

                    is Resource.Loading -> {
                        _uiState.update { it.copy(isLoading = true, error = null, success = false) }
                    }

                    is Resource.Success -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                usuarioActualizado = result.data,
                                success = true,
                                error = null
                            )
                        }
                    }

                    is Resource.Error -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                error = result.message,
                                success = false
                            )
                        }
                    }
                }
            }
        }
    }
}
