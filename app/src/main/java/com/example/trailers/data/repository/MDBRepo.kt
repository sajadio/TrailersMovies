package com.example.trailers.data.repository

import com.example.trailers.data.network.ApiService
import com.example.trailers.utils.SafeApiCall
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MDBRepo @Inject constructor(
    private val api: ApiService,
) : SafeApiCall {

    fun getTrending() = safeApiCall { api.getTrending() }
    fun getMoviePopular() = safeApiCall { api.getMoviePopular() }
    fun getTVPopular() = safeApiCall { api.getTVPopular() }

//    fun filterResultPopular(filter:String): Flow<NetworkStatus<PopularTV>> {
//        if (filter == "Movie")
//            return getMoviePopular()
//        else
//            return getTVPopular()
//    }
}