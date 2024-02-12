package com.makogon.alina.movieapp.movieList.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.makogon.alina.movieapp.R
import com.makogon.alina.movieapp.movieList.presentation.components.MovieItem
import com.makogon.alina.movieapp.movieList.util.Category

@Composable
fun FavoriteMovieScreen(
    movieListState: MovieListState,
    navHostController: NavHostController,
    onEvent: (MovieListEvent) -> Unit
) {
    if (movieListState.favoriteMovieList.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        color = Color.Blue,
                        text = stringResource(R.string.you_haven_t_saved_anything_yet)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        modifier = Modifier.background(Color.Blue),
                        onClick = {
                            navHostController.navigate("Home")
                        }
                    ) {
                        Text(
                            color = Color.White,
                            text = stringResource(R.string.explore)
                        )
                    }
                }
            }
        }
    } else {
        if (movieListState.isLoading) {
            CircularProgressIndicator()
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(vertical = 8.dp, horizontal = 4.dp)
            ) {
                items(movieListState.favoriteMovieList.size) { index ->
                    MovieItem(
                        movie = movieListState.favoriteMovieList[index],
                        navHostController = navHostController
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    if (index >= movieListState.favoriteMovieList.size - 1 && !movieListState.isLoading) {
                        onEvent(MovieListEvent.Paginate(Category.FAVORITE))
                    }
                }
            }
        }
    }
}