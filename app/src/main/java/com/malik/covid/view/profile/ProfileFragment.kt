package com.malik.covid.view.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.malik.covid.R
import com.malik.covid.base.BaseFragment
import com.malik.covid.models.dao.UserDao
import com.malik.covid.viewmodel.ProfileViewModel

class ProfileFragment : BaseFragment(), ProfileViewModel.View {

    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile_user, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        profileViewModel.let {
            it.attachView(this)
            it.addObserver(this)
            //TODO: userId will be dynamic but for understanding i have given 12 as value
            it.getUserDetails("12")
        }
    }


    override fun onDetailsUpdateError(error: String) {

    }

    override fun showProgressBar() {

    }

    override fun dismissProgressBar() {

    }

    override fun onUserProfile(userDao: UserDao) {

    }

}