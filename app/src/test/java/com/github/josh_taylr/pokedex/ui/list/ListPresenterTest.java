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

import static org.junit.Assert.assertEquals;
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
        when(loadPagesUsecase.execute()).thenReturn(Observable.just(getNames()));
        presenter = new ListPresenter(loadPagesUsecase);
    }

    @Test
    public void attachView() throws Exception {
        presenter.attachView(view);

        assertEquals(this.view, presenter.view);
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