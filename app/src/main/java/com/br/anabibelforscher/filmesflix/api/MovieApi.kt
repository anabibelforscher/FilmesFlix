package com.br.anabibelforscher.filmesflix.api

import com.br.anabibelforscher.filmesflix.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    @GET("anabibelforscher/FilmesFlixJson/main/moviesList")
    fun getAllMovies(): Call<List<Movie>>

}