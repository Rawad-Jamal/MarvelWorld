package com.srj.marvelworld.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.srj.marvelworld.data.remote.request.UiState
import com.srj.marvelworld.data.repository.MarvelRepository
import com.srj.marvelworld.domain.model.*
import com.srj.marvelworld.domain.types.MarvelContentType
import com.srj.marvelworld.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val marvelRepository: MarvelRepository
) : BaseViewModel(), HomeInteractionListener {

    private val _listCharacters = MutableLiveData<UiState<List<Character>>>()
    val listCharacters: LiveData<UiState<List<Character>>> get() = _listCharacters

    private val _listComics = MutableLiveData<UiState<List<Comic>>>()
    val listComics: LiveData<UiState<List<Comic>>> get() = _listComics

    private val _listCreators = MutableLiveData<UiState<List<Creator>>>()
    val listCreators: LiveData<UiState<List<Creator>>> get() = _listCreators

    private val _listEvents = MutableLiveData<UiState<List<Event>>>()
    val listEvents: LiveData<UiState<List<Event>>> get() = _listEvents

    private val _listSeries = MutableLiveData<UiState<List<Series>>>()
    val listSeries: LiveData<UiState<List<Series>>> get() = _listSeries

    private val _listStories = MutableLiveData<UiState<List<Story>>>()
    val listStories: LiveData<UiState<List<Story>>> get() = _listStories

    private val _currentType = MutableLiveData<MarvelContentType>(MarvelContentType.CHARACTERS)
    val currentType: LiveData<MarvelContentType> get() = _currentType


    private val _totalItems = MutableLiveData<Int>()
    val totalItems: LiveData<Int> get() = _totalItems



    init {
        getAllCharacters()
        getAllComics()
        getAllCreators()
        getAllEvents()
        getAllSeries()
        getAllStories()

        getAllTypesDataTotals()
    }

    fun onChipClick(marvelContentType: MarvelContentType) {
        _currentType.postValue(marvelContentType)
    }


    private fun getAllCharacters() {
        viewModelScope.launch {
            wrapResponse { marvelRepository.getAllCharacters() }.collectLatest {
                _listCharacters.postValue(it)
            }
        }
    }

    private fun getAllComics() {
        viewModelScope.launch {
            wrapResponse { marvelRepository.getAllComics() }.collectLatest {
                _listComics.postValue(it)
            }
        }
    }

    private fun getAllCreators() {
        viewModelScope.launch {
            wrapResponse { marvelRepository.getAllCreators() }.collectLatest {
                _listCreators.postValue(it)
            }
        }
    }

    private fun getAllEvents() {
        viewModelScope.launch {
            wrapResponse { marvelRepository.getAllEvents() }.collectLatest {
                _listEvents.postValue(it)
            }
        }
    }

    private fun getAllSeries() {
        viewModelScope.launch {
            wrapResponse { marvelRepository.getAllSeries() }.collectLatest {
                _listSeries.postValue(it)
            }
        }
    }

    private fun getAllStories() {
        viewModelScope.launch {
            wrapResponse { marvelRepository.getAllStories() }.collectLatest {
                _listStories.postValue(it)
            }
        }
    }


    private fun getAllTypesDataTotals() {
        viewModelScope.launch {
            wrapResponse { marvelRepository.getAllTypesTotalData() }.collectLatest {
                _totalItems.postValue(it.toData()?.get(0))
            }
        }
    }

}