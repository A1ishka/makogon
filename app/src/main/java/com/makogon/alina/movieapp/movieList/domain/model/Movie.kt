package com.makogon.alina.movieapp.movieList.domain.model

data class Movie(
    val countries: List<String>,
    val filmId: Int,
    val filmLength: String,
    val genres: List<String>,
    val isAfisha: Int,
    val isRatingUp: Boolean?,
    val nameEn: String,
    val nameRu: String,
    val posterUrl: String,
    val posterUrlPreview: String,
    val rating: String,
    val ratingChange: Boolean?,
    val ratingVoteCount: Int,
    val year: String,
    var isFavorite: Boolean
)

