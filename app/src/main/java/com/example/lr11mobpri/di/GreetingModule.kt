package com.example.lr11mobpri.di

import com.example.lr11mobpri.data.service.EveningGreetingImpl
import com.example.lr11mobpri.data.service.MorningGreetingImpl
import com.example.lr11mobpri.domain.service.GreetingService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class GreetingModule {
    @MorningGreeting
    @Binds
    @Singleton
    abstract fun bindMorningGreeting(impl: MorningGreetingImpl): GreetingService

    @EveningGreeting
    @Binds
    @Singleton
    abstract fun bindEveningGreeting(impl: EveningGreetingImpl): GreetingService
}