package com.malik.covid.view.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.malik.covid.R
import com.malik.covid.base.BaseFragment
import com.malik.covid.extensions.replaceFragment
import com.malik.covid.view.main.MainFragment

class SplashFragment : BaseFragment() {

    companion object {
        const val SPLASH_DURATION = 2500L
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mainActivity.showNavigationDrawer(false)
        mainActivity.showAndHideToolBar(false)
        return inflater.inflate(R.layout.splash_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Handler().postDelayed({
            replaceFragment(fragment = MainFragment())
        }, SPLASH_DURATION)
    }
}
