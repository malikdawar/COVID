package com.malik.covid

import com.malik.covid.utils.UtilityFunctions
import com.malik.covid.utils.UtilityFunctions.isValidPassword
import junit.framework.Assert.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CovidUnitTest {

    @Test
    fun validEmail() {
        assertTrue(UtilityFunctions.isValidEmail("malik@gmail.com"))
    }

    @Test
    fun invalidEmailWithoutAT() {
        assertFalse(UtilityFunctions.isValidEmail("malikgmail.com"))
    }

    @Test
    fun isNullEmail() {
        assertFalse(UtilityFunctions.isValidEmail(null))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(UtilityFunctions.isValidEmail(""))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(UtilityFunctions.isValidEmail("name@email....com"))
    }

    @Test
    fun passwordValidator_InvalidPassword() {
        assertFalse("1234564".isValidPassword())
    }

    @Test
    fun passwordValidator_validPassword() {
        assertTrue("12345678".isValidPassword())
    }

    @Test
    fun anagramNAnother() {
        val s1 = "aawerty"
        val s2 = "wertyaa"
        var asciiCount1 = 0
        var asciiCount2 = 0
        s1.forEachIndexed { index, c ->
            val c2 = s2[index]
            asciiCount1 += c.toByte().toInt()
            asciiCount2 += c2.toByte().toInt()
        }

        assertEquals(true, asciiCount1 == asciiCount2)
    }
    
}
