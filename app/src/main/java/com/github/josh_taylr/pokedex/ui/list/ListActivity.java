package com.github.josh_taylr.pokedex.ui.list;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.josh_taylr.pokedex.R;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Implementation of the list view responsible to displaying pokemon names.
 */

public class ListActivity extends Activity implements ListView, HasActivityInjector {

    @Inject
    ListPresenter presenter;

    @Inject
    DispatchingAndroidInjector<Activity> fragmentInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        presenter.attachView(this);
    }

    @Override
    protected void onStop() {
        presenter.onStop();
        super.onStop();
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return fragmentInjector;
    }
}