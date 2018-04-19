package com.searchfilterapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ihor Pylyavets on 4/19/18.
 * ihor.pylyavets@gmail.com
 */

public class MovieDataGenerator {

    private int[] mColors;
    private String[] mTitles;

    public MovieDataGenerator(int[] mColors, String[] mTitles) {
        this.mColors = mColors;
        this.mTitles = mTitles;
    }

    public Movie createMovie_1() {
        Movie.Builder builder = new  Movie.Builder();
        builder.title("Black Panther");
        builder.backdropPath("https://image.tmdb.org/t/p/w500/b6ZJZHUdMEFECvGiDpJjlfUWela.jpg");
        List<Genre> genres = new ArrayList<>();
        genres.add(new Genre(mTitles[1], mColors[1]));
        genres.add(new Genre(mTitles[2], mColors[2]));
        builder.genres(genres);
        builder.overview("King T'Challa returns home from America to the reclusive, technologically advanced African nation of Wakanda to serve as his country's new leader. However, T'Challa soon finds that he is challenged for the throne by factions within his own country as well as without. Using powers reserved to Wakandan kings, T'Challa assumes the Black Panther mantel to join with girlfriend Nakia, the queen-mother, his princess-kid sister, members of the Dora Milaje (the Wakandan \"special forces\"), and an American secret agent, to prevent Wakanda from being dragged into a world war.");
        builder.date("2018-02-13");

        return builder.build();
    }

    public Movie createMovie_2() {
        Movie.Builder builder = new  Movie.Builder();
        builder.title("Star Wars: The Last Jedi");
        builder.backdropPath("https://image.tmdb.org/t/p/w500/oVdLj5JVqNWGY0LEhBfHUuMrvWJ.jpg");
        List<Genre> genres = new ArrayList<>();
        genres.add(new Genre(mTitles[2], mColors[2]));
        genres.add(new Genre(mTitles[4], mColors[4]));
        builder.genres(genres);
        builder.overview("Rey develops her newly discovered abilities with the guidance of Luke Skywalker, who is unsettled by the strength of her powers. Meanwhile, the Resistance prepares to do battle with the First Order.");
        builder.date("2017-12-13");

        return builder.build();
    }

    public Movie createMovie_3() {
        Movie.Builder builder = new  Movie.Builder();
        builder.title("Ready Player One");
        builder.backdropPath("https://image.tmdb.org/t/p/w500/q7fXcrDPJcf6t3rzutaNwTzuKP1.jpg");
        List<Genre> genres = new ArrayList<>();
        genres.add(new Genre(mTitles[4], mColors[4]));
        genres.add(new Genre(mTitles[1], mColors[1]));
        builder.genres(genres);
        builder.overview("When the creator of a popular video game system dies, a virtual contest is created to compete for his fortune.");
        builder.date("2018-03-28");

        return builder.build();
    }

    public Movie createMovie_4() {
        Movie.Builder builder = new  Movie.Builder();
        builder.title("The Maze Runner");
        builder.backdropPath("https://image.tmdb.org/t/p/w500/lkOZcsXcOLZYeJ2YxJd3vSldvU4.jpg");
        List<Genre> genres = new ArrayList<>();
        genres.add(new Genre(mTitles[5], mColors[5]));
        genres.add(new Genre(mTitles[6], mColors[6]));
        builder.genres(genres);
        builder.overview("Set in a post-apocalyptic world, young Thomas is deposited in a community of boys after his memory is erased, soon learning they're all trapped in a maze that will require him to join forces with fellow “runners” for a shot at escape.");
        builder.date("2014-09-10");

        return builder.build();
    }

    public Movie createMovie_5() {
        Movie.Builder builder = new  Movie.Builder();
        builder.title("Beauty and the Beast");
        builder.backdropPath("https://image.tmdb.org/t/p/w500/6aUWe0GSl69wMTSWWexsorMIvwU.jpg");
        List<Genre> genres = new ArrayList<>();
        genres.add(new Genre(mTitles[7], mColors[7]));
        genres.add(new Genre(mTitles[8], mColors[8]));
        builder.genres(genres);
        builder.overview("A live-action adaptation of Disney's version of the classic tale of a cursed prince and a beautiful young woman who helps him break the spell.");
        builder.date("2017-03-16");

        return builder.build();
    }

    public Movie createMovie_6() {
        Movie.Builder builder = new  Movie.Builder();
        builder.title("Thor: Ragnarok");
        builder.backdropPath("https://image.tmdb.org/t/p/w500/kaIfm5ryEOwYg8mLbq8HkPuM1Fo.jpg");
        List<Genre> genres = new ArrayList<>();
        genres.add(new Genre(mTitles[2], mColors[2]));
        genres.add(new Genre(mTitles[3], mColors[3]));
        builder.genres(genres);
        builder.overview("Thor is imprisoned on the other side of the universe and finds himself in a race against time to get back to Asgard to stop Ragnarok, the prophecy of destruction to his homeworld and the end of Asgardian civilization, at the hands of an all-powerful new threat, the ruthless Hela.");
        builder.date("2017-10-25");

        return builder.build();
    }

    public Movie createMovie_7() {
        Movie.Builder builder = new  Movie.Builder();
        builder.title("The Avengers");
        builder.backdropPath("https://image.tmdb.org/t/p/w500/hbn46fQaRmlpBuUrEiFqv0GDL6Y.jpg");
        List<Genre> genres = new ArrayList<>();
        genres.add(new Genre(mTitles[1], mColors[1]));
        genres.add(new Genre(mTitles[4], mColors[4]));
        builder.genres(genres);
        builder.overview("When an unexpected enemy emerges and threatens global safety and security, Nick Fury, director of the international peacekeeping agency known as S.H.I.E.L.D., finds himself in need of a team to pull the world back from the brink of disaster. Spanning the globe, a daring recruitment effort begins!");
        builder.date("2012-04-25");

        return builder.build();
    }

    public Movie createMovie_8() {
        Movie.Builder builder = new  Movie.Builder();
        builder.title("Avengers: Infinity War");
        builder.backdropPath("https://image.tmdb.org/t/p/w500/xmgAsda5sPNpx5ghJibJ80S7Pfx.jpg");
        List<Genre> genres = new ArrayList<>();
        genres.add(new Genre(mTitles[3], mColors[3]));
        genres.add(new Genre(mTitles[1], mColors[1]));
        builder.genres(genres);
        builder.overview("As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.");
        builder.date("2018-04-25");

        return builder.build();
    }
}
