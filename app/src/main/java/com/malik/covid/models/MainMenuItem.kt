package com.malik.covid.models

import com.google.gson.annotations.SerializedName

data class MainMenuItem(
    @SerializedName("icon")
    var icon: Int = 0,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("description")
    var description: String? = null
)