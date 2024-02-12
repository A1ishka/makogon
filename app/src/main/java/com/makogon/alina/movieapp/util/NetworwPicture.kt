package com.makogon.alina.movieapp.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImagePainter
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