package com.srj.marvelworld.data.remote.request

import okhttp3.Interceptor
import okhttp3.Response

class MarvelInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        with(chain.request()){
            url.newBuilder().apply {
                addQueryParameter(API_KEY_QPK,API_KEY)
                addQueryParameter(HASH_QPK,HASH)
                addQueryParameter(TIME_STAMP_QPK,TIME_STAMP)
            }.build().also { httpUrl ->
                return chain.proceed(chain.request().newBuilder().url(httpUrl).build())
            }
        }
    }

    companion object{
        const val API_KEY_QPK = "apikey"
        const val HASH_QPK = "hash"
        const val TIME_STAMP_QPK = "ts"

        const val API_KEY = "2e740d5494320b40a484c768d299f1d6"
        const val HASH = "b5e16f490b25a2b7aaa53e3ec8807beb"
        const val TIME_STAMP = "1"
    }

}