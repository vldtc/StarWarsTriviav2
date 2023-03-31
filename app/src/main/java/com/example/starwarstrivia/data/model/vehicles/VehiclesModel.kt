package com.example.starwarstrivia.data.model.vehicles


import com.google.gson.annotations.SerializedName

data class VehiclesModel(
    @SerializedName("message")
    val message: String? = "",
    @SerializedName("next")
    val next: String? = "",
    @SerializedName("previous")
    val previous: String? = "",
    @SerializedName("results")
    val results: List<VehiclesResultModel?>? = listOf(),
    @SerializedName("total_pages")
    val totalPages: Int? = 0,
    @SerializedName("total_records")
    val totalRecords: Int? = 0
)