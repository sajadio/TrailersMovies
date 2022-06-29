package com.example.trailers.data.repository.common

import androidx.paging.PagingData
import com.example.trailers.data.model.movie.common.CommonResult
import kotlinx.coroutines.flow.Flow

interface CommonRepository {
    fun getPopularMoviePaging(): Flow<PagingData<CommonResult>>
    fun getTopRatedMoviePaging(): Flow<PagingData<CommonResult>>
    fun getUpComingMoviePaging(): Flow<PagingData<CommonResult>>
}