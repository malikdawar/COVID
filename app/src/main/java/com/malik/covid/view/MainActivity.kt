package com.malik.covid.view

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.malik.covid.R
import com.malik.covid.extensions.gone
import com.malik.covid.extensions.invisible
import com.malik.covid.extensions.replaceFragmentSafely
import com.malik.covid.extensions.visible
import com.malik.covid.utils.InternetMonitor
import com.malik.covid.view.main.MainFragment
import com.malik.covid.view.splash.SplashFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    View.OnClickListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        drawer = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        toolBarMenuBtn.setOnClickListener(this)
        launchSplashFragment()

    }

    private fun launchSplashFragment() {
        replaceFragmentSafely(fragment = SplashFragment())
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){
            R.id.nav_home->{
                replaceFragmentSafely(fragment = MainFragment())
            }
        }

        return true
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.toolBarMenuBtn -> {
                openDrawer()
            }
        }
    }

    private val internetMonitor = InternetMonitor(object :
        InternetMonitor.OnInternetConnectivityListener {
        override fun onInternetAvailable() {
            runOnUiThread {
                top_connection_shower.gone()
            }
        }

        override fun onInternetLost() {
            runOnUiThread {
                top_connection_shower.visible()
            }
        }
    })

    fun showNavigationDrawer(show: Boolean) {
        if (show) {
            navigationView.visible()
        } else {
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            navigationView.invisible()
        }
    }

    fun showAndHideToolBar(show: Boolean) {
        toolBarLayout.visibility = if (show) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    private fun openDrawer() {
        drawer.openDrawer(GravityCompat.START)
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
            return
        }
    }

    override fun onResume() {
        super.onResume()
        internetMonitor.register(this)
    }

    override fun onPause() {
        super.onPause()
        internetMonitor.unregister(this)
    }
}