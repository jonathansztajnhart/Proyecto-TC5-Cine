package com.jnj.cinepop.DBAccess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jnj.cinepop.models.FuncionModel;
import com.jnj.cinepop.models.MovieModel;

import java.util.ArrayList;

public class DBFunctionManager {

    public boolean insertFuncion(Context context, int idPelicula, String fecha, String hora, int idSucursal,
        int tipoFuncion, String idioma) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.getColIdPelicula(), String.valueOf(idPelicula));
        contentValues.put(dbHelper.getColFecha(), fecha);
        contentValues.put(dbHelper.getColHora(), hora);
        contentValues.put(dbHelper.getColIdSucursal(), String.valueOf(idSucursal));
        contentValues.put(dbHelper.getColTipoFuncion(), String.valueOf(tipoFuncion));
        contentValues.put(dbHelper.getColIdioma(), idioma);
        long result = db.insert(dbHelper.getDatabaseTableFunctions(), null, contentValues);
        return (result != -1);
    }

    public void loadMovies(Context context){
        insertFuncion(context, 1, "15-12-2019", "12:00hs", 1, 1, "Español");
    }

    public FuncionModel getFuncion(Context context, int id) {
        FuncionModel funcionModel = null;
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor res = db.rawQuery( "select " + dbHelper.getColId() + ", " + dbHelper.getColIdPelicula()
                + ", " + dbHelper.getColFecha() + ", " + dbHelper.getColHora()
                + ", " + dbHelper.getColIdSucursal() + ", " + dbHelper.getColTipoFuncion()
                + ", " + dbHelper.getColIdioma()
                + " from "+ dbHelper.getDatabaseTableMovies() + " where "
                + dbHelper.getColId() + " = '" + id + "'", null );
        if(res.getCount() > 0){
            res.moveToFirst();
            funcionModel = new FuncionModel(Integer.parseInt(res.getString(0)),Integer.parseInt(res.getString(1)),
                    res.getString(2),res.getString(3),
                    Integer.parseInt(res.getString(4)), Integer.parseInt(res.getString(5)),
                    res.getString(6));
        }
        res.close();
        return funcionModel;
    }

    /*public ArrayList<FuncionModel> getAllFuncions(Context context) {
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
    }*/
}
