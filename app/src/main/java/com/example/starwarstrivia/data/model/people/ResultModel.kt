package com.example.starwarstrivia.data.model.people


import com.google.gson.annotations.SerializedName

data class ResultModel(
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("_id")
    val id: String? = "",
    @SerializedName("properties")
    val properties: PropertiesModel? = PropertiesModel(),
    @SerializedName("uid")
    val uid: String? = "",
    @SerializedName("__v")
    val v: Int? = 0
)