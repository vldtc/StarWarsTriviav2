package com.example.starwarstrivia.data.model.species


import com.google.gson.annotations.SerializedName

data class SpeciesResultModel(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("uid")
    val uid: String? = "",
    @SerializedName("url")
    val url: String? = ""
)