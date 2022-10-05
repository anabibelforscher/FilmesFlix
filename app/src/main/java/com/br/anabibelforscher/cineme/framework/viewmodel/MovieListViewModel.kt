package com.br.anabibelforscher.cineme.framework.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.anabibelforscher.cineme.framework.api.MovieRestApiTask
import com.br.anabibelforscher.cineme.data.MovieRepository
import com.br.anabibelforscher.cineme.domain.Movie
import com.br.anabibelforscher.cineme.implementations.MovieDataSourceImplementation
import com.br.anabibelforscher.cineme.usecase.MovieListUseCase

class MovieListViewModel : ViewModel() {

    companion object {
        const val TAG = "MovieRepository"
    }

    private val movieRestApiTask = MovieRestApiTask()
    private val movieDataSource = MovieDataSourceImplementation(movieRestApiTask)
    private val movieRepository = MovieRepository(movieDataSource)
    private val movieListUseCase = MovieListUseCase(movieRepository)

    private var listMutableLiveData = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
        get() = listMutableLiveData

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {
        Thread{
            try {
                listMutableLiveData.postValue(movieListUseCase.invoke())
            } catch (exception : Exception){
                Log.d(TAG, exception.message.toString())

            }
        }.start()
    }
}