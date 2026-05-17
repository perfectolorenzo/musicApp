package com.example.musicapp.data



import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Extensión DataStore
val Context.userDataStore by preferencesDataStore(name = "user_prefs")

class UserDataStore(private val context: Context) {

    companion object {
        val USERNAME = stringPreferencesKey("username")
        val FULLNAME = stringPreferencesKey("fullname")
        val CITY = stringPreferencesKey("city")
        val COUNTRY = stringPreferencesKey("country")
        val EMAIL = stringPreferencesKey("email")
        val BIO = stringPreferencesKey("bio")
    }

    // Leer datos
    val userName: Flow<String> = context.userDataStore.data.map { it[USERNAME] ?: "" }
    val fullName: Flow<String> = context.userDataStore.data.map { it[FULLNAME] ?: "" }
    val city: Flow<String> = context.userDataStore.data.map { it[CITY] ?: "" }
    val country: Flow<String> = context.userDataStore.data.map { it[COUNTRY] ?: "" }
    val email: Flow<String> = context.userDataStore.data.map { it[EMAIL] ?: "" }
    val bio: Flow<String> = context.userDataStore.data.map { it[BIO] ?: "" }

    // Guardar datos
    suspend fun saveUserData(
        userName: String,
        fullName: String,
        city: String,
        country: String,
        email: String,
        bio: String
    ) {
        context.userDataStore.edit { prefs ->
            prefs[USERNAME] = userName
            prefs[FULLNAME] = fullName
            prefs[CITY] = city
            prefs[COUNTRY] = country
            prefs[EMAIL] = email
            prefs[BIO] = bio
        }
    }
}
