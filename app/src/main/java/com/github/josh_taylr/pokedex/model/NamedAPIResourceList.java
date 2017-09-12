package com.github.josh_taylr.pokedex.model;

import java.util.List;

/**
 * Wrapper for a paginated list of {@link NamedAPIResult} objects.
 */

public class NamedAPIResourceList {
    private Integer count;
    private String previous;
    private List<NamedAPIResult> results = null;
    private String next;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<NamedAPIResult> getResults() {
        return results;
    }

    public void setResults(List<NamedAPIResult> results) {
        this.results = results;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
