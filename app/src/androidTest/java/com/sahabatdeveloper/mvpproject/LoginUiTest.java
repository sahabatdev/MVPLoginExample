package com.sahabatdeveloper.mvpproject;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by Sahabat Developer on 20/12/2017.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginUiTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestResult = new ActivityTestRule<>(MainActivity.class);

//    @Before
//    public void initIntent(){
//        Intents.init();
//    }
//
//    @After
//    public void releaseIntent(){
//        Intents.release();
//    }

    @Test
    public void ifUsernameEmpty(){
        launchNewTaskActivity();
        onView(withId(R.id.et_username)).perform(typeText(""), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.et_password)).perform(typeText("sfsfsfsf"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withId(R.id.et_username)).check(matches(hasErrorText("Username Harus Diisi")));
    }

    @Test
    public void ifPasswordEmpty(){
        launchNewTaskActivity();
        onView(withId(R.id.et_username)).perform(typeText("affsff"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.et_password)).perform(typeText(""), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withId(R.id.et_password)).check(matches(hasErrorText("Password Harus Diisi")));
    }

    @Test
    public void ifLoginSuccess(){
        launchNewTaskActivity();
        onView(withId(R.id.et_username)).perform(typeText("advinity"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.et_password)).perform(typeText("advinity"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withText("Login Berhasil")).inRoot(withDecorView(not(is(mActivityTestResult.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    @Test
    public void ifLoginFailure(){
        launchNewTaskActivity();
        onView(withId(R.id.et_username)).perform(typeText("sfsggdfhh"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.et_password)).perform(typeText("sfsfsfsf"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withText("Login Gagal")).inRoot(withDecorView(not(is(mActivityTestResult.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    private void launchNewTaskActivity() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(InstrumentationRegistry.getInstrumentation()
                .getTargetContext(), MainActivity.class);

        mActivityTestResult.launchActivity(intent);
    }
}
