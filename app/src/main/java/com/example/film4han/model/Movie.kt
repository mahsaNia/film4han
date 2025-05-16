package com.example.film4han.model

data class Movie(
    val id: Int,
    val title: String,
    val rating: Double,
    val genres: String,
    val description: String,
    val posterUrl: String
)