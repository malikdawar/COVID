package com.malik.covid.view.activities

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.malik.covid.R
import com.malik.covid.databinding.ActivityMainBinding
import com.malik.covid.extensions.invisible
import com.malik.covid.extensions.replaceFragmentSafely
import com.malik.covid.extensions.visible
import com.malik.covid.view.main.MainFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    View.OnClickListener {

        lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.navView.setNavigationItemSelectedListener(this)
        supportActionBar!!.hide()

    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){
            R.id.nav_home->{
                replaceFragmentSafely(fragment = MainFragment())
            }
        }

        return true
    }

    fun showNavigationDrawer(show: Boolean) {
        if (show) {
            mBinding.navView.visible()
        } else {
            mBinding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            mBinding.navView.invisible()
        }
    }

    private fun openDrawer() {
        mBinding.drawerLayout.openDrawer(GravityCompat.START)
    }

    override fun onBackPressed() {
        if (mBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mBinding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
            return
        }
    }

    fun showProgressBar(isVisible: Boolean){
        if(isVisible){
            mBinding.progressBar.visibility=View.VISIBLE
        }else{
            mBinding.progressBar.visibility=View.GONE
        }
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}