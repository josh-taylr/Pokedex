package com.github.josh_taylr.pokedex.domain;

import com.github.josh_taylr.pokedex.data.Repository;
import com.github.josh_taylr.pokedex.model.Pokemon;

import io.reactivex.Observable;

/**
 * Return an Observable that emits every Pokémon object.
 */

public class LoadAllPokemonUsecase implements Usecase<Pokemon> {

    private Repository repository;

    public LoadAllPokemonUsecase(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<Pokemon> execute() {
        return null;
    }
}
