package com.github.josh_taylr.pokedex.ui.detail;

import com.github.josh_taylr.pokedex.inject.scope.PerActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@PerActivity
@Subcomponent(modules = DetailActivityModule.class)
public interface DetailActivitySubcomponent extends AndroidInjector<DetailActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<DetailActivity> {
    }
}
