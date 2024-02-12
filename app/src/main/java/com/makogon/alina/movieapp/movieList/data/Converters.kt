package com.makogon.alina.movieapp.movieList.data

import androidx.room.TypeConverter

class GenresConverter {
    @TypeConverter
    fun fromGenres(genres: List<String>): String {
        return genres.joinToString(",")
    }

    @TypeConverter
    fun toGenres(genresString: String): List<String> {
        return genresString.split(",")
    }
}

//class ContriesConverter {
//    @TypeConverter
//    fun fromContries(contries: List<String>): String {
//        return contries.joinToString(",")
//    }
//
//    @TypeConverter
//    fun toContries(contriesString: String): List<String> {
//        return contriesString.split(",")
//    }
//}