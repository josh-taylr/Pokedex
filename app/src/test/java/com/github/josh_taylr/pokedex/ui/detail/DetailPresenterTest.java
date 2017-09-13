package com.github.josh_taylr.pokedex.ui.detail;

import com.github.josh_taylr.pokedex.domain.LoadPokemonUsecase;
import com.github.josh_taylr.pokedex.model.Pokemon;
import com.github.josh_taylr.pokedex.model.PokemonSprites;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class DetailPresenterTest {

    private DetailPresenter presenter;

    @Mock
    private DetailView view;

    @Mock
    private LoadPokemonUsecase loadPokemonUsecase;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);

        presenter = new DetailPresenter(loadPokemonUsecase);
        when(loadPokemonUsecase.execute()).thenReturn(Observable.just(getArcanine()));
        presenter.attachView(view);
    }

    @Test
    public void attachView() throws Exception {
        assertEquals(this.view, presenter.view);
    }

    private Pokemon getArcanine() {
        Pokemon arcanine = new Pokemon();
        arcanine.setName("Arcanine");
        arcanine.setWeight(1550);
        arcanine.setHeight(19);
        PokemonSprites sprites = new PokemonSprites();
        sprites.setFront_default("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/59.png");
        arcanine.setSprites(sprites);
        return arcanine;
    }
}