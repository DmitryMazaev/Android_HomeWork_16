package com.example.homework_15.data

import com.example.homework_15.entity.UsefulActivity
import retrofit2.Retrofit
import javax.inject.Inject

class UsefulActivitiesRepository @Inject constructor(
    private val retrofit: Retrofit
) {
    val service = retrofit.create(UsefulActivitiesService::class.java)

    suspend fun getUsefulActivity(): UsefulActivity {
        return service.getRandom()
    }
}