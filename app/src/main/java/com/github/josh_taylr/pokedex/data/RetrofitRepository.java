package com.github.josh_taylr.pokedex.data;

import com.github.josh_taylr.pokedex.model.NamedAPIResourceList;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Implementation of the repository pattern using Retrofit.
 */

public class RetrofitRepository implements Repository {

    private final PokeApi apiService;

    public RetrofitRepository(Retrofit retrofit) {
        apiService = retrofit.create(PokeApi.class);
    }

    @Override
    public Observable<NamedAPIResourceList> getPokemon(int limit, int offset) {
        return apiService.getPokemon(limit, offset);
    }
}
