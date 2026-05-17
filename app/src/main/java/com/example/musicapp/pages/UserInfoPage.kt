//package com.example.musicapp.pages
//
//import androidx.compose.foundation.layout.Row
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.musicapp.myComponents.FloatCamera
//import com.example.musicapp.myComponents.UserCardsComponents
//import com.example.musicapp.styles.cameraMod
//
//
//@Composable
//fun UserInfoScreenPage(modifier: Modifier = Modifier) {
//
//    Row {
//        UserCardsComponents(
//            materialTheme = MaterialTheme.colorScheme.background
//        )
//    }
//    Row(cameraMod){
//        FloatCamera {  }
//    }
//}
//
//@Preview
//@Composable
//fun UserPrev() {
//
//    UserInfoScreenPage()
//
//}

//package com.example.musicapp.pages
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import com.example.musicapp.myComponents.FloatCamera
//import com.example.musicapp.myComponents.UserCardsComponents
//import com.example.musicapp.styles.cameraMod
//
//@Composable
//fun UserInfoScreenPage(
//    modifier: Modifier = Modifier,
//    onEditProfile: () -> Unit = {}
//) {
//
//    Column(modifier = modifier.fillMaxSize()) {
//
//        // Tarjetas de usuario
//        Row {
//            UserCardsComponents(
//                materialTheme = MaterialTheme.colorScheme.background
//            )
//        }
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        // Botón Editar Perfil
//        Button(
//            onClick = onEditProfile,
//            colors = ButtonDefaults.buttonColors(
//                containerColor = MaterialTheme.colorScheme.primary
//            ),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 20.dp)
//        ) {
//            Text("Editar perfil")
//        }
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        // Cámara flotante
//        Row(cameraMod) {
//            FloatCamera { }
//        }
//    }
//}

package com.example.musicapp.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.musicapp.myComponents.FloatCamera
import com.example.musicapp.myComponents.UserCardsComponents
import com.example.musicapp.styles.cameraMod
import com.example.musicapp.viewmodel.UserViewModel

@Composable
fun UserInfoScreenPage(
    modifier: Modifier = Modifier,
    onEditProfile: () -> Unit = {}
) {
    // 1) Obtener el ViewModel
    val viewModel: UserViewModel = viewModel()

    // 2) Convertir los StateFlow en estado Compose
    val userName = viewModel.userName.collectAsState().value
    val fullName = viewModel.fullName.collectAsState().value
    val city = viewModel.city.collectAsState().value
    val country = viewModel.country.collectAsState().value
    val email = viewModel.email.collectAsState().value
    val bio = viewModel.bio.collectAsState().value

    // 3) UI
    Column(modifier = modifier.fillMaxSize()) {

        // Tarjetas con datos reales
        UserCardsComponents(
            userName = userName,
            nombreCompleto = fullName,
            ciudad = city,
            pais = country,
            email = email
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Botón Editar Perfil
        Button(
            onClick = onEditProfile,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text("Editar perfil")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Cámara flotante
        Row(cameraMod) {
            FloatCamera { }
        }
    }
}
