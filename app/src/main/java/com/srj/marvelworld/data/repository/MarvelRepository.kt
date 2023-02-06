package com.srj.marvelworld.data.repository

import com.srj.marvelworld.domain.model.*

interface MarvelRepository {
    suspend fun getAllCharacters(): List<Character>
    suspend fun getAllComics(): List<Comic>
    suspend fun getAllCreators(): List<Creator>
    suspend fun getAllEvents(): List<Event>
    suspend fun getAllSeries(): List<Series>
    suspend fun getAllStories(): List<Story>

    suspend fun getCharacterById(characterId: Int): CharacterDetails
    suspend fun getComicsByCharacterId(characterId: Int): List<Comic>
    suspend fun getEventsByCharacterId(characterId: Int): List<Event>
    suspend fun getSeriesByCharacterId(characterId: Int): List<Series>
    suspend fun getStoriesByCharacterId(characterId: Int): List<Story>

    suspend fun getAllTypesTotalData(): List<Int>
}