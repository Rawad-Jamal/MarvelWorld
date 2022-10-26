package com.srj.marvelworld.data.remote.response

import com.google.gson.annotations.SerializedName

data class ItemDate(
    @SerializedName("type") val type: String?,
    @SerializedName("date") val date: String?,
)