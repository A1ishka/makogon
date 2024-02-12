package com.makogon.alina.movieapp.movieList.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.makogon.alina.movieapp.R
import com.makogon.alina.movieapp.movieList.domain.model.Movie
import com.makogon.alina.movieapp.movieList.util.NetworkImage
import com.makogon.alina.movieapp.movieList.util.Screen

@Composable
fun MovieItem(
    movie: Movie,
    navHostController: NavHostController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                navHostController.navigate(Screen.Details.route + "/${movie.filmId}")
            }
    ) {
        NetworkImage(
            imageUrl = movie.posterUrl,
            contentDescription = "Example Image",
            modifier = Modifier.size(120.dp),
            placeholder = R.drawable.placeholder,
            error = R.drawable.image_load_failed
        )
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = movie.nameRu,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = buildGenreYearText(movie.genres, movie.year),
                color = Color.Gray,
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Box(
            modifier = Modifier
                .size(30.dp)
                .padding(end = 10.dp)
                .align(Alignment.CenterVertically)
        ) {
            if (movie.isFavorite) {
                Icon(
                    modifier = Modifier.align(Alignment.BottomEnd),
                    imageVector = Icons.Default.StarRate,
                    contentDescription = " "
                )
            } else {
                Icon(
                    modifier = Modifier.align(Alignment.BottomEnd),
                    imageVector = Icons.Default.StarOutline,
                    contentDescription = " "
                )
            }
        }
    }
}

private fun buildGenreYearText(genres: List<String>, year: String): String {
    val genresText = genres.joinToString(", ")
    return "$genresText ($year)"
}

@Preview
@Composable
fun PreviewMovieItem() {
    val movie = Movie(
        countries = listOf("USA", "UK"),
        filmLength = "2h 30m",
        genres = listOf("Action", "Adventure"),
        isAfisha = 1,
        isRatingUp = true,
        nameEn = "Movie Name (English)",
        filmId = 545,
        nameRu = "Movie Title",
        posterUrl = "https://kinopoiskapiunofficial.tech/images/posters/kp/545.jpg",
        posterUrlPreview = "https://kinopoiskapiunofficial.tech/images/posters/kp/545.jpg",
        rating = "80%",
        ratingChange = true,
        ratingVoteCount = 1000,
        year = "2022",
        isFavorite = true
    )

    val navHostController = rememberNavController()

    MaterialTheme {
        MovieItem(
            movie = movie,
            navHostController = navHostController
        )
    }
}