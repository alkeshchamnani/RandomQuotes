package com.alkesh.randomquote.core.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class QuoteDto(
    @Expose @SerializedName("id") val id: String?,
    @Expose @SerializedName("author") val author: String?,
    @Expose @SerializedName("en") val quote: String?
) {
}