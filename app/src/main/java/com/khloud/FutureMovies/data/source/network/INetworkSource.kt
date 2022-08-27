package com.khloud.FutureMovies.data.source.network

import com.khloud.FutureMovies.data.model.MovieDetails
import com.khloud.FutureMovies.data.model.MoviesResponse

interface INetworkSource {

    suspend fun searchMovie(search: String,page: Int): MoviesResponse
    suspend fun getMoviesCategory(category: String, page: Int): MoviesResponse
    suspend fun movieDetails(id: Int): MovieDetails
    suspend fun rankMovies(page: Int): MoviesResponse

}