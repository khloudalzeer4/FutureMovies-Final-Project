package com.khloud.torrentmovies.data.source.network

import com.khloud.torrentmovies.data.model.MovieDetails
import com.khloud.torrentmovies.data.model.MoviesResponse

class NetworkSourceImpl(private val apiService: ApiService):
    INetworkSource {


    override suspend fun searchMovie(search: String, page: Int): MoviesResponse = apiService.searchInMovie(search, page)

    override suspend fun getMoviesCategory(category: String, page: Int): MoviesResponse
            = apiService.getMoviesCategoryList(category, page)

    override suspend fun movieDetails(id: Int): MovieDetails =
        apiService.getMovieDetails(id)

    override suspend fun rankMovies(page: Int): MoviesResponse =
        apiService.getRankMovies(page)
}