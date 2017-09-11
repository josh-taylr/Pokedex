package com.github.josh_taylr.pokedex.ui.list;

import com.github.josh_taylr.pokedex.ui.base.Presenter;

/**
 * Coordinates interaction between the list view and the data model.
 */

public class ListPresenter implements Presenter<ListView> {

    ListView view;

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void attachView(ListView view) {
        this.view = view;
        // TODO start loading Pokemon data
    }
}
