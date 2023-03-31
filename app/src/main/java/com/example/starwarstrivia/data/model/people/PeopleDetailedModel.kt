package com.example.starwarstrivia.data.model.people


import com.google.gson.annotations.SerializedName

data class PeopleDetailedModel(
    @SerializedName("message")
    val message: String? = "",
    @SerializedName("result")
    val result: ResultModel? = ResultModel()
)