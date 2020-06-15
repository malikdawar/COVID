package com.malik.covid.repository

import com.malik.covid.base.BaseRepository


/**
 *  The repository handling database operations for authentication flow.
 */
class Repository private constructor() : BaseRepository() {

    suspend fun getUserProfile(userId: String?) = apiInterface.userProfile(userId)


    companion object {
        private var instance: Repository? = null

        fun getInstance(): Repository {
            if (instance == null)
                instance = Repository()
            return instance!!
        }
    }
}