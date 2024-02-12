package com.makogon.alina.movieapp.movieList.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.makogon.alina.movieapp.movieList.data.local.entity.MovieEntity

@Dao
interface MovieDao {

    @Upsert
    suspend fun upsertMovieList(movieList: List<MovieEntity>)

    @Query("SELECT * FROM MovieEntity")
    suspend fun getMovieList(): List<MovieEntity>

    @Query("SELECT * FROM MovieEntity WHERE isFavorite==1")
    suspend fun getFavoriteMovieList(): List<MovieEntity>

    @Query("SELECT * FROM MovieEntity WHERE filmId=:filmId")
    suspend fun getMovieById(filmId:Int): MovieEntity

}