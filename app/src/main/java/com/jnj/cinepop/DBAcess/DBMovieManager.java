package com.jnj.cinepop.DBAcess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jnj.cinepop.models.LoginModel;
import com.jnj.cinepop.models.MovieModel;

import java.util.ArrayList;

public class DBMovieManager {
    public boolean insertMovie(Context context, String titulo, String sinopsis, String edad, String rutaImg,
                               String fInicio, String fFin) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.getColTitulo(), titulo);
        contentValues.put(dbHelper.getColSinopsis(), sinopsis);
        contentValues.put(dbHelper.getColEdad(), edad);
        contentValues.put(dbHelper.getColRutaImg(), rutaImg);
        contentValues.put(dbHelper.getColFInicio(), fInicio);
        contentValues.put(dbHelper.getColFFin(), fFin);
        long result = db.insert(dbHelper.getDatabaseTableMovies(), null, contentValues);
        return (result != -1);
    }

    /*public boolean findMovie(Context context, int id) {
        boolean isFoundMovie = false;
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor res = db.rawQuery( "select " + dbHelper.getColTitulo() + " from " + dbHelper.getDatabaseTableMovies() + " where "
                    + dbHelper.getColId() + " = '" + id + "'", null );
        if(res.getCount() > 0){
            isFoundMovie = true;
        }
        res.close();
        return isFoundMovie;
    }*/

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
                    res.getString(4));
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
                MovieModel movieModel = new MovieModel(Integer.parseInt(res.getString(0)),res.getString(1),
                        res.getString(2),res.getString(3), res.getString(4));
                listActiveMovies.add(movieModel);
            }
        }
        res.close();
        return listActiveMovies;
    }
}
