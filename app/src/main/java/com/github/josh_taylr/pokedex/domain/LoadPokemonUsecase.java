package com.github.josh_taylr.pokedex.domain;

import com.github.josh_taylr.pokedex.data.Repository;
import com.github.josh_taylr.pokedex.model.Pokemon;

import io.reactivex.Observable;

/**
 * Fetch the required attributes of a Pokemon from the PokéApi based on the given name.
 */

public class LoadPokemonUsecase implements Usecase<Pokemon> {

    private Repository repository;
    private String name;

    public LoadPokemonUsecase(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<Pokemon> execute() {
        return repository.getPokemon(name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
