package com.makogon.alina.movieapp.movieList.domain.repository

import com.makogon.alina.movieapp.movieList.domain.model.Movie
import com.makogon.alina.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieListRepository {

    suspend fun getMovie(id:Int): Flow<Resource<Movie>>
    suspend fun getMovieList(forceFetchFromRemote: Boolean, category: String):Flow<Resource<List<Movie>>>
    suspend fun upsertFavoriteMovieList(movieList: List<Movie>): Flow<Resource<List<Movie>>>
}