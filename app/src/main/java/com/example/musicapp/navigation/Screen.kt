package com.example.musicapp.navigation

sealed class Screen(val route: String) {

    object UsuarioList : Screen("usuario_list")

    object UsuarioDetail : Screen("usuario_detail/{id}") {
        fun createRoute(id: Int) = "usuario_detail/$id"
    }

    object UsuarioEdit : Screen("usuario_edit/{id}") {
        fun createRoute(id: Int) = "usuario_edit/$id"
    }
}
