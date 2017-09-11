package com.github.josh_taylr.pokedex.ui.detail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class DetailPresenterTest {

    private DetailPresenter presenter;

    @Mock
    DetailView view;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);

        presenter = new DetailPresenter();
        presenter.attachView(view);
    }

    @Test
    public void attachView() throws Exception {
        assertEquals(this.view, presenter.view);
    }

}