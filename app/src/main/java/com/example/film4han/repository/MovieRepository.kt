package com.example.film4han.repository

import android.content.Context
import com.example.film4han.database.AppDatabase
import com.example.film4han.database.MovieEntity
import com.example.film4han.model.AuthRequest
import com.example.film4han.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(context: Context) {
    private val api = RetrofitInstance.api
    private val dao = AppDatabase.getInstance(context).movieDao()

    /** 1. Fetch from API, save in Room */
    suspend fun refreshTop5() {
        val list = api.getTop5Movies()
        val entities = list.map {
            MovieEntity(it.id, it.title, it.rating, it.genres, it.description, it.posterUrl)
        }
        withContext(Dispatchers.IO) {
            dao.clear()
            dao.insertAll(entities)
        }
    }

    /** 2. Read locally */
    suspend fun getLocalTop5(): List<MovieEntity> = withContext(Dispatchers.IO) {
        dao.getAll()
    }

    /** 3. Other calls */
    suspend fun getLatest() = api.getLatestMovies()
    suspend fun getDetail(id: Int) = api.getMovieDetail(id)
    suspend fun getProfile() = api.getUserProfile()
    suspend fun search(query: String) = api.searchMovies(query)
    suspend fun login(email: String, pass: String) = api.login(AuthRequest(email, pass))
    suspend fun signup(email: String, pass: String) = api.signup(AuthRequest(email, pass))
}