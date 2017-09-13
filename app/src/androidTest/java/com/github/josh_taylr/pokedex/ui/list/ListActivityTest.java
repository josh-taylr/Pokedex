package com.github.josh_taylr.pokedex.ui.list;

import android.support.test.rule.ActivityTestRule;

import com.github.josh_taylr.pokedex.R;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class ListActivityTest {

    @Rule
    public ActivityTestRule<ListActivity> activityTestRule = new ActivityTestRule<>(ListActivity.class);

    @Test
    public void testListLabel() {
        onView(withId(R.id.list)).check(matches(isDisplayed()));
    }
}