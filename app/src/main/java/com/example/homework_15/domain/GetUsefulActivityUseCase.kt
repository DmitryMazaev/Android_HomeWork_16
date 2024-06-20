package com.example.homework_15.domain

import com.example.homework_15.data.UsefulActivitiesRepository
import com.example.homework_15.entity.UsefulActivity
import javax.inject.Inject


class GetUsefulActivityUseCase @Inject constructor(
    private val usefulActivitiesRepository: UsefulActivitiesRepository
) {
    suspend fun execute(): UsefulActivity {

        return usefulActivitiesRepository.getUsefulActivity()
    }

}