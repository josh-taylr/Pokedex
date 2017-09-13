package com.github.josh_taylr.pokedex.ui.list;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.josh_taylr.pokedex.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create simple items views to display Pokémon names. An optional progress indicator can be
 * displayed a the foot of the list. Its visibility is set with setPageLoading(Boolean).
 */

class NamesAdapter extends RecyclerView.Adapter {

    private static final int VIEW_TYPE_ITEM = 0;
    private static final int VIEW_TYPE_LOADING = 1;

    private final List<String> names;

    private boolean isPageLoading;

    NamesAdapter(List<String> names) {
        this.names = names;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, @LayoutRes int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (VIEW_TYPE_ITEM == viewType) {
            View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            return new PokemonHolder(view);
        } else {
            View view = inflater.inflate(R.layout.item_loader, parent, false);
            return new ProgressHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (VIEW_TYPE_ITEM == getItemViewType(position)) {
            PokemonHolder pokemonHolder = (PokemonHolder) holder;
            String name = names.get(position);
            pokemonHolder.text.setText(name);
        }
    }

    @Override
    public int getItemCount() {
        return names.size() + (isPageLoading ? 1 : 0);
    }

    @Override
    @LayoutRes
    public int getItemViewType(int position) {
        return (position < names.size()) ? VIEW_TYPE_ITEM : VIEW_TYPE_LOADING;
    }

    void setPageLoading(boolean isPageLoading) {
        this.isPageLoading = isPageLoading;
    }

    class PokemonHolder extends RecyclerView.ViewHolder {
        @BindView(android.R.id.text1)
        TextView text;

        PokemonHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class ProgressHolder extends RecyclerView.ViewHolder {

        ProgressHolder(View itemView) {
            super(itemView);
        }
    }
}
