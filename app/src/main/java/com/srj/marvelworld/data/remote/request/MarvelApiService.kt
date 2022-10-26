package com.srj.marvelworld.data.remote.request

import com.srj.marvelworld.data.remote.response.DataWrapper
import com.srj.marvelworld.data.remote.response.dto.*
import com.srj.marvelworld.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiService {

    @GET("characters")
    suspend fun getAllMarvelCharacters(
        @Query("limit")limit:String = Constants.LIMIT
    ): Response<DataWrapper<CharacterDTO>>

    @GET("comics")
    suspend fun getAllMarvelComics(
        @Query("limit")limit:String = Constants.LIMIT
    ): Response<DataWrapper<ComicDTO>>

    @GET("creators")
    suspend fun getAllMarvelCreators(
        @Query("limit")limit:String = Constants.LIMIT
    ): Response<DataWrapper<CreatorDTO>>

    @GET("events")
    suspend fun getAllMarvelEvents(
        @Query("limit")limit:String = Constants.LIMIT
    ): Response<DataWrapper<EventDTO>>

    @GET("series")
    suspend fun getAllMarvelSeries(
        @Query("limit")limit:String = Constants.LIMIT
    ): Response<DataWrapper<SeriesDTO>>

    @GET("stories")
    suspend fun getAllMarvelStories(
        @Query("limit")limit:String = Constants.LIMIT
    ): Response<DataWrapper<StoryDTO>>

}