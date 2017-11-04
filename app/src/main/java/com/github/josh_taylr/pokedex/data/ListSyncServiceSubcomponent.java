package com.github.josh_taylr.pokedex.data;

import com.github.josh_taylr.pokedex.inject.scope.PerActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@PerActivity
@Subcomponent(modules = ListSyncServiceModule.class)
public interface ListSyncServiceSubcomponent extends AndroidInjector<ListSyncService> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ListSyncService> {
    }
}
