package com.malik.covid;

import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;

import com.malik.covid.view.activities.SplashActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class AgniteLoginFragmentTest {

    @Rule
    public ActivityTestRule<SplashActivity> mFragmentTestRule = new ActivityTestRule<>(SplashActivity.class);

    @Before
    public void fragmentSetup() {
        // Launch the activity to make the fragment visible
        mFragmentTestRule.launchActivity(null);
    }

    @Test
    public void fragment_can_be_instantiated() {
        Espresso.onView(withId(R.id.bt_confirm)).check(matches(isDisplayed()));
    }

    @Test
    public void validateEmail() {
        authentication("test", "1289232332");
    }

    @Test
    public void validatePassword() {
        authentication("naqi@gmail.com", "1289");
    }

    @Test
    public void authenticateInvalidUser() {
        authentication("malik@gmail.com", "12345ddd1");
    }

    @Test
    public void authenticateValidUser() {
        authentication("naqi@gmail.com", "123456789");
    }

    private void authentication(String email, String password) {
        Espresso.onView(withId(R.id.etxt_email))
                .perform(typeText(email), closeSoftKeyboard()); //type email and hide keyboard

        Espresso.onView(withId(R.id.etxt_password))
                .perform(typeText(password), closeSoftKeyboard());//type password and hide keyboard

        Espresso.onView(withId(R.id.bt_confirm)).perform(click()); //perform click
    }
}
