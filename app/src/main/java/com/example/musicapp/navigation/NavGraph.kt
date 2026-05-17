//package com.example.musicapp.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.navigation.NavHostController
//import androidx.navigation.NavType
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.navArgument
//import com.example.musicapp.ui.components.appbar.AppTopBar
//import com.example.musicapp.ui.components.navigation.AppBottomBar
//import com.example.musicapp.ui.components.scaffold.MainScaffold
//import com.example.musicapp.ui.usuario_list.UsuarioListScreen
//import com.example.musicapp.ui.usuario_detail.UsuarioDetailScreen
//import com.example.musicapp.ui.usuario_edit.UsuarioEditScreen
//
//@Composable
//fun AppNavGraph(navController: NavHostController) {
//
//    NavHost(
//        navController = navController,
//        startDestination = Screen.UsuarioList.route
//    ) {
//
//        // LISTA
////        composable(Screen.UsuarioList.route) {
////            UsuarioListScreen(
////                onUsuarioClick = { id ->
////                    navController.navigate(Screen.UsuarioDetail.createRoute(id))
////                }
////            )
////        }
//
//        composable(Screen.UsuarioList.route) {
//            MainScaffold(
//                topBar = { AppTopBar("Usuarios") },
//                bottomBar = { AppBottomBar() }
//            ) { padding ->
//                UsuarioListScreen(
//                    modifier = padding,
//                    onUsuarioClick = { id ->
//                        navController.navigate(Screen.UsuarioDetail.createRoute(id))
//                    }
//                )
//            }
//        }
//
//
//        // DETALLE
//        composable(
//            route = Screen.UsuarioDetail.route,
//            arguments = listOf(navArgument("id") { type = NavType.IntType })
//        ) { backStackEntry ->
//
//            val id = backStackEntry.arguments?.getInt("id") ?: 0
//
//            UsuarioDetailScreen(
//                id = id,
//                onEditarClick = {
//                    navController.navigate(Screen.UsuarioEdit.createRoute(id))
//                }
//            )
//        }
//
//        // EDICIÓN
//        composable(
//            route = Screen.UsuarioEdit.route,
//            arguments = listOf(navArgument("id") { type = NavType.IntType })
//        ) { backStackEntry ->
//
//            val id = backStackEntry.arguments?.getInt("id") ?: 0
//
//            UsuarioEditScreen(
//                id = id,
//                onBack = { navController.popBackStack() }
//            )
//        }
//    }
//}

package com.example.musicapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.musicapp.ui.components.scaffold.MainScaffold
import com.example.musicapp.ui.components.appbar.AppTopBar
import com.example.musicapp.ui.components.navigation.AppBottomBar
import com.example.musicapp.ui.usuario_list.UsuarioListScreen
import com.example.musicapp.ui.usuario_detail.UsuarioDetailScreen
import com.example.musicapp.ui.usuario_edit.UsuarioEditScreen

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.UsuarioList.route
    ) {

        // LISTA DE USUARIOS
        composable(Screen.UsuarioList.route) {

            MainScaffold(
                topBar = { AppTopBar(title = "Usuarios") },
                bottomBar = { AppBottomBar() }
            ) { padding ->

                UsuarioListScreen(
                    modifier = padding,
                    onUsuarioClick = { id ->
                        navController.navigate(Screen.UsuarioDetail.createRoute(id))
                    }
                )
            }
        }

        // DETALLE DE USUARIO
        composable(
            route = Screen.UsuarioDetail.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->

            val id = backStackEntry.arguments?.getInt("id") ?: 0

            MainScaffold(
                topBar = { AppTopBar(title = "Detalle", onBack = { navController.popBackStack() }) }
            ) { padding ->

                UsuarioDetailScreen(
                    id = id,
                    modifier = padding,
                    onEditarClick = {
                        navController.navigate(Screen.UsuarioEdit.createRoute(id))
                    }
                )
            }
        }

        // EDICIÓN DE USUARIO
        composable(
            route = Screen.UsuarioEdit.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->

            val id = backStackEntry.arguments?.getInt("id") ?: 0

            MainScaffold(
                topBar = { AppTopBar(title = "Editar usuario", onBack = { navController.popBackStack() }) }
            ) { padding ->

                UsuarioEditScreen(
                    id = id,
                    modifier = padding,
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}
