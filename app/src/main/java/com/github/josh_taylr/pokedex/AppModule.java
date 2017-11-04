package com.github.josh_taylr.pokedex;

import com.github.josh_taylr.pokedex.data.ListSyncService;
import com.github.josh_taylr.pokedex.data.ListSyncServiceModule;
import com.github.josh_taylr.pokedex.data.RetrofitRepository;
import com.github.josh_taylr.pokedex.inject.scope.PerActivity;
import com.github.josh_taylr.pokedex.ui.detail.DetailActivity;
import com.github.josh_taylr.pokedex.ui.detail.DetailActivityModule;
import com.github.josh_taylr.pokedex.ui.list.ListActivity;
import com.github.josh_taylr.pokedex.ui.list.ListActivityModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Provides dependencies for the application class.
 */

@Module(includes = AndroidInjectionModule.class)
abstract class AppModule {

    @Provides
    @Singleton
    static Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    static RetrofitRepository retrofitRepository(Retrofit retrofit) {
        return new RetrofitRepository(retrofit);
    }

    @PerActivity
    @ContributesAndroidInjector(modules = ListActivityModule.class)
    abstract ListActivity listActivityInjector();

    @PerActivity
    @ContributesAndroidInjector(modules = DetailActivityModule.class)
    abstract DetailActivity detailActivityInjector();

    @PerActivity
    @ContributesAndroidInjector(modules = ListSyncServiceModule.class)
    abstract ListSyncService listSyncServiceInjector();
}
