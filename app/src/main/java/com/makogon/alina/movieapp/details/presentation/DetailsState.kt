package com.makogon.alina.movieapp.details.presentation

import com.makogon.alina.movieapp.movieList.domain.model.Movie

data class DetailsState(
    val isLoading:Boolean=false,
    val movie: Movie?=null
)