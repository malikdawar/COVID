package com.malik.covid.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.kaopiz.kprogresshud.KProgressHUD
import com.malik.covid.prefences.PrefManager
import com.malik.covid.utils.DialogUtils
import com.malik.covid.view.activities.MainActivity

abstract class BaseFragment : Fragment() {

    protected lateinit var prefManager: PrefManager
    protected lateinit var mainActivity: MainActivity
    protected lateinit var progressDialog : KProgressHUD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        prefManager = PrefManager(mainActivity)
        progressDialog = DialogUtils.showProgressDialog(mainActivity, cancelable = false)

        mainActivity.showNavigationDrawer(true)
    }
}