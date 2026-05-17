package com.example.musicapp.ui.usuario_list

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
class UsuarioListViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(UsuarioListUiState())
    val uiState: StateFlow<UsuarioListUiState> = _uiState

    init {
        cargarUsuarios()
    }

    fun cargarUsuarios() {
        viewModelScope.launch {
            repository.obtenerUsuarios().collect { result ->

                when (result) {

                    is Resource.Loading -> {
                        _uiState.update { it.copy(isLoading = true, error = null) }
                    }

                    is Resource.Success -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                usuarios = result.data,
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
