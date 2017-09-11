package com.github.josh_taylr.pokedex.ui.detail;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.josh_taylr.pokedex.R;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Implementation of the detail view responsible to displaying a Pokemon's information.
 */

public class DetailActivity extends Activity implements DetailView {

    @Inject
    DetailPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        presenter.attachView(this);
    }

    @Override
    protected void onStop() {
        presenter.onStop();
        super.onStop();
    }
}
