package com.github.josh_taylr.pokedex.data;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import timber.log.Timber;

public class ListSyncService extends IntentService {

    public static Intent getStartIntent(Context context) {
         return new Intent(context, ListSyncService.class);
    }

    public ListSyncService() {
        super("list-sync-service");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Timber.i("Sync Pokemon list...");

        // TODO the network is unavailable. How do we show this in th UI?

        // TODO load all Pokémon into database through a domain object.
    }
}
