package com.github.josh_taylr.pokedex.ui.detail;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokemonFormatTest {

    private PokemonFormat format;

    @Before
    public void setup()throws Exception {
        format = new PokemonFormat();
    }

    @Test
    public void formatWeight() throws Exception {
        assertEquals("6.0 kg", format.weight(60));
        assertEquals("2.5 kg", format.weight(25));
    }

    @Test
    public void formatHeight() throws Exception {
        assertEquals("50.0 m", format.height(500));
        assertEquals("0.4 m", format.height(4));
    }
}