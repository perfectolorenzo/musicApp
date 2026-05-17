package com.example.musicapp.myComponents

//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Card
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.unit.dp
//import com.example.musicapp.R
//import com.example.musicapp.styles.boxModifier
//import com.example.musicapp.styles.cardModifier
//import com.example.musicapp.styles.colModifier
//import com.example.musicapp.styles.styleText

/**
 * @author="Perfecto"
 * @param
 * @function
 */

//@Composable
//fun UserCardsComponents(modifier: Modifier = Modifier) {
//
//    Column(modifier = boxModifier) {
//
//        Text(
//            text = stringResource(R.string.perfil),
//            style = styleText,
//            modifier = Modifier.padding(8.dp)
//        )
//
//        UserInfoCard(stringResource(R.string.usuario))
//        UserInfoCard(stringResource(R.string.nombre))
//        UserInfoCard(stringResource(R.string.ciudad))
//        UserInfoCard(stringResource(R.string.pais))
//        UserInfoCard(stringResource(R.string.email))
//    }
//}
//
//@Composable
//fun UserInfoCard(text: String) {
//    Card(modifier = cardModifier.padding(8.dp)) {
//        Text(
//            text = text,
//            style = styleText,
//            modifier = Modifier.padding(12.dp)
//        )
//    }
//}



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.musicapp.styles.boxModifier
import com.example.musicapp.styles.cardModifier
import com.example.musicapp.styles.styleText

/**
 * Componente de tarjetas de información del usuario
 * Retro, modular y preparado para datos reales
 */

@Composable
fun UserCardsComponents(
    modifier: Modifier = Modifier,
    userName: String = "Perfecto",
    nombreCompleto: String = "Perfecto Pérez",
    ciudad: String = "Vigo",
    pais: String = "España",
    email: String = "perfecto@example.com"
) {
    Column(modifier = modifier.then(boxModifier)) {

        Text(
            text = "Perfil",
            style = styleText,
            modifier = Modifier.padding(8.dp)
        )

        UserInfoCard(label = "Usuario", value = userName)
        UserInfoCard(label = "Nombre", value = nombreCompleto)
        UserInfoCard(label = "Ciudad", value = ciudad)
        UserInfoCard(label = "País", value = pais)
        UserInfoCard(label = "Email", value = email)
    }
}

@Composable
fun UserInfoCard(
    label: String,
    value: String
) {
    Card(modifier = cardModifier.padding(8.dp)) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = label, style = styleText)
            Text(text = value, style = styleText)
        }
    }
}
