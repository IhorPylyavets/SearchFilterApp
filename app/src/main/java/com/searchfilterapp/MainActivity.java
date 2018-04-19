package com.searchfilterapp;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.searchfilterapp.model.Genre;
import com.searchfilterapp.model.Movie;
import com.searchfilterapp.model.MovieDataGenerator;
import com.yalantis.filter.adapter.FilterAdapter;
import com.yalantis.filter.animator.FiltersListItemAnimator;
import com.yalantis.filter.listener.FilterListener;
import com.yalantis.filter.widget.Filter;
import com.yalantis.filter.widget.FilterItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FilterListener<Genre> {

    private int[] mColors;
    private String[] mTitles;

    private RecyclerView mRecyclerView;

    private List<Movie> mAllMovies;

    private Filter<Genre> mFilter;
    private MovieAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImagePipelineConfig config = ImagePipelineConfig
                .newBuilder(this)
                .setDownsampleEnabled(true)
                .build();
        Fresco.initialize(this, config);

        mColors = getResources().getIntArray(R.array.colors);
        mTitles = getResources().getStringArray(R.array.genre_titles);

        mFilter = (Filter<Genre>) findViewById(R.id.filter);
        mFilter.setAdapter(new Adapter(getGenres()));
        mFilter.setListener(this);

        mFilter.setNoSelectedItemText(getString(R.string.str_all_selected));
        mFilter.build();

        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter = new MovieAdapter(this, mAllMovies = getMovies()));
        mRecyclerView.setItemAnimator(new FiltersListItemAnimator());
    }

    private List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        MovieDataGenerator generator = new MovieDataGenerator(mColors, mTitles);
        movies.add(generator.createMovie_1());
        movies.add(generator.createMovie_2());
        movies.add(generator.createMovie_3());
        movies.add(generator.createMovie_4());
        movies.add(generator.createMovie_5());
        movies.add(generator.createMovie_6());
        movies.add(generator.createMovie_7());
        movies.add(generator.createMovie_8());

        return movies;
    }

    @Override
    public void onFiltersSelected(ArrayList<Genre> movies) {
        List<Movie> newMovies = findByGenres(movies);
        List<Movie> oldMovies = mAdapter.getMovies();
        mAdapter.setMovies(newMovies);
        calculateDiff(oldMovies, newMovies);
    }

    @Override
    public void onNothingSelected() {
        if (mRecyclerView != null) {
            mAdapter.setMovies(mAllMovies);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFilterSelected(Genre genre) {
        if (genre.getText().equals(mTitles[0])) {
            mFilter.deselectAll();
            mFilter.collapse();
        }
    }

    @Override
    public void onFilterDeselected(Genre genre) {

    }

    private List<Movie> findByGenres(List<Genre> genres) {
        List<Movie> movies = new ArrayList<>();

        for (Movie movie : mAllMovies) {
            for (Genre genre : genres) {
                if (movie.hasGenre(genre.getText()) && !movies.contains(movie)) {
                    movies.add(movie);
                }
            }
        }

        return movies;
    }

    private void calculateDiff(final List<Movie> oldList, final List<Movie> newList) {
        DiffUtil.calculateDiff(new DiffUtil.Callback() {
            @Override
            public int getOldListSize() {
                return oldList.size();
            }

            @Override
            public int getNewListSize() {
                return newList.size();
            }

            @Override
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
            }

            @Override
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
            }
        }).dispatchUpdatesTo(mAdapter);
    }

    private List<Genre> getGenres() {
        List<Genre> genres = new ArrayList<>();

        for (int i = 0; i < mTitles.length; ++i) {
            genres.add(new Genre(mTitles[i], mColors[i]));
        }

        return genres;
    }

    class Adapter extends FilterAdapter<Genre> {

        Adapter(@NotNull List<? extends Genre> items) {
            super(items);
        }

        @NotNull
        @Override
        public FilterItem createView(int position, Genre item) {
            FilterItem filterItem = new FilterItem(MainActivity.this);

            filterItem.setStrokeColor(mColors[0]);
            filterItem.setTextColor(mColors[0]);
            filterItem.setCornerRadius(14);
            filterItem.setCheckedTextColor(ContextCompat.getColor(MainActivity.this, android.R.color.white));
            filterItem.setColor(ContextCompat.getColor(MainActivity.this, android.R.color.white));
            filterItem.setCheckedColor(mColors[position]);
            filterItem.setText(item.getText());
            filterItem.deselect();

            return filterItem;
        }
    }
}
