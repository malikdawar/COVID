package com.malik.covid.network

import com.malik.covid.models.dao.UserDao
import com.onlive.covid.models.response.GroupDetailsResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiInterface {

    @POST("")
    suspend fun userProfile(@Body userId: String?): UserDao?

    @GET("onlive.george/1")
    suspend fun getGroupDetails() : GroupDetailsResponse

}
