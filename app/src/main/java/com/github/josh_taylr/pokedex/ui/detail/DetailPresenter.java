package com.github.josh_taylr.pokedex.ui.detail;

import com.github.josh_taylr.pokedex.domain.LoadPokemonUsecase;
import com.github.josh_taylr.pokedex.model.Pokemon;
import com.github.josh_taylr.pokedex.ui.base.Presenter;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Coordinates interaction between the detail view and the data model.
 */

public class DetailPresenter implements Presenter<DetailView> {

    private DetailView view;
    private LoadPokemonUsecase loadPokemonUsecase;
    private Disposable disposable;
    private String name;

    DetailPresenter(LoadPokemonUsecase loadPokemonUsecase) {
        this.loadPokemonUsecase = loadPokemonUsecase;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @Override
    public void onPause() {

    }

    @Override
    public void attachView(DetailView view) {
        this.view = view;
        loadPokemon();
    }

    private void loadPokemon() {
        view.showLoading();
        disposable = loadPokemonUsecase.execute()
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Pokemon>() {
                    @Override
                    public void accept(Pokemon pokemon) throws Exception {
                        if (pokemon != null) {
                            view.hideLoading();
                            view.showPokemon(pokemon);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        // TODO update to UI to show error has occurred
                        Timber.e(throwable, "Error loading Pokemon -> %s.", name);
                    }
                });
    }

    public void setName(String name) {
        this.name = name;
        loadPokemonUsecase.setName(name);
    }
}
