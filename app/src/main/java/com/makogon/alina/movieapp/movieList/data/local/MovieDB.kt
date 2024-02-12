package com.makogon.alina.movieapp.movieList.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.makogon.alina.movieapp.movieList.data.GenresConverter
import com.makogon.alina.movieapp.movieList.data.local.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 2)
@TypeConverters(GenresConverter::class/*, ContriesConverter::class*/)
abstract class MovieDB:RoomDatabase() {
    abstract val movieDao: MovieDao
}