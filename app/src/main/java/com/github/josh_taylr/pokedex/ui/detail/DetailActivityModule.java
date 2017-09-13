package com.github.josh_taylr.pokedex.ui.detail;

import com.github.josh_taylr.pokedex.data.RetrofitRepository;
import com.github.josh_taylr.pokedex.domain.LoadPokemonUsecase;
import com.github.josh_taylr.pokedex.inject.scope.PerActivity;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Provides the detail activity's dependencies.
 */

@Module
public class DetailActivityModule {

    @Provides
    @PerActivity
    DetailPresenter detailPresenterr(Retrofit retrofit) {
        return new DetailPresenter(new LoadPokemonUsecase(new RetrofitRepository(retrofit)));
    }

    @Provides
    @PerActivity
    PokemonFormat pokemonFormat() {
        return new PokemonFormat();
    }
}
