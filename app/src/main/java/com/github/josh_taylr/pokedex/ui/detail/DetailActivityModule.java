package com.github.josh_taylr.pokedex.ui.detail;

import com.github.josh_taylr.pokedex.inject.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Provides the detail activity's dependencies.
 */

@Module
public class DetailActivityModule {

    @Provides
    @PerActivity
    DetailPresenter detailPresenter() {
        return new DetailPresenter();
    }
}
