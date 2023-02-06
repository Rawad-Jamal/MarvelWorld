package com.srj.marvelworld.data.remote.request

import com.srj.marvelworld.data.remote.response.DataWrapper
import com.srj.marvelworld.data.remote.response.dto.*
import com.srj.marvelworld.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
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


    @GET("characters/{characterId}")
    suspend fun getCharacterById(@Path("characterId")characterId:Int): Response<DataWrapper<CharacterDTO>>

    @GET("characters/{characterId}/comics")
    suspend fun getCharacterComicsById(@Path("characterId")characterId:Int): Response<DataWrapper<ComicDTO>>

    @GET("characters/{characterId}/events")
    suspend fun getCharacterEventsById(@Path("characterId")characterId:Int): Response<DataWrapper<EventDTO>>

    @GET("characters/{characterId}/series")
    suspend fun getCharacterSeriesById(@Path("characterId")characterId:Int): Response<DataWrapper<SeriesDTO>>

    @GET("characters/{characterId}/stories")
    suspend fun getCharacterStoriesById(@Path("characterId")characterId:Int): Response<DataWrapper<StoryDTO>>

}