package com.dicoding.cinemaxx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFilmActivity extends AppCompatActivity {
    public static String EXTRA_FILM = "extra_film";


    private TextView tvTitle, tvOverview, tvGenre, tvArtist;
    private ImageView imgMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        tvTitle = findViewById(R.id.tv_film_title);
        tvOverview = findViewById(R.id.tv_sinopsis);
        imgMovie = findViewById(R.id.tv_film_poster);
        tvGenre = findViewById(R.id.tv_genre);
        tvArtist = findViewById(R.id.tv_detail_cast);

        Film film = getIntent().getParcelableExtra(EXTRA_FILM);
        String judul = film.getName();
        String deskripsi = film.getDescription();
        String genre = film.getGenre();
        String artist = film.getArtist();

        int poster = film.getPhoto();
        imgMovie.setImageResource(poster);

        tvTitle.setText(judul);
        tvOverview.setText(deskripsi);
        tvGenre.setText(genre);
        tvArtist.setText(artist);

    }
}
/*
        String title = getIntent().getStringExtra(EXTRA_TITLE);
        String overview = getIntent().getStringExtra(EXTRA_OVERVIEW);
*/