package com.example.homework_15.di

import com.example.homework_15.data.UsefulActivitiesRepository
import com.example.homework_15.data.UsefulActivityDto
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class DataModule {
    @Provides
    fun provideUsefulActivityDto(activity: String): UsefulActivityDto {
        return UsefulActivityDto(activity)
    }
    @Provides
    fun provideUsefulActivitiesRepository(retrofit: Retrofit): UsefulActivitiesRepository {
        return UsefulActivitiesRepository(retrofit)
    }
}