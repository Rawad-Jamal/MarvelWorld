package com.srj.marvelworld.data.remote.response.dto

import com.google.gson.annotations.SerializedName
import com.srj.marvelworld.data.remote.response.*

data class SeriesDTO(
    @SerializedName("id") val id: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("resourceURI") val resourceURI: String?,
    @SerializedName("urls") val urls: List<Url>?,
    @SerializedName("startYear") val startYear: Int?,
    @SerializedName("endYear") val endYear: Int?,
    @SerializedName("rating") val rating: String?,
    @SerializedName("modified") val modified: String?,
    @SerializedName("thumbnail") val thumbnail: Image?,
    @SerializedName("comics") val comics: SubList?,
    @SerializedName("stories") val stories: StoryList?,
    @SerializedName("events") val events: SubList?,
    @SerializedName("characters") val characters: CSubList?,
    @SerializedName("creators") val creators: CSubList?,
    @SerializedName("next") val next: SubItemSummary?,
    @SerializedName("previous") val previous: SubItemSummary?,
)