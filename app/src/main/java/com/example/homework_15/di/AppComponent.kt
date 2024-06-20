package com.example.homework_15.di

import com.example.homework_15.presentation.MainViewModel
import dagger.Component

@Component(
    modules = [DomainModule::class,
    DomainModule::class,
    PresentationModule::class]
)
interface AppComponent {
    fun mainViewModel(): MainViewModel
}