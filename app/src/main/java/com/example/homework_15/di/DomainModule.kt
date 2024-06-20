package com.example.homework_15.di

import com.example.homework_15.data.UsefulActivitiesRepository
import com.example.homework_15.domain.GetUsefulActivityUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideGetUsefulActivityUseCase(usefulActivitiesRepository: UsefulActivitiesRepository): GetUsefulActivityUseCase {
        return GetUsefulActivityUseCase(usefulActivitiesRepository)
    }
}