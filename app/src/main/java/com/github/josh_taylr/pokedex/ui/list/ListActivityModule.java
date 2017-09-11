package com.github.josh_taylr.pokedex.ui.list;

import com.github.josh_taylr.pokedex.inject.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Provides the list activity's dependencies.
 */

@Module
public class ListActivityModule {

    @Provides
    @PerActivity
    ListPresenter listPresenter() {
        return new ListPresenter();
    }
}
