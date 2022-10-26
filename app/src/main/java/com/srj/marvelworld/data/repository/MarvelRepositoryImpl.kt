package com.srj.marvelworld.data.repository

import com.srj.marvelworld.data.remote.request.MarvelApiService
import com.srj.marvelworld.data.remote.response.DataWrapper
import com.srj.marvelworld.domain.mapper.*
import com.srj.marvelworld.domain.model.*
import retrofit2.Response
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val apiService: MarvelApiService,
    private val characterMapper: CharacterMapper,
    private val comicMapper: ComicMapper,
    private val creatorMapper: CreatorMapper,
    private val eventMapper: EventMapper,
    private val seriesMapper: SeriesMapper,
    private val storyMapper: StoryMapper,
): MarvelRepository {

    private fun <T> checkResponseData(response: Response<DataWrapper<T>>): Boolean = response.isSuccessful and !(response.body()?.data?.results).isNullOrEmpty()


    override suspend fun getAllCharacters(): List<Character> {
        return when(checkResponseData(apiService.getAllMarvelCharacters())){
            true -> apiService.getAllMarvelCharacters().body()?.data?.results?.map { characterMapper.mapping(it) }!!
            else -> emptyList()
        }
    }

    override suspend fun getAllComics(): List<Comic> {
        return when(checkResponseData(apiService.getAllMarvelComics())){
            true -> apiService.getAllMarvelComics().body()?.data?.results?.map { comicMapper.mapping(it) }!!
            else -> emptyList()
        }
    }

    override suspend fun getAllCreators(): List<Creator> {
        return when(checkResponseData(apiService.getAllMarvelCreators())){
            true -> apiService.getAllMarvelCreators().body()?.data?.results?.map { creatorMapper.mapping(it) }!!
            else -> emptyList()
        }
    }

    override suspend fun getAllEvents(): List<Event> {
        return when(checkResponseData(apiService.getAllMarvelEvents())){
            true -> apiService.getAllMarvelEvents().body()?.data?.results?.map { eventMapper.mapping(it) }!!
            else -> emptyList()
        }
    }

    override suspend fun getAllSeries(): List<Series> {
        return when(checkResponseData(apiService.getAllMarvelSeries())){
            true -> apiService.getAllMarvelSeries().body()?.data?.results?.map { seriesMapper.mapping(it) }!!
            else -> emptyList()
        }
    }

    override suspend fun getAllStories(): List<Story> {
        return when(checkResponseData(apiService.getAllMarvelStories())){
            true -> apiService.getAllMarvelStories().body()?.data?.results?.map { storyMapper.mapping(it) }!!
            else -> emptyList()
        }
    }

    private fun <T> setLimitOfData(response: Response<DataWrapper<T>>): Int {
        return when(checkResponseData(response)){
            true -> response.body()?.data?.total!!
            else -> 20
        }
    }

    override suspend fun getAllTypesTotalData(): List<Int> = listOf(
        setLimitOfData(apiService.getAllMarvelCharacters()),
        setLimitOfData(apiService.getAllMarvelComics()),
        setLimitOfData(apiService.getAllMarvelCreators()),
        setLimitOfData(apiService.getAllMarvelEvents()),
        setLimitOfData(apiService.getAllMarvelSeries()),
        setLimitOfData(apiService.getAllMarvelStories()),
    )

}