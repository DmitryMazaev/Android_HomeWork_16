package com.example.homework_15.data

import com.example.homework_15.entity.UsefulActivity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject

object RetrofitHelepr {
    val retrofitEngine = Retrofit.Builder()
        .baseUrl("https://bored-api.appbrewery.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}



