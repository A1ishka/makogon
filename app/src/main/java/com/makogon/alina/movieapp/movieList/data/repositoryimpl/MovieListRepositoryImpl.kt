package com.makogon.alina.movieapp.movieList.data.repositoryimpl

import com.makogon.alina.movieapp.movieList.data.local.MovieDB
import com.makogon.alina.movieapp.movieList.data.local.entity.MovieEntity
import com.makogon.alina.movieapp.movieList.data.mappers.toMovie
import com.makogon.alina.movieapp.movieList.data.mappers.toMovieEntity
import com.makogon.alina.movieapp.movieList.data.remote.MovieApi
import com.makogon.alina.movieapp.movieList.domain.model.Movie
import com.makogon.alina.movieapp.movieList.domain.repository.MovieListRepository
import com.makogon.alina.movieapp.util.Category
import com.makogon.alina.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class MovieListRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi,
    private val movieDB: MovieDB
) : MovieListRepository {
    override suspend fun getMovieList(
        forceFetchFromRemote: Boolean, category: String
    ): Flow<Resource<List<Movie>>> {
        return flow {
            var localMovieList = emptyList<MovieEntity>()
            emit(Resource.Loading(true))
            if (category == Category.POPULAR) {
                localMovieList = movieDB.movieDao.getMovieList()
                val shouldLoadLocalMovie = localMovieList.isNotEmpty() && !forceFetchFromRemote
                if (shouldLoadLocalMovie) {
                    emit(Resource.Success(
                        data = localMovieList.map { movieEntity ->
                            movieEntity.toMovie()
                        }
                    ))
                    emit(Resource.Loading(false))
                    return@flow
                }
                val movieListFromApi = try {
                    movieApi.getMovieList()
                } catch (e: IOException) {
                    e.printStackTrace()
                    emit(Resource.Error(message = "Error loading movies"))
                    return@flow
                } catch (e: Exception) {
                    e.printStackTrace()
                    emit(Resource.Error(message = "Error loading movies"))
                    return@flow
                }

                val movieEntities = movieListFromApi.films.let {
                    it.map { movieDto ->
                        movieDto.toMovieEntity()
                    }
                }
                movieDB.movieDao.upsertMovieList(movieEntities)
                emit(Resource.Success(
                    movieEntities.map { it.toMovie() }
                ))
            } else {
                localMovieList = movieDB.movieDao.getFavoriteMovieList()
                emit(Resource.Success(
                    data = localMovieList.map { movieEntity ->
                        movieEntity.toMovie()
                    }
                ))
            }
            emit(Resource.Loading(isLoading = false))
        }
    }

    override suspend fun getMovie(id: Int): Flow<Resource<Movie>> {
        return flow {
            emit(Resource.Loading(true))
            val movieEntity = movieDB.movieDao.getMovieById(id)
            if (movieEntity != null) {
                emit(
                    Resource.Success(movieEntity.toMovie())
                )
                emit(Resource.Loading(false))
                return@flow
            }
            emit(Resource.Error("Error no such movie"))
            emit(Resource.Loading(false))
        }
    }

    override suspend fun upsertFavoriteMovieList(movieList: List<Movie>): Flow<Resource<List<Movie>>> {
        return flow {
            emit(Resource.Loading(true))

            val movieEntities = movieList.let {
                it.map { movie ->
                    movie.toMovieEntity()
                }
            }
            movieDB.movieDao.upsertMovieList(movieEntities)
            var localMovieList = movieDB.movieDao.getFavoriteMovieList()
            emit(Resource.Success(
                data = localMovieList.map { movieEntity ->
                    movieEntity.toMovie()
                }
            ))
            emit(Resource.Loading(isLoading = false))
        }
    }
}