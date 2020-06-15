package com.malik.covid.network

import com.malik.covid.models.dao.UserDao
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiInterface {

    @POST("")
    suspend fun userProfile(@Body userId: String?): UserDao?

}
