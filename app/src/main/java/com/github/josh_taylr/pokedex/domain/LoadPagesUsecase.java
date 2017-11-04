package com.github.josh_taylr.pokedex.domain;

import com.github.josh_taylr.pokedex.data.Repository;
import com.github.josh_taylr.pokedex.model.NamedAPIResourceList;
import com.github.josh_taylr.pokedex.util.NamedAPIResourceListMappingFunc;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Loads a page of Pokémon names.
 */

public class LoadPagesUsecase implements Usecase<List<String>> {

    private static final int PAGE_SIZE = 100;

    private Repository repository;
    private int page;

    public LoadPagesUsecase(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<List<String>> execute() {
        return repository.getPokemon(PAGE_SIZE , PAGE_SIZE * page)
                .map(new Function<NamedAPIResourceList, NamedAPIResourceList>() {
                    @Override
                    public NamedAPIResourceList apply(NamedAPIResourceList namedAPIResourceList) throws Exception {
                        page++;
                        return namedAPIResourceList;
                    }
                })
                .map(new NamedAPIResourceListMappingFunc());
    }
}
