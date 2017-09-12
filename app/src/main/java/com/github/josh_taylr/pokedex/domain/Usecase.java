package com.github.josh_taylr.pokedex.domain;

import io.reactivex.Observable;

/**
 * Every new usecase implements this interface.
 */

public interface Usecase<T> {
    Observable<T> execute();
}
