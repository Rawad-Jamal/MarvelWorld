package com.srj.marvelworld.data.remote.response

import com.google.gson.annotations.SerializedName

// Sub list for Character & Creator list
data class CSubList(
    @SerializedName("available") val available: Int?,
    @SerializedName("returned") val returned: Int?,
    @SerializedName("collectionURI") val collectionURI: String?,
    @SerializedName("items") val items: List<CSubItemSummary>?,
)