package com.jnj.cinepop.DBAcess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jnj.cinepop.models.LoginModel;
import com.jnj.cinepop.models.MovieModel;

import java.util.ArrayList;

public class DBMovieManager {

    public boolean insertMovie(Context context, String titulo, String sinopsis, String edad, String rutaImg) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.getColTitulo(), titulo);
        contentValues.put(dbHelper.getColSinopsis(), sinopsis);
        contentValues.put(dbHelper.getColEdad(), edad);
        contentValues.put(dbHelper.getColRutaImg(), rutaImg);
        long result = db.insert(dbHelper.getDatabaseTableMovies(), null, contentValues);
        return (result != -1);
    }

    public void loadMovies(Context context){
        insertMovie(context, "Avengers Endgame", "Sinopsis pelicula", "ATP", "avengers_endgame");
        insertMovie(context, "Angry Birds 2", "Sinopsis pelicula", "ATP", "angry_birds_2");
        insertMovie(context, "Capitana Marvel", "Sinopsis pelicula", "ATP", "capitana_marvel");
        insertMovie(context, "Pokemon: Detective Pikachu", "Sinopsis pelicula", "ATP", "pokemon_detective_pikachu");
    }

    public MovieModel getMovie(Context context, int id) {
        MovieModel movieModel = null;
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor res = db.rawQuery( "select " + dbHelper.getColId() + ", " + dbHelper.getColTitulo()
                + ", " + dbHelper.getColSinopsis()
                + ", " + dbHelper.getColEdad() + ", " + dbHelper.getColRutaImg()
                + " from "+ dbHelper.getDatabaseTableMovies() + " where "
                + dbHelper.getColId() + " = '" + id + "'", null );
        if(res.getCount() > 0){
            res.moveToFirst();
            movieModel = new MovieModel(Integer.parseInt(res.getString(0)),res.getString(1),res.getString(2),res.getString(3),
                    context.getResources().getIdentifier(res.getString(4), "drawable", context.getPackageName()));
        }
        res.close();
        return movieModel;
    }

    public ArrayList<MovieModel> getAllActiveMovies(Context context) {
        ArrayList<MovieModel> listActiveMovies = null;
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor res = db.rawQuery( "select " + dbHelper.getColId() + ", " + dbHelper.getColTitulo()
                + ", " + dbHelper.getColSinopsis()
                + ", " + dbHelper.getColEdad() + ", " + dbHelper.getColRutaImg()
                + " from "+ dbHelper.getDatabaseTableMovies(), null ); //agregar where validando fecha vigencia
        if(res.getCount() > 0){
            listActiveMovies = new ArrayList<>();
            while(res.moveToNext()){
                MovieModel movieModel = new MovieModel(Integer.parseInt(res.getString(0)),res.getString(1),res.getString(2),res.getString(3),
                        context.getResources().getIdentifier(res.getString(4), "drawable", context.getPackageName()));
                listActiveMovies.add(movieModel);
            }
        }
        res.close();
        return listActiveMovies;
    }
}
