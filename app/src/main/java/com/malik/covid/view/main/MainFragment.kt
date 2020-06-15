package com.malik.covid.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.malik.covid.R
import com.malik.covid.adapter.MainMenuAdapter
import com.malik.covid.base.BaseFragment
import com.malik.covid.extensions.getPopulatedList
import com.malik.covid.extensions.showToastMsg
import com.malik.covid.models.MainMenuItem
import com.malik.covid.utils.GridItemDecoration
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : BaseFragment(), MainMenuAdapter.MenuItemClickListener {
    private lateinit var mainMenuAdapter: MainMenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun itemClickListener(mainMenuItem: MainMenuItem) {
        context?.showToastMsg(mainMenuItem.description.toString())
    }
}
