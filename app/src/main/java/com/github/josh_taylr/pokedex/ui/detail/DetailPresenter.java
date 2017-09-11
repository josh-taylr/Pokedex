package com.github.josh_taylr.pokedex.ui.detail;

import com.github.josh_taylr.pokedex.ui.base.Presenter;

/**
 * Coordinates interaction between the detail view and the data model.
 */

public class DetailPresenter implements Presenter<DetailView> {

    private DetailView view;

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
    public void attachView(DetailView view) {
        this.view = view;
        // TODO load the pokemon's data
    }
}
