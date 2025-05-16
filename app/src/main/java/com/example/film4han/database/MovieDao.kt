package com.example.film4han.database

import androidx.room.*

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<MovieEntity>)

    @Query("SELECT * FROM movies")
    suspend fun getAll(): List<MovieEntity>

    @Query("DELETE FROM movies")
    suspend fun clear()
}