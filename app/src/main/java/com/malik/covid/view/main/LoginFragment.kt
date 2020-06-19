package com.malik.covid.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.malik.covid.R
import com.malik.covid.base.BaseFragment
import com.malik.covid.databinding.FragmentLoginBinding

/**
 * Created by George Thomas on 18/06/20
 */
class LoginFragment:BaseFragment() {

    lateinit var mBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login,container,false)
        initView()
        return mBinding.root
    }

    private fun initView() {
        mBinding.toolbar.profileImageHeader.visibility=View.GONE
        mBinding.toolbar.imgStack.visibility=View.GONE
        mBinding.toolbar.imgSearch.visibility=View.GONE
        mBinding.toolbar.imgBack.visibility=View.GONE
        mBinding.toolbar.txtHeading.visibility=View.VISIBLE
        mBinding.btConfirm.setOnClickListener{
            if(validateData()) {
                navigationToHome()
            }
        }
    }

    private fun validateData(): Boolean {
        return mBinding.etxtEmail.text.toString() != "" && mBinding.etxtPassword.text.toString() != ""
    }

    private fun navigationToHome() {
        NavHostFragment.findNavController(this).navigate(R.id.action_loginFragment_to_mainFragment)
    }
}