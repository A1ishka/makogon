package com.makogon.alina.movieapp.movieList.data.remote.response

data class MovieDto(
    val countries: List<Country>,
    val filmId: Int?,
    val filmLength: String?,
    val genres: List<Genre>,
    val isAfisha: Int?,
    val isRatingUp: Boolean?,
    val nameEn: String?,
    val nameRu: String?,
    val posterUrl: String?,
    val posterUrlPreview: String?,
    val rating: String?,
    val ratingChange: Boolean?,
    val ratingVoteCount: Int?,
    val year: String?
)