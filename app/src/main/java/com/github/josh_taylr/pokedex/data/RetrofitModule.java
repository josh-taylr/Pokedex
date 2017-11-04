package com.github.josh_taylr.pokedex.data;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Provide a dependency on Retrofit.
 */

@Module
public class RetrofitModule {

    @Provides
    @Singleton
    Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    RetrofitRepository retrofitRepository(Retrofit retrofit) {
        return new RetrofitRepository(retrofit);
    }
}
