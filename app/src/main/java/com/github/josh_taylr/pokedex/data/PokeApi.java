package com.github.josh_taylr.pokedex.data;

import com.github.josh_taylr.pokedex.model.NamedAPIResourceList;
import com.github.josh_taylr.pokedex.model.Pokemon;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokeApi {
    @GET("pokemon")
    Observable<NamedAPIResourceList> getPokemon(@Query("limit") int limit, @Query("offset") int offset);

    @GET("pokemon/{name}")
    Observable<Pokemon> getPokemon(@Path("name") String name);
}
