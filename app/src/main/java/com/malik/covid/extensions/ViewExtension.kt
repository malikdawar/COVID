package com.malik.covid.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.malik.covid.listeners.SingleClickListener
import com.malik.covid.prefences.PrefManager
import com.google.gson.Gson

/**
 * Click Extension function works as listener setter that prevents double click on the view it´s set
 * @return view
 * @author Dawar Malik.
 */
fun View.singleClick(l: (View?) -> Unit) {
    setOnClickListener(SingleClickListener(l))
}

/**
 * Extension function to show toast message
 * @return void
 * @author Dawar Malik.
 */
fun Context.showToastMsg(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/**
 * An Extension to save Object in Preferences.
 * @param dataObject as Object.
 * @param key to Map in Pref.
 * @return void.
 * @author Dawar Malik.
 */
fun Context.saveDataObjectInPref(dataObject: Any?, key: String) {
    val json = Gson().toJson(dataObject)
    PrefManager(this).putStringPref(key, json)
}

/**
 * An Extension to close keyboard.
 * @return void
 * @author Dawar Malik.
 */
fun View.closeKeyboard() {
    val imm =
        this.context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}

/**
 * An Extension to Show keyboard
 * @return void
 * @author Dawar Malik.
 */
fun View.showKeyBoard(){
    val imm = this.context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}

/**
 * An Extension to make view Visible
 * @return void
 * @author Dawar Malik.
 */
fun View.visible() {
    visibility = View.VISIBLE
}

/**
 * An Extension to make view InVisible
 * @return void
 * @author Dawar Malik.
 */
fun View.invisible() {
    visibility = View.INVISIBLE
}

/**
 * An Extension to make view Gone
 * @return void
 * @author Dawar Malik.
 */
fun View.gone() {
    visibility = View.GONE
}

/**
 * An Extension to getColorCompat of view via context
 * @return void
 * @author Dawar Malik.
 */
fun Context.getColorCompat(@ColorRes colorRes: Int) = ContextCompat.getColor(this, colorRes)

/**
 * An Extension to getColorCompat via fragment
 * @return void
 * @author Dawar Malik.
 */
fun Fragment.getColor(@ColorRes colorRes: Int) = ContextCompat.getColor(requireContext(), colorRes)

/**
 * An Extension to start Activity
 * @return void
 * @author Dawar Malik.
 */
fun Activity.startActivityNewTask(clazz: Class<*>) {
    val intent = Intent(this, clazz)
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
    startActivity(intent)
}