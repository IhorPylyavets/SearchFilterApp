package com.searchfilterapp.model;

import com.yalantis.filter.model.FilterModel;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Ihor Pylyavets on 4/19/18.
 * ihor.pylyavets@gmail.com
 */

public class Genre implements FilterModel {
    private String text;
    private int color;

    public Genre(String text, int color) {
        this.text = text;
        this.color = color;
    }

    @NotNull
    @Override
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genre)) return false;

        Genre genre = (Genre) o;

        if (getColor() != genre.getColor()) return false;
        return getText().equals(genre.getText());
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + color;
        return result;
    }
}
