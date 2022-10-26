package com.srj.marvelworld.data.remote.response

import com.google.gson.annotations.SerializedName

data class StoryList(
    @SerializedName("available") val available: Int?,
    @SerializedName("returned") val returned: Int?,
    @SerializedName("collectionURI") val collectionURI: String?,
    @SerializedName("items") val items: List<SubItemStorySummary>?,
)