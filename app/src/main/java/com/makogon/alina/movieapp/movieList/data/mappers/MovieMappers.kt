package com.makogon.alina.movieapp.movieList.data.mappers

import com.makogon.alina.movieapp.movieList.data.local.entity.MovieEntity
import com.makogon.alina.movieapp.movieList.data.remote.response.MovieDto
import com.makogon.alina.movieapp.movieList.domain.model.Movie

fun MovieEntity.toMovie(): Movie {
    return Movie(
        countries = countries,
        filmId = filmId,
        filmLength = filmLength,
        genres = genres,
        isAfisha = isAfisha,
        isRatingUp = isRatingUp,
        nameEn = nameEn,
        nameRu = nameRu,
        posterUrl = posterUrl,
        posterUrlPreview = posterUrlPreview,
        rating = rating,
        ratingChange = ratingChange,
        ratingVoteCount = ratingVoteCount,
        year = year,
        isFavorite =isFavorite
    )
}

fun Movie.toMovieEntity(): MovieEntity {
    return MovieEntity(
        countries = countries,
        filmId = filmId,
        filmLength = filmLength,
        genres = genres,
        isAfisha = isAfisha,
        isRatingUp = isRatingUp,
        nameEn = nameEn,
        nameRu = nameRu,
        posterUrl = posterUrl,
        posterUrlPreview = posterUrlPreview,
        rating = rating,
        ratingChange = ratingChange,
        ratingVoteCount = ratingVoteCount,
        year = year,
        isFavorite =isFavorite
    )
}

fun MovieDto.toMovieEntity(): MovieEntity {
    return MovieEntity(
        countries = countries.map { it.country },
        filmId = filmId ?: -1,
        filmLength = filmLength ?: " ",
        genres = genres.map { it.genre },
        isAfisha = isAfisha ?: 0,
        isRatingUp = isRatingUp ?: false,
        nameEn = nameEn ?: " ",
        nameRu = nameRu ?: " ",
        posterUrl = posterUrl ?: " ",
        posterUrlPreview = posterUrlPreview ?: " ",
        rating = rating?:" ",//.toDouble() ?: 0.0,
        ratingChange = ratingChange ?: false,
        ratingVoteCount = ratingVoteCount ?: 0,
        year = year ?: " ",
        isFavorite = false
    )
}

fun MovieDto.toMovie(): Movie {
    return Movie(
        countries = countries.map { it.country },
        filmId = filmId ?: -1,
        filmLength = filmLength ?: " ",
        genres = genres.map { it.genre },
        isAfisha = isAfisha ?: 0,
        isRatingUp = isRatingUp ?: false,
        nameEn = nameEn ?: " ",
        nameRu = nameRu ?: " ",
        posterUrl = posterUrl ?: " ",
        posterUrlPreview = posterUrlPreview ?: " ",
        rating = rating?:" ",//.toDouble() ?: 0.0,
        ratingChange = ratingChange ?: false,
        ratingVoteCount = ratingVoteCount ?: 0,
        year = year ?: " ",
        isFavorite = false
    )
}