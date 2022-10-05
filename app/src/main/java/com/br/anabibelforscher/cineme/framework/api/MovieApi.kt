package com.br.anabibelforscher.cineme.framework.api

import com.br.anabibelforscher.cineme.domain.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    @GET("anabibelforscher/FilmesFlixJson/main/moviesList")
    fun getAllMovies(): Call<List<Movie>>

}