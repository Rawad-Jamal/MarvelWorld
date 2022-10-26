package com.srj.marvelworld.di

import com.srj.marvelworld.data.remote.request.MarvelApiService
import com.srj.marvelworld.data.repository.MarvelRepository
import com.srj.marvelworld.data.repository.MarvelRepositoryImpl
import com.srj.marvelworld.domain.mapper.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        apiService: MarvelApiService,
        characterMapper: CharacterMapper,
        comicMapper: ComicMapper,
        creatorMapper: CreatorMapper,
        eventMapper: EventMapper,
        seriesMapper: SeriesMapper,
        storyMapper: StoryMapper,

    ): MarvelRepository {
        return MarvelRepositoryImpl(apiService, characterMapper, comicMapper, creatorMapper, eventMapper, seriesMapper, storyMapper, )
    }

    @Singleton
    @Provides
    fun provideCharacterMapper(): CharacterMapper = CharacterMapper()

    @Singleton
    @Provides
    fun provideComicMapper(): ComicMapper = ComicMapper()

    @Singleton
    @Provides
    fun provideCreatorMapper(): CreatorMapper = CreatorMapper()

    @Singleton
    @Provides
    fun provideEventMapper(): EventMapper = EventMapper()

    @Singleton
    @Provides
    fun provideSeriesMapper(): SeriesMapper = SeriesMapper()

    @Singleton
    @Provides
    fun provideStoryMapper(): StoryMapper = StoryMapper()

}