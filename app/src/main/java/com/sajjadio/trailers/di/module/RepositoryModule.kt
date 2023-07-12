package com.sajjadio.trailers.di.module

import com.sajjadio.trailers.domain.repository.MovieRepository
import com.sajjadio.trailers.data.repository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindHomeRepository(movieRepository: MovieRepositoryImpl): MovieRepository

}