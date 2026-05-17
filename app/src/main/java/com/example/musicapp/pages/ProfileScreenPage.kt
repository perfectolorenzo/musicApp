package com.example.musicapp.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreenPage(
    userName: String = "Usuario Retro",
    userEmail: String = "usuario@example.com",
    onEditProfile: () -> Unit = {},
    onLogout: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ProfileHeader(userName)

        Spacer(modifier = Modifier.height(30.dp))

        ProfileInfoItem(label = "Nombre", value = userName)
        ProfileInfoItem(label = "Email", value = userEmail)

        Spacer(modifier = Modifier.height(40.dp))

        ProfileActions(
            onEditProfile = onEditProfile,
            onLogout = onLogout
        )
    }
}

@Composable
fun ProfileHeader(userName: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Box(
            modifier = Modifier
                .size(110.dp)
                .background(Color(0xFF003B8E), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = userName.take(1).uppercase(),
                color = Color.White,
                fontSize = 40.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = userName,
            color = Color.White,
            fontSize = 22.sp
        )
    }
}

@Composable
fun ProfileInfoItem(label: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color(0xFF003B8E).copy(alpha = 0.3f), shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(text = label, color = Color(0xFF7AB6FF), fontSize = 14.sp)
        Text(text = value, color = Color.White, fontSize = 18.sp)
    }
}

@Composable
fun ProfileActions(
    onEditProfile: () -> Unit,
    onLogout: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = onEditProfile,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF003B8E)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Editar perfil", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onLogout,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8E0000)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cerrar sesión", color = Color.White)
        }
    }
}
