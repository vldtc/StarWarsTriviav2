package com.example.starwarstrivia.data.model.planets


import com.google.gson.annotations.SerializedName

data class PlanetsResultModel(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("uid")
    val uid: String? = "",
    @SerializedName("url")
    val url: String? = ""
)