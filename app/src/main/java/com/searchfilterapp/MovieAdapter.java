package com.searchfilterapp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.searchfilterapp.model.Genre;
import com.searchfilterapp.model.Movie;

import java.util.List;

/**
 * Created by Ihor Pylyavets on 4/19/18.
 * ihor.pylyavets@gmail.com
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<Movie> mMovies;
    private Context mContext;

    public MovieAdapter(Context context, List<Movie> movies) {
        mContext = context;
        mMovies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false));
    }

    public List<Movie> getMovies() {
        return mMovies;
    }

    public void setMovies(List<Movie> movies) {
        this.mMovies = movies;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = mMovies.get(position);

        holder.image.setImageURI(movie.getBackdropPath());
        holder.textTitle.setText(movie.getTitle());
        holder.textDate.setText(movie.getDate());
        holder.textOverview.setText(movie.getOverview());
        Genre firstGenre = movie.getGenres().get(0);
        holder.firstFilter.setText(firstGenre.getText());
        Genre secondGenre = movie.getGenres().get(1);
        holder.secondFilter.setText(secondGenre.getText());

        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(1000);
        drawable.setColor(firstGenre.getColor());
        holder.firstFilter.setBackgroundDrawable(drawable);
        GradientDrawable drawable1 = new GradientDrawable();
        drawable1.setCornerRadius(1000);
        drawable1.setColor(secondGenre.getColor());
        holder.secondFilter.setBackgroundDrawable(drawable1);
    }

    private int getColor(int color) {
        return ContextCompat.getColor(mContext, color);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textTitle;
        TextView textDate;
        TextView textOverview;
        TextView firstFilter;
        TextView secondFilter;
        SimpleDraweeView image;

        public ViewHolder(View itemView) {
            super(itemView);

            textTitle = (TextView) itemView.findViewById(R.id.text_title);
            textDate = (TextView) itemView.findViewById(R.id.text_date);
            textOverview = (TextView) itemView.findViewById(R.id.text_overview);
            firstFilter = (TextView) itemView.findViewById(R.id.filter_first);
            secondFilter = (TextView) itemView.findViewById(R.id.filter_second);
            image = (SimpleDraweeView) itemView.findViewById(R.id.image);
        }
    }
}
