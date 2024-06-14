package com.example.homework_15.data

import com.example.homework_15.entity.UsefulActivity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitHelepr {
    val retrofitEngine = Retrofit.Builder()
        .baseUrl("https://bored-api.appbrewery.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

class UsefulActivitiesRepository {

    val usefulActivityDto = UsefulActivityDto(
        activity = "activity"
    )
    @GET("random")
    suspend fun getUsefulActivity(): UsefulActivity {
        return usefulActivityDto
    }
}

