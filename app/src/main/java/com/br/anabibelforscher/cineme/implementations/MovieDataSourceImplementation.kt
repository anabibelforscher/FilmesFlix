package com.br.anabibelforscher.cineme.implementations

import android.util.Log
import com.br.anabibelforscher.cineme.framework.api.MovieRestApiTask
import com.br.anabibelforscher.cineme.data.MovieDataSource
import com.br.anabibelforscher.cineme.domain.Movie

class MovieDataSourceImplementation(private val movieRestApiTask: MovieRestApiTask) :
    MovieDataSource {
    companion object {
        const val TAG = "MovieRepository"
    }

    private val movieList = arrayListOf<Movie>()

    override fun getAllMovies(): List<Movie> {
        val request = movieRestApiTask.retrofitApi().getAllMovies().execute()

        if (request.isSuccessful) {
            request.body()?.let {
                movieList.addAll(it)
            }
        } else {
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }
        }
        return movieList
    }
}