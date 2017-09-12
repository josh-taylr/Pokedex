package com.github.josh_taylr.pokedex.data;

import com.github.josh_taylr.pokedex.model.NamedAPIResourceList;
import com.github.josh_taylr.pokedex.model.NamedAPIResult;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

/**
 * Unwraps a {@link NamedAPIResourceList} to return the list of Pokémon names.
 */

public class NamedAPIResourceListMappingFunc implements Function<NamedAPIResourceList, List<String>> {
    @Override
    public List<String> apply(NamedAPIResourceList namedAPIResourceList) throws Exception {
        List<String> names = new ArrayList<>();
        for (NamedAPIResult result : namedAPIResourceList.getResults()) {
            names.add(result.getName());
        }
        return names;
    }
}
