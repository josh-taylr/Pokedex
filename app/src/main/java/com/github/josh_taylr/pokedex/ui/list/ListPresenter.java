package com.github.josh_taylr.pokedex.ui.list;

import com.github.josh_taylr.pokedex.domain.LoadPagesUsecase;
import com.github.josh_taylr.pokedex.ui.base.Presenter;

import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Coordinates interaction between the list view and the data model.
 */

public class ListPresenter implements Presenter<ListView> {

    private ListView view;
    private LoadPagesUsecase loadPagesUsecase;
    private Disposable disposable;

    public ListPresenter(LoadPagesUsecase loadPagesUsecase) {
        this.loadPagesUsecase = loadPagesUsecase;
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
    public void attachView(ListView view) {
        this.view = view;
        loadPokemon();
    }

    void onItemClick(String name) {
        view.showDetail(name);
    }

    void loadNextPage() {
        loadPokemon();
    }

    private void loadPokemon() {
        disposable = loadPagesUsecase.execute()
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> names) throws Exception {
                        if (names != null && !names.isEmpty()) {
                            view.addNames(names);
                        } else {
                            view.showPageLoading(false);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        // TODO update to UI to show error has occurred
                        Timber.e(throwable, "Pokemon names paging error.");
                    }
                });
    }
}
