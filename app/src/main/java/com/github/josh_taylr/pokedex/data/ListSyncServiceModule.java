package com.github.josh_taylr.pokedex.data;

import com.github.josh_taylr.pokedex.domain.LoadAllPokemonUsecase;
import com.github.josh_taylr.pokedex.inject.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Josh on 23/10/17.
 */

@Module
public class ListSyncServiceModule {

    @Provides
    @PerActivity
    LoadAllPokemonUsecase loadAllPokemonUsecase(Repository repository) {
        return new LoadAllPokemonUsecase(repository);
    }
}
