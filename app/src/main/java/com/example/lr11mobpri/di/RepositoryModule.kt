package com.example.lr11mobpri.di

import com.example.lr11mobpri.data.repository.PostRepositoryImpl
import com.example.lr11mobpri.domain.repository.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindPostRepository(impl: PostRepositoryImpl): PostRepository
}