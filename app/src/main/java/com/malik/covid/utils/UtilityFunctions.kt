package com.malik.covid.utils

import okhttp3.MediaType
import okhttp3.RequestBody
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

/**
 * Created by Malik Dawar on 16/03/20.
 */
object UtilityFunctions {

    fun createNotificationId(): Int {
        val now = Date()
        return SimpleDateFormat("ddHHmmss", Locale.US).format(now).toInt()
    }

    /**
     * A method which test either password is valid or not.
     * @return Boolean : True, False.
     * @author Dawar Malik.
     */
    fun CharSequence?.isValidPassword() =
        !isNullOrEmpty() && this!!.length > 7 /*|| password.matches("[a-zA-Z0-9]+")*/

    /**
     * A method which test either email is valid or not.
     * @param email for validation.
     * @return Boolean : True, False.
     * @author Dawar Malik.
     */
    fun isValidEmail(email: String?): Boolean {
        return if (email.isNullOrBlank()) false
        else Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+").matcher(email).matches()
    }

    fun requestBody(requestBody: String): RequestBody {
        return RequestBody.create(MediaType.parse("text/plain"), requestBody)
    }
}