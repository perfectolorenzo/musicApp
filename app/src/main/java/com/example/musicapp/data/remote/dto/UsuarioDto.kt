//package com.example.musicapp.data.remote.dto
//
//import com.google.gson.annotations.SerializedName
//
//class UsuarioDto (
//
//    @SerializedName("id")
//    val id: String,
//
//    @SerializedName("")
//    val name: String,
//
//    @SerializedName("")
//    val passwd: String,
//
//
//)

package com.example.musicapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class UsuarioDto(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("passwd")
    val passwd: String
)
