package com.example.starwarstrivia.data.model.starships


import com.google.gson.annotations.SerializedName

data class StarshipsResultModel(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("uid")
    val uid: String? = "",
    @SerializedName("url")
    val url: String? = ""
)