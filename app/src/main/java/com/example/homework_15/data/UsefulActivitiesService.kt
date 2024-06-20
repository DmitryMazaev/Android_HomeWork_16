package com.example.homework_15.data

import retrofit2.http.GET

interface UsefulActivitiesService {
    @GET("random")
    suspend fun getRandom(): UsefulActivityDto
}