package com.sajjadio.trailers.data.dataSource.local.entites

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sajjadio.trailers.utils.Constant.POPULAR_MOVIE_TABLE_NAME


@Entity(tableName = POPULAR_MOVIE_TABLE_NAME)
data class PopularMovieEntity(
    @PrimaryKey
    val id: Int,
    val original_title: String?,
    val poster_path: String?,
    val release_date: String?,
    val vote_average: Double?,
)