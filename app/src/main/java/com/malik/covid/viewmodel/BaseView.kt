package com.malik.covid.viewmodel

/**
 * Created by George Thomas on 15/06/20
 */
interface BaseView {

    fun showProgressBar()
    fun dismissProgressBar()
    fun onDetailsUpdateError(error: String)
}