package com.malik.covid

import android.app.Application
import android.content.Context
import com.malik.covid.network.RetrofitClient
import com.malik.covid.repository.GroupRepo
import com.malik.covid.repository.Repository
import com.malik.covid.utils.Constants.BASE_URL
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        initDependencyInjection()
    }

    companion object {
        var instance: App? = null
        fun getAppContext(): Context {
            return instance as Context
        }
    }

    private fun initDependencyInjection() {
        val myModule = module {

            single { RetrofitClient.getInterfaceService(BASE_URL) }

            single { Repository.getInstance() }

            single { GroupRepo.getInstance() }

        }

        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(applicationContext)
            // declare modules
            modules(myModule)
        }
    }
}