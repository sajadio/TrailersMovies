package com.example.movie.data.m

data class Movie(
    val ids: Int,
    val trend: List<Trend>,
    val category: List<Genres>,
    val type: List<Type>
)