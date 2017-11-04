package com.github.josh_taylr.pokedex.data;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.github.josh_taylr.pokedex.domain.LoadAllPokemonUsecase;
import com.github.josh_taylr.pokedex.model.Pokemon;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

public class ListSyncService extends IntentService {

    @Inject
    LoadAllPokemonUsecase loadAllPokemonUsecase;

    public static Intent getStartIntent(Context context) {
         return new Intent(context, ListSyncService.class);
    }

    public ListSyncService() {
        super("list-sync-service");
    }

    @Override
    public void onCreate() {
        AndroidInjection.inject(this);
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Timber.i("Sync Pokemon list...");

        // TODO the network is unavailable. How do we show this in th UI?

        loadAllPokemonUsecase.execute()
                .subscribe(new Consumer<Pokemon>() {
                    @Override
                    public void accept(Pokemon pokemon) throws Exception {
                        // TODO load Pokémon into database
                        Timber.d("Pokemon: id -> %d, name -> %s", pokemon.getId(), pokemon.getName());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Timber.e(throwable, "Sync list error");
                    }
                });
    }
}
