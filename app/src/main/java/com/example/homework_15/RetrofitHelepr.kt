package com.example.homework_15

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitHelepr {
    val retrofitEngine = Retrofit.Builder()
        .baseUrl("https://randomuser.me/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

interface RandomuserApiService {
    @GET("api")
    suspend fun getSuspend(): PersonModel
}

data class NResult (
    @SerializedName("results")
    val response: List<User>
)

data class User(
    val gender: String,
    val name: ServerName
)

data class ServerName(
    val title: String,
    val last: String
)