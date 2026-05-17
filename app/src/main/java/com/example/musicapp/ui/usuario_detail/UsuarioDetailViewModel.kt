package com.example.musicapp.ui.usuario_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicapp.data.repository.UserRepository
import com.example.musicapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsuarioDetailViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(UsuarioDetailUiState())
    val uiState: StateFlow<UsuarioDetailUiState> = _uiState

    fun cargarUsuario(id: Int) {
        viewModelScope.launch {
            repository.obtenerUsuarioPorId(id).collect { result ->

                when (result) {

                    is Resource.Loading -> {
                        _uiState.update { it.copy(isLoading = true, error = null) }
                    }

                    is Resource.Success -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                usuario = result.data,
                                error = null
                            )
                        }
                    }

                    is Resource.Error -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                error = result.message
                            )
                        }
                    }
                }
            }
        }
    }
}
