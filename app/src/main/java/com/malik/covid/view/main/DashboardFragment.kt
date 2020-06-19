package com.malik.covid.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.malik.covid.R
import com.malik.covid.adapter.MainMenuAdapter
import com.malik.covid.base.BaseFragment
import com.malik.covid.databinding.DashboardFragmentBinding
import com.malik.covid.extensions.showToastMsg
import com.malik.covid.models.MainMenuItem
import com.malik.covid.view.activities.MainActivity
import com.malik.covid.viewmodel.GroupViewModel
import com.onlive.covid.models.response.GroupDetailsResponse

class DashboardFragment : BaseFragment(), MainMenuAdapter.MenuItemClickListener, GroupViewModel.View {

    private lateinit var mainMenuAdapter: MainMenuAdapter
    private val groupViewModel: GroupViewModel by viewModels()

    lateinit var mBinding: DashboardFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mBinding= DataBindingUtil.inflate(inflater,R.layout.dashboard_fragment, container, false)
        initView()
        return mBinding.root
    }

    private fun initView() {
        groupViewModel.let {
            it.attachView(this)
            it.addObserver(this)
            it.getGroupDetails()
        }
    }

    override fun itemClickListener(mainMenuItem: MainMenuItem) {
        context?.showToastMsg(mainMenuItem.description.toString())
    }

    override fun upDateGroupDetails(response: GroupDetailsResponse) {
        Toast.makeText(context,response.name.toString(),Toast.LENGTH_LONG).show()
    }

    override fun showProgressBar() {
        (activity as MainActivity).showProgressBar(true)
    }

    override fun dismissProgressBar() {
        (activity as MainActivity).showProgressBar(false)
    }

    override fun onDetailsUpdateError(error: String) {
        showErrorResponse()
    }

    private fun showErrorResponse() {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Please try again")
        builder.setMessage(resources.getString(R.string.common_error))
        builder.setPositiveButton(android.R.string.ok,null)

        builder.show()
    }
}
