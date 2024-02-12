package com.makogon.alina.movieapp.movieList.data.remote

import com.makogon.alina.movieapp.movieList.data.remote.response.MovieDto
import com.makogon.alina.movieapp.movieList.data.remote.response.MovieListDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MovieApi {

    @GET("top?type=TOP_100_POPULAR_FILMS")
    suspend fun getMovieList(
        @Header("x-api-key") apikey: String = API_KEY
    ): MovieListDto

    @GET
    suspend fun getMovie(
        @Query("id") id: Int,
        @Header("x-api-key") apikey: String = API_KEY
    ): MovieDto

    companion object{
        const val BASE_URL = "https://kinopoiskapiunofficial.tech/api/v2.2/films/"
        const val API_KEY = "e30ffed0-76ab-4dd6-b41f-4c9da2b2735b"
    }
}