package com.br.anabibelforscher.cineme.usecase

import com.br.anabibelforscher.cineme.data.MovieRepository

class MovieListUseCase (private val movieRepository: MovieRepository) {
    operator fun invoke () = movieRepository.getAllMoviesFromDataSource()
}