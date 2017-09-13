package com.github.josh_taylr.pokedex.ui.detail;

import android.support.test.rule.ActivityTestRule;

import com.github.josh_taylr.pokedex.R;
import com.github.josh_taylr.pokedex.model.Pokemon;
import com.github.josh_taylr.pokedex.model.PokemonSprites;

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
    public void testShowPokemon() {
        DetailActivity activity = activityTestRule.getActivity();

        activity.showPokemon(getArcanine());

        onView(withId(R.id.weight))
                .check(matches(withText("155.0 kg")));
        onView(withId(R.id.height))
                .check(matches(withText("1.9 m")));
    }

    public Pokemon getArcanine() {
        Pokemon arcanine = new Pokemon();
        arcanine.setName("Arcanine");
        arcanine.setWeight(1550);
        arcanine.setHeight(19);
        PokemonSprites sprites = new PokemonSprites();
        sprites.setFront_default("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/59.png");
        arcanine.setSprites(sprites);
        return arcanine;
    }
}