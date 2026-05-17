//package com.example.musicapp.viewmodel
//
//
//
//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.musicapp.data.UserDataStore
//import com.example.musicapp.data.repository.UserRepository
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.collectLatest
//import kotlinx.coroutines.launch
//
//class UserViewModel(application: Application) : AndroidViewModel(application) {
//
//    private val dataStore = UserDataStore(application)
//    private val repository = UserRepository(dataStore)
//
//
//    // Estado expuesto a Compose
//    private val _userName = MutableStateFlow("")
//    val userName: StateFlow<String> = _userName
//
//    private val _fullName = MutableStateFlow("")
//    val fullName: StateFlow<String> = _fullName
//
//    private val _city = MutableStateFlow("")
//    val city: StateFlow<String> = _city
//
//    private val _country = MutableStateFlow("")
//    val country: StateFlow<String> = _country
//
//    private val _email = MutableStateFlow("")
//    val email: StateFlow<String> = _email
//
//    private val _bio = MutableStateFlow("")
//    val bio: StateFlow<String> = _bio
//
//    init {
//        loadUserData()
//    }
//
//    private fun loadUserData() {
//        viewModelScope.launch {
//            dataStore.userName.collectLatest { _userName.value = it }
//        }
//        viewModelScope.launch {
//            dataStore.fullName.collectLatest { _fullName.value = it }
//        }
//        viewModelScope.launch {
//            dataStore.city.collectLatest { _city.value = it }
//        }
//        viewModelScope.launch {
//            dataStore.country.collectLatest { _country.value = it }
//        }
//        viewModelScope.launch {
//            dataStore.email.collectLatest { _email.value = it }
//        }
//        viewModelScope.launch {
//            dataStore.bio.collectLatest { _bio.value = it }
//        }
//    }
//
//    fun saveUserData(
//        userName: String,
//        fullName: String,
//        city: String,
//        country: String,
//        email: String,
//        bio: String
//    ) {
//        viewModelScope.launch {
//            dataStore.saveUserData(
//                userName = userName,
//                fullName = fullName,
//                city = city,
//                country = country,
//                email = email,
//                bio = bio
//            )
//        }
//    }
//}
//
//
//


package com.example.musicapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicapp.data.UserDataStore
import com.example.musicapp.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val dataStore = UserDataStore(application)
    private val repository = UserRepository(dataStore)

    // Estado expuesto a Compose
    private val _userName = MutableStateFlow("")
    val userName: StateFlow<String> = _userName

    private val _fullName = MutableStateFlow("")
    val fullName: StateFlow<String> = _fullName

    private val _city = MutableStateFlow("")
    val city: StateFlow<String> = _city

    private val _country = MutableStateFlow("")
    val country: StateFlow<String> = _country

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _bio = MutableStateFlow("")
    val bio: StateFlow<String> = _bio

    init {
        loadUserData()
    }

    private fun loadUserData() {
        viewModelScope.launch {
            repository.userName.collectLatest { _userName.value = it }
        }
        viewModelScope.launch {
            repository.fullName.collectLatest { _fullName.value = it }
        }
        viewModelScope.launch {
            repository.city.collectLatest { _city.value = it }
        }
        viewModelScope.launch {
            repository.country.collectLatest { _country.value = it }
        }
        viewModelScope.launch {
            repository.email.collectLatest { _email.value = it }
        }
        viewModelScope.launch {
            repository.bio.collectLatest { _bio.value = it }
        }
    }

    fun saveUserData(
        userName: String,
        fullName: String,
        city: String,
        country: String,
        email: String,
        bio: String
    ) {
        viewModelScope.launch {
            repository.saveUserData(
                userName = userName,
                fullName = fullName,
                city = city,
                country = country,
                email = email,
                bio = bio
            )
        }
    }
}
