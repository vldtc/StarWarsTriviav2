package com.example.starwarstrivia.data.model.people


import com.google.gson.annotations.SerializedName

data class PropertiesModel(
    @SerializedName("birth_year")
    val birthYear: String? = "",
    @SerializedName("created")
    val created: String? = "",
    @SerializedName("edited")
    val edited: String? = "",
    @SerializedName("eye_color")
    val eyeColor: String? = "",
    @SerializedName("gender")
    val gender: String? = "",
    @SerializedName("hair_color")
    val hairColor: String? = "",
    @SerializedName("height")
    val height: String? = "",
    @SerializedName("homeworld")
    val homeworld: String? = "",
    @SerializedName("mass")
    val mass: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("skin_color")
    val skinColor: String? = "",
    @SerializedName("url")
    val url: String? = ""
)