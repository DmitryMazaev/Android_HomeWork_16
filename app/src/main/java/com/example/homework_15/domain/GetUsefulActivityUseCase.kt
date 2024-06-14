package com.example.homework_15.domain

import com.example.homework_15.data.UsefulActivitiesRepository
import com.example.homework_15.entity.UsefulActivity

class GetUsefulActivityUseCase(
    private val usefulActivitiesRepository: UsefulActivitiesRepository
) {
    suspend fun execute(): UsefulActivity {

        return usefulActivitiesRepository.getUsefulActivity()
    }
}