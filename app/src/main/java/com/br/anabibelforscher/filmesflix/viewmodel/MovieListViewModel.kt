package com.br.anabibelforscher.filmesflix.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.anabibelforscher.filmesflix.api.MovieRestApiTask
import com.br.anabibelforscher.filmesflix.model.Movie
import com.br.anabibelforscher.filmesflix.repository.MovieRepository

class MovieListViewModel : ViewModel() {

    companion object {
        const val TAG = "MovieRepository"
    }

    private val movieRestApiTask = MovieRestApiTask()
    private val movieRepository = MovieRepository(movieRestApiTask)

    private var listMutableLiveData = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
        get() = listMutableLiveData

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {
        Thread{
            try {
                listMutableLiveData.postValue(movieRepository.getAllMovies())
            } catch (exception : Exception){
                Log.d(TAG, exception.message.toString())

            }
        }.start()
    }
}