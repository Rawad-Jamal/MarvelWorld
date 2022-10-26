package com.srj.marvelworld.data.remote.response.dto

import com.google.gson.annotations.SerializedName
import com.srj.marvelworld.data.remote.response.*

data class ComicDTO(
    @SerializedName("id") val id: Int?,
    @SerializedName("digitalId") val digitalId: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("issueNumber") val issueNumber: Double?,
    @SerializedName("variantDescription") val variantDescription: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("modified") val modified: String?,
    @SerializedName("pageCount") val pageCount: Int?,
    @SerializedName("textObjects") val textObjects: List<TextObject>?,
    @SerializedName("resourceURI") val resourceURI: String?,
    @SerializedName("urls") val urls: List<Url>?,
    @SerializedName("thumbnail") val thumbnail: Image?,
    @SerializedName("images") val images: List<Image>?,
    @SerializedName("variants") val variants: List<SubItemSummary>?,
    @SerializedName("collections") val collections: List<SubItemSummary>?,
    @SerializedName("collectedIssues") val collectedIssues: List<SubItemSummary>?,
    @SerializedName("dates") val dates: List<ItemDate>?,
    @SerializedName("prices") val prices: List<ItemPrice>?,
    @SerializedName("characters") val characters: CSubList?,
    @SerializedName("creators") val creators: CSubList?,
    @SerializedName("stories") val stories: StoryList?,
    @SerializedName("events") val events: SubList?,
    @SerializedName("series") val series: SubItemSummary?,
)