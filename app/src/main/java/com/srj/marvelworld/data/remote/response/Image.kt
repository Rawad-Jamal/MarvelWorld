package com.srj.marvelworld.data.remote.response

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("path") val path: String?,
    @SerializedName("extension") val extension: String?,
)