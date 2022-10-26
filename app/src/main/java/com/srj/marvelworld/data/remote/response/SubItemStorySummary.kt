package com.srj.marvelworld.data.remote.response

import com.google.gson.annotations.SerializedName

data class SubItemStorySummary(
    @SerializedName("resourceURI") val resourceURI: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("type") val type: String?,
)