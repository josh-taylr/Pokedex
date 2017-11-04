package com.github.josh_taylr.pokedex.util;

import com.github.josh_taylr.pokedex.model.NamedAPIResult;
import com.github.josh_taylr.pokedex.model.Pokemon;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Josh on 4/11/17.
 */

public class PokemonHelper {

    public Pokemon getPokemon(NamedAPIResult result) {
        Pokemon pokemon = new Pokemon();
        pokemon.setId(getId(result.getUrl()));
        pokemon.setName(result.getName());
        return pokemon;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    int getId(String url) {
        Pattern pattern = Pattern.compile(".*/pokemon/([0-9]+)");
        Matcher matcher = pattern.matcher(url);
        matcher.matches();
        return Integer.valueOf(matcher.group(1));
    }
}
