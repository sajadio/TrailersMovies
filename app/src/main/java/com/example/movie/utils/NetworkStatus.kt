package com.example.movie.utils

import okhttp3.ResponseBody
import retrofit2.Response

sealed class NetworkStatus<out T> {


    object Loading : NetworkStatus<Nothing>()
    data class Success<out T>(val data: T?) : NetworkStatus<T>()
    data class Error(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?,
    ) : NetworkStatus<Nothing>()

    fun data() = if (this is Success) data else null
}