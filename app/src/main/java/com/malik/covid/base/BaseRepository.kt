package com.malik.covid.base

import com.malik.covid.network.ApiInterface
import org.koin.java.KoinJavaComponent

abstract class BaseRepository {

    protected val apiInterface : ApiInterface by KoinJavaComponent.inject(
        ApiInterface::class.java
    )
}
