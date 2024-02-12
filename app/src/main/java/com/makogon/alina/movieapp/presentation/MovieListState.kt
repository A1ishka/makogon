package com.makogon.alina.movieapp.presentation

import com.makogon.alina.movieapp.movieList.domain.model.Movie

data class MovieListState(
    val isLoading: Boolean = false,
    val isCurrentPopularScreen: Boolean = true,
    val popularMovieList: List<Movie> = emptyList(),
    val favoriteMovieList: List<Movie> = emptyList()
) {
}