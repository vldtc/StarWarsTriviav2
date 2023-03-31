package com.example.starwarstrivia.data.model.people


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PeopleResultModel(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("uid")
    val uid: String? = "",
    @SerializedName("url")
    val url: String? = ""
) : Serializable