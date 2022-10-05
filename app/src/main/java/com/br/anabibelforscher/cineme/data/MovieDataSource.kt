package com.br.anabibelforscher.cineme.data

import com.br.anabibelforscher.cineme.domain.Movie

interface MovieDataSource {
    fun getAllMovies() : List<Movie>
}