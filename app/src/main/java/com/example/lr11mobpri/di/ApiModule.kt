package com.example.lr11mobpri.di

import com.example.lr11mobpri.data.remote.api.PostApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun providePostApi(retrofit: Retrofit): PostApi =
        retrofit.create(PostApi::class.java)
}