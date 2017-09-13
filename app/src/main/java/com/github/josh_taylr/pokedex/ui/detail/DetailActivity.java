package com.github.josh_taylr.pokedex.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.josh_taylr.pokedex.R;
import com.github.josh_taylr.pokedex.model.Pokemon;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

/**
 * Implementation of the detail view responsible to displaying a Pokemon's information.
 */

public class DetailActivity extends AppCompatActivity implements DetailView {

    public static final String EXTRA_NAME = "EXTRA_NAME";

    @Inject
    DetailPresenter presenter;

    @Inject
    PokemonFormat format;

    @BindView(R.id.image)
    ImageView image;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    @BindView(R.id.weight)
    TextView weight;

    @BindView(R.id.height)
    TextView height;

    public static void startActivity(Context context, String name) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        String name = getIntent().getStringExtra(EXTRA_NAME);

        if (null != getSupportActionBar()) {
            getSupportActionBar().setTitle(capitalize(name));
        }

        initialisePresenter(name);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // TODO save view state before configuration change
    }

    @Override
    protected void onStop() {
        presenter.onStop();
        super.onStop();
    }

    @Override
    public void showPokemon(final Pokemon pokemon) {
        Handler handler = new Handler(getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Glide.with(DetailActivity.this)
                        .load(pokemon.getSprites().getFront_default())
                        .into(image);

                weight.setText(format.weight(pokemon.getWeight()));
                height.setText(format.height(pokemon.getHeight()));
            }
        };
        handler.post(runnable);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    /**
     * Encapsulate how we configure the presenter in a method as setName needs to be called before
     * attachView.
     * @param name The name of a Pokemon
     */
    private void initialisePresenter(String name) {
        presenter.setName(name);
        presenter.attachView(this);
    }

    private String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }
}
