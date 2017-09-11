package com.github.josh_taylr.pokedex.ui.detail;

import android.support.test.rule.ActivityTestRule;

import com.github.josh_taylr.pokedex.R;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class DetailActivityTest {
    @Rule
    public ActivityTestRule<DetailActivity> activityTestRule = new ActivityTestRule<>(DetailActivity.class);

    @Test
    public void testDetailLabel() {
        onView(withId(R.id.textView)).check(matches(withText("Detail view")));
    }
}