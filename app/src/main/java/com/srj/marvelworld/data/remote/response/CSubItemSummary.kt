package com.srj.marvelworld.data.remote.response

import com.google.gson.annotations.SerializedName

// Sub list summary for Character & Creator list
data class CSubItemSummary(
    @SerializedName("resourceURI") val resourceURI: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("role") val role: String?,
)