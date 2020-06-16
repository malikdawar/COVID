package com.malik.covid.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.malik.covid.base.BaseViewModel
import com.malik.covid.enums.Status
import com.malik.covid.models.Resource
import com.malik.covid.models.dao.UserDao
import com.malik.covid.repository.Repository
import kotlinx.coroutines.Dispatchers
import org.koin.java.KoinJavaComponent

class ProfileViewModel : BaseViewModel<ProfileViewModel.View>() {

    private val mRepository: Repository by KoinJavaComponent.inject(
        Repository::class.java
    )
    private var lifecycleOwner: LifecycleOwner? = null

    fun addObserver(lifecycleOwner: LifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner
    }

    fun getUserDetails(userId: String) {
        userLiveData(userId).observe(lifecycleOwner!!, Observer {
            it.run {
                when (this.status) {
                    Status.SUCCESS -> {
                        getView().dismissProgressBar()
                        getView().onUserProfile(this.data!!)
                    }
                    Status.ERROR -> {
                        getView().onDetailsUpdateError(it.message!!)
                        getView().dismissProgressBar()
                    }
                    Status.LOADING -> {
                        getView().showProgressBar()
                    }
                }
            }
        })
    }

    private fun userLiveData(userId: String) = liveData(Dispatchers.Main) {
        emit(Resource.loading(data = null))
        try {
            val data = mRepository.getUserProfile(userId)
            emit(Resource.success(data = data))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    interface View:BaseView {
        fun onUserProfile(userDao: UserDao)
    }
}