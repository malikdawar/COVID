package com.malik.covid.models.dao


import com.google.gson.annotations.SerializedName

data class UserDao(
    @SerializedName("user_name")
    val name: String?,
    @SerializedName("status")
    val status: Boolean = false
)


