package com.github.josh_taylr.pokedex;

import android.app.Activity;
import android.app.Service;

import com.github.josh_taylr.pokedex.data.ListSyncService;
import com.github.josh_taylr.pokedex.data.ListSyncServiceSubcomponent;
import com.github.josh_taylr.pokedex.data.RetrofitModule;
import com.github.josh_taylr.pokedex.ui.detail.DetailActivity;
import com.github.josh_taylr.pokedex.ui.detail.DetailActivitySubcomponent;
import com.github.josh_taylr.pokedex.ui.list.ListActivity;
import com.github.josh_taylr.pokedex.ui.list.ListActivitySubcomponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.ServiceKey;
import dagger.multibindings.IntoMap;

/**
 * Provides dependencies for the application class.
 */

@Module(includes = {AndroidInjectionModule.class, RetrofitModule.class},
        subcomponents = { ListActivitySubcomponent.class, DetailActivitySubcomponent.class, ListSyncServiceSubcomponent.class })
abstract class AppModule {

    @Binds
    @IntoMap
    @ActivityKey(ListActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    listActivityInjectorFactory(ListActivitySubcomponent.Builder builder);

    @Binds
    @IntoMap
    @ActivityKey(DetailActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    detailActivityInjectorFactory(DetailActivitySubcomponent.Builder builder);

    @Binds
    @IntoMap
    @ServiceKey(ListSyncService.class)
    abstract AndroidInjector.Factory<? extends Service>
    listSyncServiceInjectorFactory(ListSyncServiceSubcomponent.Builder builder);
}
