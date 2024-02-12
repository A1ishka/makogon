package com.makogon.alina.movieapp.presentation

sealed interface MovieListEvent {
    data class Paginate(val category: String):MovieListEvent
    object Navigate: MovieListEvent
}