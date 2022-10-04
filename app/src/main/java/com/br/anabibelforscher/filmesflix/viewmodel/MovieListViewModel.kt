package com.br.anabibelforscher.filmesflix.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.anabibelforscher.filmesflix.model.Movie

class MovieListViewModel : ViewModel() {

    private val listOfMovies = arrayListOf(
        Movie(
            id = 0,
            titulo = "Big Hero 6",
            descricao = null,
            imagem = null,
            dataLancamento = null
        ),
        Movie(
            id = 2,
            titulo = "How to Train Your Dragon",
            descricao = null,
            imagem = null,
            dataLancamento = null
        )
    )

    private var listMutableLiveData = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
        get() = listMutableLiveData

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {
        listMutableLiveData.value = listOfMovies
    }
}