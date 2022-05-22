package com.example.trailers.data.network

import com.example.trailers.data.model.movie.id.Genre
import com.example.trailers.data.model.movie.popular.PopularMovie
import com.example.trailers.data.model.movie.rate.TopRatedMovie
import com.example.trailers.data.model.movie.upcoming.UPComingMovie
import com.example.trailers.data.model.search.Search
import com.example.trailers.data.model.tv.popular.PopularTV
import com.example.trailers.data.model.trend.Trending
import com.example.trailers.utils.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular?")
    suspend fun getMoviePopular(
        @Query("api_key") key: String = Constant.API_KEY,
        @Query("page") page: Int = 1,
    ): PopularMovie

    @GET("movie/top_rated?")
    suspend fun getMovieTopRated(
        @Query("api_key") key: String = Constant.API_KEY,
        @Query("page") page: Int = 1,
    ): TopRatedMovie

    @GET("movie/upcoming?")
    suspend fun getUpComingMovie(
        @Query("api_key") key: String = Constant.API_KEY,
        @Query("page") page: Int = 1,
    ): UPComingMovie

    @GET("movie/{id}/videos?")
    suspend fun getMovieTrailer(
        @Path("id") id: Int,
        @Query("api_key") key: String,
    ): Response<Any>

    @GET("movie/{id}?")
    suspend fun getMoviesDetails(
        @Path("id") page: Int,
        @Query("api_key") key: String,
    ): Response<Any>


    @GET("genre/movie/list")
    suspend fun getMovieGenres(
        @Query("api_key") key: String = Constant.API_KEY
    ): Genre

    /*----------------------------------TV-----------------------------------------*/

    @GET("tv/popular?")
    suspend fun getTVPopular(
        @Query("api_key") key: String = Constant.API_KEY,
        @Query("page") page: Int = 1,
    ): PopularTV

    @GET("tv/{id}/videos?")
    suspend fun getTVTrailer(
        @Path("id") id: Int,
        @Query("api_key") key: String,
    ): Response<Any>

    @GET("tv/{id}?")
    suspend fun getTvDetails(
        @Path("id") page: Int,
        @Query("api_key") key: String,
    ): Response<Any>

    @GET("/tv/{tv_id}/season/{season_number}")
    suspend fun getSeasons(
        @Path("tv_id") tv_id: Int,
        @Path("season_number") season_number: Int,
        @Query("api_key") key: String,
    )

    @GET("/tv/{tv_id}/season/{season_number}/episode/{episode_number}/rating")
    suspend fun getEpisode(
        @Path("id") id: Int,
        @Path("season_number") season_number: Int,
        @Path("episode_number") episode_number: Int,
        @Query("api_key") key: String,
    )

    @GET("/genre/tv/list")
    suspend fun getTVGenres(
        @Query("api_key") key: String,
    )

    /*----------------------------------Both-----------------------------------------*/

    @GET("trending/all/day?")
    suspend fun getTrending(
        @Query("api_key") key: String = Constant.API_KEY,
    ): Trending


    @GET("search/multi?")
    suspend fun getMultiSearch(
        @Query("api_key") key: String = Constant.API_KEY,
        @Query("query") query: String,
        @Query("page") page: Int,
    ): Search
}