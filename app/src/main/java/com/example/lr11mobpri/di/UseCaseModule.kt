package com.example.lr11mobpri.di

import com.example.lr11mobpri.domain.repository.PostRepository
import com.example.lr11mobpri.domain.usecase.AddPostUseCase
import com.example.lr11mobpri.domain.usecase.GetPostsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetPostsUseCase(repository: PostRepository): GetPostsUseCase =
        GetPostsUseCase(repository)

    @Provides
    @Singleton
    fun provideAddPostUseCase(repository: PostRepository): AddPostUseCase =
        AddPostUseCase(repository)
}