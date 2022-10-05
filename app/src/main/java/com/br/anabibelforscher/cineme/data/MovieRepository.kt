package com.br.anabibelforscher.cineme.data

class MovieRepository(private val movieDataSource: MovieDataSource) {
    fun getAllMoviesFromDataSource() = movieDataSource.getAllMovies()
}