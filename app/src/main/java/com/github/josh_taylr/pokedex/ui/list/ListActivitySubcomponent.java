package com.github.josh_taylr.pokedex.ui.list;

import com.github.josh_taylr.pokedex.inject.scope.PerActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@PerActivity
@Subcomponent(modules = ListActivityModule.class)
public interface ListActivitySubcomponent extends AndroidInjector<ListActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ListActivity> {
    }
}
