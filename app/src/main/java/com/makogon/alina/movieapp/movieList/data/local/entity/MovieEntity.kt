package com.makogon.alina.movieapp.movieList.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieEntity(
    val countries: List<String>,

    @PrimaryKey
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
    val isFavorite: Boolean
)