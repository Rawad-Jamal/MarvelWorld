package com.srj.marvelworld.di

import com.srj.marvelworld.data.remote.request.MarvelApiService
import com.srj.marvelworld.data.remote.request.MarvelInterceptor
import com.srj.marvelworld.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideMarvelApiService(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): MarvelApiService {
        val marvelRetrofit = Retrofit.Builder()
            .baseUrl(Constants.MARVEL_BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
        return marvelRetrofit.create(MarvelApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: MarvelInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()

    @Singleton
    @Provides
    fun provideMarvelInterceptor(): MarvelInterceptor = MarvelInterceptor()
}