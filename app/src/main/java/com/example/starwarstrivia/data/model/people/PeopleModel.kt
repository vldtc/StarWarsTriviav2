package com.example.starwarstrivia.data.model.people


import com.google.gson.annotations.SerializedName

data class PeopleModel(
    @SerializedName("message")
    val message: String? = "",
    @SerializedName("next")
    val next: String? = "",
    @SerializedName("previous")
    val previous: String? = "",
    @SerializedName("results")
    val results: List<PeopleResultModel?>? = listOf(),
    @SerializedName("total_pages")
    val totalPages: Int? = 0,
    @SerializedName("total_records")
    val totalRecords: Int? = 0
)


