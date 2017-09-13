package com.github.josh_taylr.pokedex.ui.list;

import android.support.annotation.NonNull;

import com.github.josh_taylr.pokedex.domain.LoadPagesUsecase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ListPresenterTest {

    private ListPresenter presenter;

    @Mock
    private ListView view;

    @Mock
    private LoadPagesUsecase loadPagesUsecase;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new ListPresenter(loadPagesUsecase);
    }

    @Test
    public void loadPokemonAddsName() throws Exception {
        List<String> names = getNames();
        when(loadPagesUsecase.execute()).thenReturn(Observable.just(names));

        // presenter.attachView(ListView) invoked LoadPagesUsecase.loadPokemon()
        presenter.attachView(view);

        verify(view).addNames(names);
    }

    @Test
    public void loadPokemonHidePageLoading() throws Exception {
        List<String> names = new ArrayList<>();
        when(loadPagesUsecase.execute()).thenReturn(Observable.just(names));

        // presenter.attachView(ListView) invoked LoadPagesUsecase.loadPokemon()
        presenter.attachView(view);

        verify(view).showPageLoading(false);
    }

    @NonNull
    private List<String> getNames() {
        ArrayList<String> names = new ArrayList<>();
        names.add("bulbasaur");
        names.add("ivysaur");
        names.add("venusaur");
        names.add("charmander");
        names.add("charmeleon");
        return names;
    }

}