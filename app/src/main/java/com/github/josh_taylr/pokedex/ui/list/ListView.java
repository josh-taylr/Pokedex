package com.github.josh_taylr.pokedex.ui.list;

import com.github.josh_taylr.pokedex.ui.base.MvpView;

import java.util.List;

/**
 * Abstracts the list view from it's presenter.
 */

interface ListView extends MvpView {

    void addNames(List<String> names);

    void showPageLoading(boolean visible);

    void showDetail(String name);
}
