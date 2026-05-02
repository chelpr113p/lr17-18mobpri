package com.example.lr11mobpri.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IoDispatcher

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DefaultDispatcher

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MorningGreeting

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class EveningGreeting