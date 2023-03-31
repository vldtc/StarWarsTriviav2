package com.example.starwarstrivia.data.model.vehicles


import com.google.gson.annotations.SerializedName

data class VehiclesResultModel(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("uid")
    val uid: String? = "",
    @SerializedName("url")
    val url: String? = ""
)