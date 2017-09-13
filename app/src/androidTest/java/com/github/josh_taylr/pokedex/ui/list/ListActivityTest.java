package com.github.josh_taylr.pokedex.ui.list;

import android.support.annotation.NonNull;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListActivityTest {

    @Rule
    public ActivityTestRule<ListActivity> activityTestRule = new ActivityTestRule<>(ListActivity.class);

    @Test
    public void testListLabel() {
        activityTestRule.getActivity().addNames(getNames());

        // TODO will need to inject a mock presenter into the view
//        onView(withId(R.id.list))
//                .perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));
    }

    @NonNull
    private List<String> getNames() {
        ArrayList<String> names = new ArrayList<>();
        names.add("bulbasaur");
        names.add("ivysaur");
        names.add("venusaur");
        names.add("charmander");
        names.add("charmeleon");
        return names;
    }
}