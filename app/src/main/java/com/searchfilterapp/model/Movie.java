package com.searchfilterapp.model;

import java.util.List;

/**
 * Created by Ihor Pylyavets on 4/19/18.
 * ihor.pylyavets@gmail.com
 */

public class Movie {
    private String title;
    private String backdropPath;
    private List<Genre> genres;
    private String overview;
    private String date;

    public String getTitle() {
        return title;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public String getOverview() {
        return overview;
    }

    public String getDate() {
        return date;
    }

    private Movie(Builder builder) {
        title = builder.title;
        backdropPath = builder.backdropPath;
        genres = builder.genres;
        overview = builder.overview;
        date = builder.date;
    }

    public boolean hasGenre(String string) {
        for (Genre genre : genres) {
            if (genre.getText().equals(string)) {
                return true;
            }
        }

        return false;
    }

    public static final class Builder {
        private String title;
        private String backdropPath;
        private List<Genre> genres;
        private String overview;
        private String date;

        public Builder() {
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder backdropPath(String val) {
            backdropPath = val;
            return this;
        }

        public Builder genres(List<Genre> val) {
            genres = val;
            return this;
        }

        public Builder overview(String val) {
            overview = val;
            return this;
        }

        public Builder date(String val) {
            date = val;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }
}
