package com.example.film4han.network


import com.example.film4han.model.Movie
import com.example.film4han.model.User
import com.example.film4han.model.AuthRequest
import com.example.film4han.model.AuthResponse
import retrofit2.http.*

interface ApiService {
    @GET("movies/top5")
    suspend fun getTop5Movies(): List<Movie>

    @GET("movies/latest")
    suspend fun getLatestMovies(): List<Movie>

    @GET("movies/{id}")
    suspend fun getMovieDetail(@Path("id") id: Int): Movie

    @GET("user/profile")
    suspend fun getUserProfile(): User

    @GET("movies/search")
    suspend fun searchMovies(@Query("query") query: String): List<Movie>

    @POST("login")
    suspend fun login(@Body req: AuthRequest): AuthResponse

    @POST("signup")
    suspend fun signup(@Body req: AuthRequest): AuthResponse
}
