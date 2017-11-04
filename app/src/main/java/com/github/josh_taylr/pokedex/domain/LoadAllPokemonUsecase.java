package com.github.josh_taylr.pokedex.domain;

import com.github.josh_taylr.pokedex.data.Repository;
import com.github.josh_taylr.pokedex.model.NamedAPIResourceList;
import com.github.josh_taylr.pokedex.model.NamedAPIResult;
import com.github.josh_taylr.pokedex.model.Pokemon;
import com.github.josh_taylr.pokedex.util.PokemonHelper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * Return an Observable that emits every Pokémon object.
 */

public class LoadAllPokemonUsecase implements Usecase<Pokemon> {

    private static final int PAGE_SIZE = 120;
    private Repository repository;

    @Inject
    PokemonHelper pokemonHelper;

    public LoadAllPokemonUsecase(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<Pokemon> execute() {
        return Observable.range(0, Integer.MAX_VALUE -1 )
                .concatMap(new Function<Integer, ObservableSource<NamedAPIResourceList>>() {
                    @Override
                    public ObservableSource<NamedAPIResourceList> apply(Integer page) throws Exception {
                        return repository.getPokemon(PAGE_SIZE, page * PAGE_SIZE);
                    }
                })
                .takeUntil(new Predicate<NamedAPIResourceList>() {
                    @Override
                    public boolean test(NamedAPIResourceList resourceList) throws Exception {
                        return null == resourceList.getNext();
                    }
                })
                .map(new Function<NamedAPIResourceList, List<NamedAPIResult>>() {
                    @Override
                    public List<NamedAPIResult> apply(NamedAPIResourceList resourceList) throws Exception {
                        return resourceList.getResults();
                    }
                })
                .flatMapIterable(new Function<List<NamedAPIResult>, Iterable<? extends NamedAPIResult>>() {
                    @Override
                    public Iterable<? extends NamedAPIResult> apply(List<NamedAPIResult> result) throws Exception {
                        return result;
                    }
                })
                .map(new Function<NamedAPIResult, Pokemon>() {
                    @Override
                    public Pokemon apply(NamedAPIResult result) throws Exception {
                        return pokemonHelper.getPokemon(result);
                    }
                });
    }
}
