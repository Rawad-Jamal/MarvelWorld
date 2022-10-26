package com.srj.marvelworld.data.remote.response

import com.google.gson.annotations.SerializedName

// Base Response
data class DataWrapper<T>(
    @SerializedName("attributionHTML") val attributionHTML: String?,
    @SerializedName("attributionText") val attributionText: String?,
    @SerializedName("code") val code: Int?,
    @SerializedName("copyright") val copyright: String?,
    @SerializedName("data") val data: DataContainer<T>?,
    @SerializedName("etag") val etag: String?,
    @SerializedName("status") val status: String?
)