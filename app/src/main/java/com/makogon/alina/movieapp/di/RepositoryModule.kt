package com.makogon.alina.movieapp.di

import com.makogon.alina.movieapp.movieList.data.repositoryimpl.MovieListRepositoryImpl
import com.makogon.alina.movieapp.movieList.domain.repository.MovieListRepository
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
    abstract fun bindMovieRepository(
        movieListRepositoryImpl: MovieListRepositoryImpl
    ): MovieListRepository
}