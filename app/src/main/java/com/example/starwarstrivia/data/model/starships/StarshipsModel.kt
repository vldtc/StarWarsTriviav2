package com.example.starwarstrivia.data.model.starships


import com.google.gson.annotations.SerializedName

data class StarshipsModel(
    @SerializedName("message")
    val message: String? = "",
    @SerializedName("next")
    val next: String? = "",
    @SerializedName("previous")
    val previous: String? = "",
    @SerializedName("results")
    val results: List<StarshipsResultModel?>? = listOf(),
    @SerializedName("total_pages")
    val totalPages: Int? = 0,
    @SerializedName("total_records")
    val totalRecords: Int? = 0
)