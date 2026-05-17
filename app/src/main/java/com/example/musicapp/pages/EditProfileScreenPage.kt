//package com.example.musicapp.pages
//
//
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@Composable
//fun EditProfileScreenPage(
//    initialName: String = "Usuario Retro",
//    initialEmail: String = "usuario@example.com",
//    initialBio: String = "Amante de la música.",
//    onSave: (String, String, String) -> Unit = { _, _, _ -> },
//    onCancel: () -> Unit = {}
//) {
//    var name by remember { mutableStateOf(initialName) }
//    var email by remember { mutableStateOf(initialEmail) }
//    var bio by remember { mutableStateOf(initialBio) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(20.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//        Text(
//            text = "Editar Perfil",
//            color = Color.White,
//            fontSize = 24.sp
//        )
//
//        Spacer(modifier = Modifier.height(30.dp))
//
//        OutlinedTextField(
//            value = name,
//            onValueChange = { name = it },
//            label = { Text("Nombre") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            label = { Text("Email") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        OutlinedTextField(
//            value = bio,
//            onValueChange = { bio = it },
//            label = { Text("Biografía") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(120.dp),
//            maxLines = 4
//        )
//
//        Spacer(modifier = Modifier.height(40.dp))
//
//        Button(
//            onClick = { onSave(name, email, bio) },
//            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF003B8E)),
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text("Guardar cambios", color = Color.White)
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = onCancel,
//            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8E0000)),
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text("Cancelar", color = Color.White)
//        }
//    }
//}

package com.example.musicapp.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.musicapp.viewmodel.UserViewModel

@Composable
fun EditProfileScreenPage(
    modifier: Modifier = Modifier,
    onBack: () -> Unit = {}
) {
    // 1) Obtener el ViewModel
    val viewModel: UserViewModel = viewModel()

    // 2) Cargar datos actuales del usuario
    val userName = viewModel.userName.collectAsState().value
    val fullName = viewModel.fullName.collectAsState().value
    val city = viewModel.city.collectAsState().value
    val country = viewModel.country.collectAsState().value
    val email = viewModel.email.collectAsState().value
    val bio = viewModel.bio.collectAsState().value

    // 3) Estados editables
    var name by remember { mutableStateOf(userName) }
    var fullname by remember { mutableStateOf(fullName) }
    var cityState by remember { mutableStateOf(city) }
    var countryState by remember { mutableStateOf(country) }
    var emailState by remember { mutableStateOf(email) }
    var bioState by remember { mutableStateOf(bio) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Editar Perfil",
            color = Color.White,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Usuario") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = fullname,
            onValueChange = { fullname = it },
            label = { Text("Nombre completo") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = cityState,
            onValueChange = { cityState = it },
            label = { Text("Ciudad") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = countryState,
            onValueChange = { countryState = it },
            label = { Text("País") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = emailState,
            onValueChange = { emailState = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = bioState,
            onValueChange = { bioState = it },
            label = { Text("Biografía") },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            maxLines = 4
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Guardar cambios
        Button(
            onClick = {
                viewModel.saveUserData(
                    userName = name,
                    fullName = fullname,
                    city = cityState,
                    country = countryState,
                    email = emailState,
                    bio = bioState
                )
                onBack() // volver al perfil
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF003B8E)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar cambios", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Cancelar
        Button(
            onClick = onBack,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8E0000)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cancelar", color = Color.White)
        }
    }
}
