package com.example.film4han.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val rating: Double,
    val genres: String,
    val description: String,
    val posterUrl: String
)