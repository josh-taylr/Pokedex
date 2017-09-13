package com.github.josh_taylr.pokedex.ui.detail;

import java.util.Locale;

/**
 * Format {@link com.github.josh_taylr.pokedex.model.Pokemon} attributes for display in the view.
 */

class PokemonFormat {
    public String weight(int weight) {
        return String.format(Locale.getDefault(),"%1.1f kg", (float) weight / 10);
    }

    public String height(int height) {
        return String.format(Locale.getDefault(), "%1.1f m", (float) height / 10);
    }
}
