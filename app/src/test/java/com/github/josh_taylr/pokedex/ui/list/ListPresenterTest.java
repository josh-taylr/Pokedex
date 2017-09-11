package com.github.josh_taylr.pokedex.ui.list;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class ListPresenterTest {

    private ListPresenter presenter;

    @Mock
    ListView view;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);

        presenter = new ListPresenter();
    }
    @Test
    public void attachView() throws Exception {
        presenter.attachView(view);

        assertEquals(this.view, presenter.view);
    }

}