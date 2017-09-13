package com.github.josh_taylr.pokedex.ui.detail;

import com.github.josh_taylr.pokedex.model.Pokemon;
import com.github.josh_taylr.pokedex.ui.base.MvpView;

/**
 * Abstracts the detail view from its presenter.
 */

interface DetailView extends MvpView {

    void showPokemon(Pokemon pokemon);

    void showLoading();

    void hideLoading();
}
