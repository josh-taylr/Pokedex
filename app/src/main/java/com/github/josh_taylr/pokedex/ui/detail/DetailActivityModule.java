package com.github.josh_taylr.pokedex.ui.detail;

import com.github.josh_taylr.pokedex.inject.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Provides the detail activity's dependencies.
 */

@Module
class DetailActivityModule {

    @Provides
    @PerActivity
    DetailPresenter detailPresenter() {
        return new DetailPresenter();
    }
}
