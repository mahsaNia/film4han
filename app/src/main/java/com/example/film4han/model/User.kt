package com.example.film4han.model

data class User(
    val username: String,
    val averageRating: Double,
    val downloadedMovies: Int,
    val email: String,
    val birthDate: String,
    val phoneNumber: String
)