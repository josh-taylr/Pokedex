package com.github.josh_taylr.pokedex.inject.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * The lifespan of a dependency annotated with this scope is the same as the activity it is injected
 * into.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
