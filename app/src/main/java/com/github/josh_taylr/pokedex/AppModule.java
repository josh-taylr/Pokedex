package com.github.josh_taylr.pokedex;

import android.app.Activity;

import com.github.josh_taylr.pokedex.ui.detail.DetailActivitySubcomponent;
import com.github.josh_taylr.pokedex.ui.list.ListActivity;
import com.github.josh_taylr.pokedex.ui.list.ListActivitySubcomponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Provides dependencies for the application class.
 */

@Module(includes = AndroidInjectionModule.class,
        subcomponents = { ListActivitySubcomponent.class, DetailActivitySubcomponent.class })
abstract class AppModule {

    @Binds
    @IntoMap
    @ActivityKey(ListActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    mainActivityInjectorFactory(ListActivitySubcomponent.Builder builder);
}