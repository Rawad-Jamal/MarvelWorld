package com.srj.marvelworld.ui.characterDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.srj.marvelworld.data.remote.request.UiState
import com.srj.marvelworld.data.repository.MarvelRepository
import com.srj.marvelworld.domain.model.*
import com.srj.marvelworld.domain.types.MarvelContentType
import com.srj.marvelworld.ui.base.BaseViewModel
import com.srj.marvelworld.ui.home.HomeInteractionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val marvelRepository: MarvelRepository,
) : BaseViewModel(), HomeInteractionListener {

    private val _characterDetails = MutableLiveData<UiState<CharacterDetails>>()
    val characterDetails: LiveData<UiState<CharacterDetails>> get() = _characterDetails

    private val _listComics = MutableLiveData<UiState<List<Comic>>>()
    val listComics: LiveData<UiState<List<Comic>>> get() = _listComics

    private val _listEvents = MutableLiveData<UiState<List<Event>>>()
    val listEvents: LiveData<UiState<List<Event>>> get() = _listEvents

    private val _listSeries = MutableLiveData<UiState<List<Series>>>()
    val listSeries: LiveData<UiState<List<Series>>> get() = _listSeries

    private val _listStories = MutableLiveData<UiState<List<Story>>>()
    val listStories: LiveData<UiState<List<Story>>> get() = _listStories

    private val _currentType = MutableLiveData(MarvelContentType.COMICS)
    val currentType: LiveData<MarvelContentType> get() = _currentType

    fun onTabLayoutClick(marvelContentType: MarvelContentType) {
        _currentType.postValue(marvelContentType)
    }

    fun getCharacterData(characterId: Int){
        getCharacterDetails(characterId)
        getCharacterComics(characterId)
        getCharacterEvents(characterId)
        getCharacterSeries(characterId)
        getCharacterStories(characterId)

    }

    private fun getCharacterDetails(characterId: Int) {
        viewModelScope.launch {
            wrapResponse { marvelRepository.getCharacterById(characterId) }.collectLatest {
                _characterDetails.postValue(it)
            }
        }
    }

    private fun getCharacterComics(characterId: Int) {
        viewModelScope.launch {
            wrapResponse { marvelRepository.getComicsByCharacterId(characterId) }.collectLatest {
                _listComics.postValue(it)
            }
        }
    }

    private fun getCharacterEvents(characterId: Int) {
        viewModelScope.launch {
            wrapResponse { marvelRepository.getEventsByCharacterId(characterId) }.collectLatest {
                _listEvents.postValue(it)
            }
        }
    }

    private fun getCharacterSeries(characterId: Int) {
        viewModelScope.launch {
            wrapResponse { marvelRepository.getSeriesByCharacterId(characterId) }.collectLatest {
                _listSeries.postValue(it)
            }
        }
    }

    private fun getCharacterStories(characterId: Int) {
        viewModelScope.launch {
            wrapResponse { marvelRepository.getStoriesByCharacterId(characterId) }.collectLatest {
                _listStories.postValue(it)
            }
        }
    }

    override fun onItemClick(itemId: Int, itemType: MarvelContentType) {
        TODO("Not yet implemented")
    }


}


