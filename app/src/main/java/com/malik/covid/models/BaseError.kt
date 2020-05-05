package com.malik.covid.models

import com.google.gson.annotations.SerializedName

open class BaseError(
    @SerializedName("errorMessage")
    val errorMessage: String = "",
    @SerializedName("errorCode")
    val errorCode: String = ""
)