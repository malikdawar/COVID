package com.malik.covid.prefences

import android.content.Context


class PrefManager(private var context: Context) {

    fun putStringPref(key: String, value: String) {
        val sharedPreferences = context.getSharedPreferences("SessionDetails", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getStringPref(key: String, defaultKey: String): String? {
        val sharedPreferences = context.getSharedPreferences("SessionDetails", Context.MODE_PRIVATE)
        return sharedPreferences.getString(key, defaultKey)
    }

    fun putIntPref(key: String, value: Int) {
        val sharedPreferences = context.getSharedPreferences("SessionDetails", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun getInt(key: String, defaultKey: Int): Int? {
        val sharedPreferences = context.getSharedPreferences("SessionDetails", Context.MODE_PRIVATE)
        return sharedPreferences.getInt(key, defaultKey)
    }

    fun putBooleanPref(key: String, value: Boolean) {
        val sharedPreferences = context.getSharedPreferences("SessionDetails", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBoolean(key: String, defaultKey: Boolean): Boolean? {
        val sharedPreferences = context.getSharedPreferences("SessionDetails", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(key, defaultKey)
    }

    fun putFloatPref(key: String, value: Float) {
        val sharedPreferences = context.getSharedPreferences("SessionDetails", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putFloat(key, value)
        editor.apply()
    }

    fun getFloat(key: String, defaultKey: Float): Float {
        val sharedPreferences = context.getSharedPreferences("SessionDetails", Context.MODE_PRIVATE)
        return sharedPreferences.getFloat(key, defaultKey)
    }

    fun deleteSpec(key: String) {
        val sharedPreferences = context.getSharedPreferences("SessionDetails", Context.MODE_PRIVATE)
        val ed = sharedPreferences.edit()
        ed.remove(key)
        ed.apply()
    }

    fun logoutSession() {
        val sharedPreferences = context.getSharedPreferences("SessionDetails", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}
