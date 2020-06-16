package com.malik.covid.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.malik.covid.base.BaseViewModel
import com.malik.covid.enums.Status
import com.malik.covid.models.Resource
import com.malik.covid.repository.GroupRepo
import com.onlive.covid.models.response.GroupDetailsResponse
import kotlinx.coroutines.Dispatchers
import org.koin.java.KoinJavaComponent

/**
 * Created by George Thomas on 12/06/20
 */
class GroupViewModel: BaseViewModel<GroupViewModel.View>() {

    private val mRepository: GroupRepo by KoinJavaComponent.inject(
        GroupRepo::class.java
    )
    private var lifecycleOwner: LifecycleOwner? = null

    fun addObserver(lifecycleOwner: LifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner
    }

    fun getGroupDetails() {
        /*viewModelScope.launch (Dispatchers.IO){
            try {
            group = GroupRepo.getInstance().getGroupDetails()!!
            } catch (e: Exception) {

            }
        }
        return group*/
        groupLiveData().observe(lifecycleOwner!!, Observer {
            it.run {
                when (this.status) {
                    Status.SUCCESS -> {
                        getView().dismissProgressBar()
                        getView().upDateGroupDetails(this.data!!)
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

    private fun groupLiveData() = liveData(Dispatchers.Main) {
        emit(Resource.loading(data = null))
        try {
            val data = mRepository.getGroupDetails()
            emit(Resource.success(data = data))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    interface View: BaseView{
        fun upDateGroupDetails(response:GroupDetailsResponse)
    }
}