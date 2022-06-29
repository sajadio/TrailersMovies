package com.example.trailers.data.repository.home

import com.example.trailers.data.model.movie.common.Common
import com.example.trailers.data.model.movie.trend.TrendMovie
import com.example.trailers.utils.NetworkStatus
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    suspend fun getTrendMovie(): Flow<NetworkStatus<TrendMovie>>
    suspend fun getMoviePopular(): Flow<NetworkStatus<Common>>
    suspend fun getMovieTopRated(): Flow<NetworkStatus<Common>>
    suspend fun getUpComingMovie(): Flow<NetworkStatus<Common>>

}