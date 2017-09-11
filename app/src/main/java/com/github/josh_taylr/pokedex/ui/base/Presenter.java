package com.github.josh_taylr.pokedex.ui.base;

/**
 * Base presenter interface. New presenters implement this interface.
 */

public interface Presenter<T extends MvpView> {

    void onCreate();

    void onStart();

    void onStop();

    void onPause();

    void attachView(T view);
}
