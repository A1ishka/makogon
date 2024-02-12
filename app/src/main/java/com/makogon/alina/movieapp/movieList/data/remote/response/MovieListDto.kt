package com.makogon.alina.movieapp.movieList.data.remote.response

data class MovieListDto(
    val films: List<MovieDto>,
    val pagesCount: Int
)