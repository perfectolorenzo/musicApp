//package com.example.musicapp.data.remote
//
//import okhttp3.OkHttpClient
//import retrofit2.Retrofit
//
///**
// * @author Perfecto
// */
//
////singleton
//object RetrofitClient {
//
//    /**url base de la api (usando jsonplaceholder como ejemplo)
//    no ponemos localhost el emulador pone esa ip
//    */
//   private const val BASE_URL ="http://10.0.2.2:5131"
//
//    /**
//     * Cliente http con loggin interceptor
//     */
//
//    private val okHttpClient: OkHttpClient by lazy{
//
//
//
//
//
//
//    }
//
//    /**
//     * instancia retrofit
//     */
//    private val retrofit: Retrofit by lazy{}
//}

//package com.example.musicapp.data.remote
//
//import com.example.musicapp.data.remote.api.UsuarioApiService
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//object RetrofitClient {
//
//    private const val BASE_URL = "http://10.0.2.2:5131/"
//
//    // Cliente HTTP con logging
//    private val okHttpClient: OkHttpClient by lazy {
//        val logging = HttpLoggingInterceptor().apply {
//            level = HttpLoggingInterceptor.Level.BODY
//        }
//
//        OkHttpClient.Builder()
//            .addInterceptor(logging)
//            .build()
//    }
//
//    // Instancia Retrofit
//    private val retrofit: Retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(okHttpClient)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    // Servicio de usuarios
//    val usuarioApi: UsuarioApiService by lazy {
//        retrofit.create(UsuarioApiService::class.java)
//    }
//}

package com.example.musicapp.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private const val BASE_URL = "http://10.0.2.2:5131/"

    private val okHttpClient: OkHttpClient by lazy {

        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val usuarioApi: UsuarioApiService by lazy {
        retrofit.create(UsuarioApiService::class.java)
    }
}
