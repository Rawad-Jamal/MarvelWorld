package com.srj.marvelworld.data.remote.response.dto

import com.google.gson.annotations.SerializedName
import com.srj.marvelworld.data.remote.response.*

data class StoryDTO(
    @SerializedName("id") val id: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("resourceURI") val resourceURI: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("modified") val modified: String?,
    @SerializedName("thumbnail") val thumbnail: Image?,
    @SerializedName("comics") val comics: SubList?,
    @SerializedName("series") val series: SubList?,
    @SerializedName("events") val events: SubList?,
    @SerializedName("characters") val characters: CSubList?,
    @SerializedName("creators") val creators: CSubList?,
    @SerializedName("originalissue") val originalIssue: SubItemSummary?,
)