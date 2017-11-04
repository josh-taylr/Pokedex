package com.github.josh_taylr.pokedex.ui.list;

import com.github.josh_taylr.pokedex.data.Repository;
import com.github.josh_taylr.pokedex.domain.LoadPagesUsecase;
import com.github.josh_taylr.pokedex.inject.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Provides the list activity's dependencies.
 */

@Module
public class ListActivityModule {

    @Provides
    @PerActivity
    ListPresenter listPresenter(Repository repository) {
        return new ListPresenter(new LoadPagesUsecase(repository));
    }
}
