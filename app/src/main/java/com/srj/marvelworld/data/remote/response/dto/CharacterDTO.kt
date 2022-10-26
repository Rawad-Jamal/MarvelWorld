package com.srj.marvelworld.data.remote.response.dto

import com.google.gson.annotations.SerializedName
import com.srj.marvelworld.data.remote.response.Image
import com.srj.marvelworld.data.remote.response.StoryList
import com.srj.marvelworld.data.remote.response.SubList
import com.srj.marvelworld.data.remote.response.Url

data class CharacterDTO(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("modified") val modified: String?,
    @SerializedName("resourceURI") val resourceURI: String?,
    @SerializedName("urls") val urls: List<Url>?,
    @SerializedName("thumbnail") val thumbnail: Image?,
    @SerializedName("comics") val comics: SubList?,
    @SerializedName("stories") val stories: StoryList?,
    @SerializedName("events") val events: SubList?,
    @SerializedName("series") val series: SubList?,
)