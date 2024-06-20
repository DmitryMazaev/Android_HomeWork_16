package com.example.homework_15.di

import com.example.homework_15.domain.GetUsefulActivityUseCase
import com.example.homework_15.presentation.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {
    @Provides
    fun provideMainViewModel(getUsefulActivityUseCase: GetUsefulActivityUseCase): MainViewModel {
        return MainViewModel(getUsefulActivityUseCase)
    }
}