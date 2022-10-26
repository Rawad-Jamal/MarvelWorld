package com.srj.marvelworld.data.remote.response

import com.google.gson.annotations.SerializedName

data class ItemPrice(
    @SerializedName("type") val type: String?,
    @SerializedName("price") val price: Float?,
)