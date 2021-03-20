package com.dicoding.cinemaxx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Film> films;

    void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    FilmAdapter(Context context){
        this.context = context;
        films = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int i) {
        return films.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_film, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Film film = (Film) getItem(i);
        viewHolder.bind(film);
        //ga ada view jadinya fc
        return view;
    }

    private class ViewHolder {
        private TextView filmName, filmDescription;
        private ImageView imgFilm;

        ViewHolder(View view){
            filmName = view.findViewById(R.id.film_name);
            filmDescription = view.findViewById(R.id.film_descripstion);
            imgFilm = view.findViewById(R.id.img_film);
        }

        void bind(Film film){
            filmName.setText(film.getName());
            filmDescription.setText(film.getDescription());
            imgFilm.setImageResource(film.getPhoto());
        }
    }
}
