package com.srj.marvelworld.data.remote.response.dto

import com.google.gson.annotations.SerializedName
import com.srj.marvelworld.data.remote.response.Image
import com.srj.marvelworld.data.remote.response.StoryList
import com.srj.marvelworld.data.remote.response.SubList
import com.srj.marvelworld.data.remote.response.Url

data class CreatorDTO(
    @SerializedName("id") val id: Int?,
    @SerializedName("firstName") val firstName: String?,
    @SerializedName("middleName") val middleName: String?,
    @SerializedName("lastName") val lastName: String?,
    @SerializedName("fullName") val fullName: String?,
    @SerializedName("suffix") val suffix: String?,
    @SerializedName("modified") val modified: String?,
    @SerializedName("resourceURI") val resourceURI: String?,
    @SerializedName("urls") val urls: List<Url>?,
    @SerializedName("thumbnail") val thumbnail: Image?,
    @SerializedName("comics") val comics: SubList?,
    @SerializedName("stories") val stories: StoryList?,
    @SerializedName("events") val events: SubList?,
    @SerializedName("series") val series: SubList?,
)