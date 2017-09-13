package com.github.josh_taylr.pokedex.ui.list;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.josh_taylr.pokedex.R;
import com.github.josh_taylr.pokedex.ui.EndlessRecyclerViewScrollListener;
import com.github.josh_taylr.pokedex.ui.detail.DetailActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Implementation of the list view responsible to displaying pokemon names.
 */

public class ListActivity extends Activity implements ListView, HasActivityInjector {

    private final List<String> names = new ArrayList<>();

    private NamesAdapter adapter;

    @Inject
    ListPresenter presenter;

    @Inject
    DispatchingAndroidInjector<Activity> fragmentInjector;

    @BindView(R.id.list)
    RecyclerView list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        // configure the recycler view and its adapter
        adapter = new NamesAdapter(this.names);
        adapter.setPageLoading(true);
        adapter.setOnItemClickListener(new NamesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String name = ListActivity.this.names.get(position);
                presenter.onItemClick(name);
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        list.setAdapter(adapter);
        list.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                presenter.loadNextPage();
            }
        });

        presenter.attachView(this);
    }

    @Override
    protected void onStop() {
        presenter.onStop();
        super.onStop();
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return fragmentInjector;
    }

    @Override
    public void addNames(List<String> names) {
        int size = this.names.size();
        this.names.addAll(names);
        adapter.notifyItemRangeInserted(size, names.size());
    }

    @Override
    public void showPageLoading(boolean visible) {
        adapter.setPageLoading(visible);

        // the progress indicator is no longer one of the adapter's items
        adapter.notifyItemRemoved(this.names.size());
    }

    @Override
    public void showDetail(String name) {
        DetailActivity.startActivity(ListActivity.this, name);
    }
}
