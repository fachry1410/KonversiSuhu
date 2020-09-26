package com.example.myapplication;

import android.icu.text.CaseMap;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Testing {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void Test(){
        onView(withId(R.id.input)).perform(typeText("40"));
        onView(withId(R.id.spinner)).perform(click());
        onData(anything()).atPosition(0).perform(click());
        onView(withId(R.id.hitung)).perform(click());
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString("Celcius ---> Reamur"))));
        onView(withId(R.id.input)).check(matches(withText("40")));
    }


}
