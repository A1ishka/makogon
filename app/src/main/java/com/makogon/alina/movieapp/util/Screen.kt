package com.makogon.alina.movieapp.util

sealed class Screen(val route:String){
    object Home:Screen("Home")
    object PopularMovieList:Screen("PopularMovie")
    object FavoriteMovieList:Screen("FavoriteMovie")
    object Details:Screen("Details")
}
