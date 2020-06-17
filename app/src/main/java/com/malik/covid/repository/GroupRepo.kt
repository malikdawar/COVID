package com.malik.covid.repository

import com.malik.covid.network.ApiInterface
import com.malik.covid.network.RetrofitClient
import com.malik.covid.utils.Constants

/**
 * Created by George Thomas on 12/06/20
 */
class GroupRepo {

    var apiInterface: ApiInterface? = null

    init {
        apiInterface= RetrofitClient.getInterfaceService(Constants.BASE_URL)
    }

    /*companion object {
        private var instance: GroupRepo= GroupRepo()
        @Synchronized
        fun getInstance(): GroupRepo {
            return instance
        }
    }*/
    companion object {
        private var instance: GroupRepo? = null

        fun getInstance(): GroupRepo {
            if (instance == null)
                instance = GroupRepo()
            return instance!!
        }
    }

    suspend fun getGroupDetails()= apiInterface?.getGroupDetails()


}