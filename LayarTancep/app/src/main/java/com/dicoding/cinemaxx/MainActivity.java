package com.dicoding.cinemaxx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.os.Looper.prepare;

public class MainActivity extends AppCompatActivity {
    private String[] filmName;
    private String[] filmDesc;
    private String[] filmGenre;
    private String[] filmArtist;
    private TypedArray imgFilm;
    private  FilmAdapter adapter;
    private ArrayList<Film> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FilmAdapter(this);

        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, films.get(i).getName(), Toast.LENGTH_SHORT).show();

                Intent detailFilm = new Intent(MainActivity.this, DetailFilmActivity.class);
                detailFilm.putExtra(DetailFilmActivity.EXTRA_FILM, films.get(i));
                startActivity(detailFilm);
            }
        });
    }

    private void prepare(){
        filmName = getResources().getStringArray(R.array.film_title);
        filmDesc = getResources().getStringArray((R.array.film_description));
        filmGenre = getResources().getStringArray(R.array.film_genre);
        filmArtist = getResources().getStringArray(R.array.artist);
        imgFilm = getResources().obtainTypedArray(R.array.film_photo);
    }

    private void addItem(){
        films = new ArrayList<>();

        for (int i = 0; i < filmName.length; i++){
            Film film = new Film();
            film.setPhoto(imgFilm.getResourceId(i, -1));
            film.setName(filmName[i]);
            film.setDescription(filmDesc[i]);
            film.setArtist(filmArtist[i]);
            film.setGenre(filmGenre[i]);
            films.add(film);
        }

        adapter.setFilms(films);
    }


}
