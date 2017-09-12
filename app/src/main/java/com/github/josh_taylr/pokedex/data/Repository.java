package com.github.josh_taylr.pokedex.data;

import com.github.josh_taylr.pokedex.model.NamedAPIResourceList;

import io.reactivex.Observable;

/**
 * Abstracts implementations of the network layer from the domain.
 */

public interface Repository {

    Observable<NamedAPIResourceList> getPokemon(int limit, int offset);
}
