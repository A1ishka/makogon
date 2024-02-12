package com.makogon.alina.movieapp.movieList.util

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter


@Composable
fun NetworkImage(
    imageUrl: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    placeholder: Int? = null,
    error: Int? = null,
    alpha: Float = 1f
) {
    val painter = rememberAsyncImagePainter(imageUrl)

//    when (painter.state) {
//        is AsyncImagePainter.State.Success -> {
//            Image(
//                painter = painter,
//                contentDescription = contentDescription,
//                modifier = modifier,
//                contentScale = contentScale,
//                alpha = alpha,
//            )
//        }
//
//        is AsyncImagePainter.State.Loading -> {
//            if (placeholder != null) {
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(Color.Gray),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Image(
//                        painter = painterResource(placeholder),
//                        contentDescription = null
//                    )
//                }
//            }
//        }
//
//        is AsyncImagePainter.State.Error -> {
//            if (error != null) {
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(Color.Gray),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Image(
//                        painter = painterResource(error),
//                        contentDescription = null
//                    )
//                }
//            }
//        }
//
//        AsyncImagePainter.State.Empty -> {
//            if (error != null) {
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(Color.Gray),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Image(
//                        painter = painterResource(error),
//                        contentDescription = null
//                    )
//                }
//            }
//        }
//    }

    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = contentScale,
        alpha = alpha,
    )
}