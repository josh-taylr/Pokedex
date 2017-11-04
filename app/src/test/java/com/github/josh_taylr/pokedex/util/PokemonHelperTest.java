package com.github.josh_taylr.pokedex.util;

import com.github.josh_taylr.pokedex.model.NamedAPIResult;
import com.github.josh_taylr.pokedex.model.Pokemon;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Josh on 4/11/17.
 */
public class PokemonHelperTest {

    private static final int ID = 28;
    private static final String NAME = "sandslash";
    private static final String URL = "http://pokeapi.co/api/v2/pokemon/28";

    private PokemonHelper helper;

    @Before
    public void setup() {
        helper = new PokemonHelper();
    }

    @Test
    public void getPokemon() throws Exception {
        NamedAPIResult result = new NamedAPIResult();
        result.setName(NAME);
        result.setUrl(URL);

        Pokemon pokemon = helper.getPokemon(result);

        assertEquals(ID, pokemon.getId());
        assertEquals(NAME, pokemon.getName());
    }

    @Test
    public void getId() throws Exception {
        int id = helper.getId(URL);

        assertEquals(28, id);
    }
}