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
        contentValues.put(DatabaseHelper.getColIdPelicula(), String.valueOf(idPelicula));
        contentValues.put(DatabaseHelper.getColFecha(), fecha);
        contentValues.put(DatabaseHelper.getColHora(), hora);
        contentValues.put(DatabaseHelper.getColIdSucursal(), String.valueOf(idSucursal));
        contentValues.put(DatabaseHelper.getColTipoFuncion(), String.valueOf(tipoFuncion));
        contentValues.put(DatabaseHelper.getColIdioma(), idioma);
        long result = db.insert(DatabaseHelper.getDatabaseTableFunctions(), null, contentValues);
        return (result != -1);
    }

    public void loadFunctions(Context context){

        /*inserts funciones dia 25/11*/
        insertFuncion(context, 2, "25/11/2019", "18:00:00", 1,1, "subtitulada");
        insertFuncion(context, 2,"25/11/2019", "22:00:00", 1,2, "subtitulada");
        insertFuncion(context, 1,"25/11/2019", "18:00:00", 2,2, "subtitulada");
        insertFuncion(context, 1,"25/11/2019", "23:00:00", 3,1, "doblada");
        insertFuncion(context, 3,"25/11/2019", "17:00:00", 3,1, "subtitulada");
        insertFuncion(context, 3,"25/11/2019", "21:00:00", 4,2, "doblada");
        insertFuncion(context, 4,"25/11/2019", "19:00:00", 3,1, "subtitulada");
        insertFuncion(context, 4,"25/11/2019", "23:30:00", 3,2, "doblada");
        insertFuncion(context, 5,"25/11/2019", "18:20:00", 2,1, "subtitulada");
        insertFuncion(context, 5,"25/11/2019", "23:00:00", 1,2, "doblada");
        insertFuncion(context, 6,"25/11/2019", "17:30:00", 1,1, "subtitulada");
        insertFuncion(context, 7,"25/11/2019", "22:30:00", 4,2, "doblada");
        insertFuncion(context, 7,"25/11/2019", "18:30:00", 2,1, "subtitulada");
        insertFuncion(context, 8,"25/11/2019", "22:30:00", 3,2, "doblada");
        insertFuncion(context, 8,"25/11/2019", "19:30:00", 3,1, "subtitulada");
        insertFuncion(context, 8,"25/11/2019", "22:00:00", 4,2, "doblada");
        insertFuncion(context, 9,"25/11/2019", "16:30:00", 4,1, "subtitulada");
        insertFuncion(context, 9,"25/11/2019", "21:30:00", 1,2, "doblada");
        insertFuncion(context, 10,"25/11/2019", "16:00:00", 1,1, "subtitulada");
        insertFuncion(context, 10,"25/11/2019", "22:30:00", 2,2, "doblada");
        insertFuncion(context, 11,"25/11/2019", "18:00:00", 2,1, "subtitulada");
        insertFuncion(context, 11,"25/11/2019", "21:30:00", 3,2, "doblada");

        /*inserts funciones dia 26/11*/
        insertFuncion(context, 1,"26/11/2019", "17:30:00", 4,1, "subtitulada");
        insertFuncion(context, 1,"26/11/2019", "22:30:00", 3,2, "doblada");
        insertFuncion(context, 2,"26/11/2019", "18:00:00", 1,1, "subtitulada");
        insertFuncion(context, 2,"26/11/2019", "21:30:00", 4,2, "doblada");
        insertFuncion(context, 3,"26/11/2019", "15:30:00", 2,1, "subtitulada");
        insertFuncion(context, 3,"26/11/2019", "21:00:00", 1,2, "doblada");
        insertFuncion(context, 4,"26/11/2019", "15:00:00", 3,1, "subtitulada");
        insertFuncion(context, 4,"26/11/2019", "21:00:00", 2,2, "doblada");
        insertFuncion(context, 5,"26/11/2019", "16:30:00", 4,1, "subtitulada");
        insertFuncion(context, 5,"26/11/2019", "23:30:00", 3,2, "doblada");
        insertFuncion(context, 6,"26/11/2019", "14:30:00", 1,1, "subtitulada");
        insertFuncion(context, 6,"26/11/2019", "22:00:00", 2,2, "doblada");
        insertFuncion(context, 7,"26/11/2019", "14:00:00", 2,1, "subtitulada");
        insertFuncion(context, 7,"26/11/2019", "23:00:00", 1,2, "doblada");
        insertFuncion(context, 8,"26/11/2019", "13:30:00", 3,1, "subtitulada");
        insertFuncion(context, 8,"26/11/2019", "21:30:00", 2,2, "doblada");
        insertFuncion(context, 9,"26/11/2019", "13:00:00", 4,1, "subtitulada");
        insertFuncion(context, 9,"26/11/2019", "22:00:00", 3,2, "doblada");
        insertFuncion(context, 10,"26/11/2019", "14:30:00", 1,1, "subtitulada");
        insertFuncion(context, 10,"26/11/2019", "23:00:00", 4,2, "doblada");
        insertFuncion(context, 11,"26/11/2019", "18:00:00", 2,1, "subtitulada");
        insertFuncion(context, 11,"26/11/2019", "20:30:00", 1,2, "doblada");

        /*inserts funciones dia 27/11*/
        insertFuncion(context, 1,"27/11/2019", "17:30:00", 4,1, "subtitulada");
        insertFuncion(context, 1,"27/11/2019", "22:30:00", 3,2, "doblada");
        insertFuncion(context, 2,"27/11/2019", "15:00:00", 1,1, "subtitulada");
        insertFuncion(context, 2,"27/11/2019", "17:30:00", 4,2, "doblada");
        insertFuncion(context, 3,"27/11/2019", "17:30:00", 2,1, "subtitulada");
        insertFuncion(context, 3,"27/11/2019", "17:30:00", 1,2, "doblada");
        insertFuncion(context, 4,"27/11/2019", "17:30:00", 2,1, "subtitulada");
        insertFuncion(context, 4,"27/11/2019", "19:30:00", 3,2, "doblada");
        insertFuncion(context, 5,"27/11/2019", "17:30:00", 2,1, "subtitulada");
        insertFuncion(context, 5,"27/11/2019", "17:30:00", 1,2, "doblada");
        insertFuncion(context, 6,"27/11/2019", "21:30:00", 1,1, "subtitulada");
        insertFuncion(context, 6,"27/11/2019", "17:30:00", 4,2, "doblada");
        insertFuncion(context, 7,"27/11/2019", "17:30:00", 2,1, "subtitulada");
        insertFuncion(context, 7,"27/11/2019", "23:00:00", 3,2, "doblada");
        insertFuncion(context, 8,"27/11/2019", "16:00:00", 3,1, "subtitulada");
        insertFuncion(context, 8,"27/11/2019", "20:00:00", 4,2, "doblada");
        insertFuncion(context, 9,"27/11/2019", "17:30:00", 4,1, "subtitulada");
        insertFuncion(context, 9,"27/11/2019", "22:30:00", 1,2, "doblada");
        insertFuncion(context, 10,"27/11/2019", "18:30:00", 1,1, "subtitulada");
        insertFuncion(context, 10,"27/11/2019", "22:30:00", 2,2, "doblada");
        insertFuncion(context, 11,"27/11/2019", "18:00:00", 2,1, "subtitulada");
        insertFuncion(context, 11,"27/11/2019", "21:30:00", 3,2, "doblada");

        /*inserts funciones dia 28/11*/
        insertFuncion(context, 1,"28/11/2019", "17:30:00", 4,1, "subtitulada");
        insertFuncion(context, 1, "28/11/2019", "22:30:00", 3,2, "doblada");
        insertFuncion(context, 2,"28/11/2019", "15:00:00", 1,1, "subtitulada");
        insertFuncion(context, 2,"28/11/2019", "17:30:00", 4,2, "doblada");
        insertFuncion(context, 3,"28/11/2019", "17:30:00", 2,1, "subtitulada");
        insertFuncion(context, 3,"28/11/2019", "17:30:00", 1,2, "doblada");
        insertFuncion(context, 4,"28/11/2019", "17:30:00", 2,1, "subtitulada");
        insertFuncion(context, 4,"28/11/2019", "19:30:00", 3,2, "doblada");
        insertFuncion(context, 5,"28/11/2019", "17:30:00", 2,1, "subtitulada");
        insertFuncion(context, 5,"28/11/2019", "17:30:00", 1,2, "doblada");
        insertFuncion(context, 6,"28/11/2019", "21:30:00", 1,1, "subtitulada");
        insertFuncion(context, 6,"28/11/2019", "17:30:00", 4,2, "doblada");
        insertFuncion(context, 7,"28/11/2019", "17:30:00", 2,1, "subtitulada");
        insertFuncion(context, 7,"28/11/2019", "23:00:00", 3,2, "doblada");
        insertFuncion(context, 8,"28/11/2019", "16:00:00", 3,1, "subtitulada");
        insertFuncion(context, 8,"28/11/2019", "20:00:00", 4,2, "doblada");
        insertFuncion(context, 9,"28/11/2019", "17:30:00", 4,1, "subtitulada");
        insertFuncion(context, 9,"28/11/2019", "22:30:00", 1,2, "doblada");
        insertFuncion(context, 10,"28/11/2019", "18:30:00", 1,1, "subtitulada");
        insertFuncion(context, 10,"28/11/2019", "22:30:00", 2,2, "doblada");
        insertFuncion(context, 11,"28/11/2019", "18:00:00", 2,1, "subtitulada");
        insertFuncion(context, 11,"28/11/2019", "21:30:00", 3,2, "doblada");

        /*inserts funciones dia 29/11*/
        insertFuncion(context, 1,"29/11/2019", "17:30:00", 4,1, "subtitulada");
        insertFuncion(context, 1,"29/11/2019", "22:30:00", 3,2, "doblada");
        insertFuncion(context, 2,"29/11/2019", "18:00:00", 1,1, "subtitulada");
        insertFuncion(context, 2,"29/11/2019", "21:30:00", 4,2, "doblada");
        insertFuncion(context, 3,"26/11/2019", "15:30:00",1, 1,"subtitulada");
        insertFuncion(context, 3,"29/11/2019", "21:00:00", 1,2, "doblada");
        insertFuncion(context, 4,"29/11/2019", "15:00:00", 3,1, "subtitulada");
        insertFuncion(context, 4,"29/11/2019", "21:00:00", 2,2, "doblada");
        insertFuncion(context, 5,"29/11/2019", "16:30:00", 4,1, "subtitulada");
        insertFuncion(context, 5,"29/11/2019", "23:30:00", 3,2, "doblada");
        insertFuncion(context, 6,"29/11/2019", "14:30:00", 1,1, "subtitulada");
        insertFuncion(context, 6,"29/11/2019", "22:00:00", 2,2, "doblada");
        insertFuncion(context, 7,"29/11/2019", "14:00:00", 2,1, "subtitulada");
        insertFuncion(context, 7,"29/11/2019", "23:00:00", 1,2, "doblada");
        insertFuncion(context, 8,"29/11/2019", "13:30:00", 3,1, "subtitulada");
        insertFuncion(context, 8,"29/11/2019", "21:30:00", 2,2, "doblada");
        insertFuncion(context, 9,"29/11/2019", "13:00:00", 4,1, "subtitulada");
        insertFuncion(context, 9,"29/11/2019", "22:00:00", 3,2, "doblada");
        insertFuncion(context, 10,"29/11/2019", "14:30:00", 1,1, "subtitulada");
        insertFuncion(context, 10,"29/11/2019", "23:00:00", 4,2, "doblada");
        insertFuncion(context, 11,"29/11/2019", "18:00:00", 2,1, "subtitulada");
        insertFuncion(context, 11,"29/11/2019", "20:30:00", 1,2, "doblada");

        /*inserts funciones dia 30/11*/
        insertFuncion(context, 1,"30/11/2019", "17:30:00", 4,1, "subtitulada");
        insertFuncion(context, 1,"30/11/2019", "22:30:00", 3,2, "doblada");
        insertFuncion(context, 2,"30/11/2019", "18:00:00", 1,1, "subtitulada");
        insertFuncion(context, 2,"30/11/2019", "21:30:00", 4,2, "doblada");
        insertFuncion(context, 3,"30/11/2019", "15:30:00", 2,1, "subtitulada");
        insertFuncion(context, 3,"30/11/2019", "21:00:00", 1,2, "doblada");
        insertFuncion(context, 4,"30/11/2019", "15:00:00", 3,1, "subtitulada");
        insertFuncion(context, 4,"30/11/2019", "21:00:00", 2,2, "doblada");
        insertFuncion(context, 5,"30/11/2019", "16:30:00", 4,1, "subtitulada");
        insertFuncion(context, 5,"30/11/2019", "23:30:00", 3,2, "doblada");
        insertFuncion(context, 6,"30/11/2019", "14:30:00", 1,1, "subtitulada");
        insertFuncion(context, 6,"30/11/2019", "22:00:00", 2,2, "doblada");
        insertFuncion(context, 7,"30/11/2019", "14:00:00", 2,1, "subtitulada");
        insertFuncion(context, 7,"30/11/2019", "23:00:00", 1,2, "doblada");
        insertFuncion(context, 8,"30/11/2019", "13:30:00", 3,1, "subtitulada");
        insertFuncion(context, 8,"30/11/2019", "21:30:00", 2,2, "doblada");
        insertFuncion(context, 9,"30/11/2019", "13:00:00", 4,1, "subtitulada");
        insertFuncion(context, 9,"30/11/2019", "22:00:00", 3,2, "doblada");
        insertFuncion(context, 10,"30/11/2019", "14:30:00", 1,1, "subtitulada");
        insertFuncion(context, 10,"30/11/2019", "23:00:00", 4,2, "doblada");
        insertFuncion(context, 11,"30/11/2019", "18:00:00", 2,1, "subtitulada");
        insertFuncion(context, 11,"30/11/2019", "20:30:00", 1,2, "doblada");
    }

    public FuncionModel getFuncion(Context context, int id) {
        FuncionModel funcionModel = null;
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor res = db.rawQuery( "select " + DatabaseHelper.getColId() + ", " + DatabaseHelper.getColIdPelicula()
                + ", " + DatabaseHelper.getColFecha() + ", " + DatabaseHelper.getColHora()
                + ", " + DatabaseHelper.getColIdSucursal() + ", " + DatabaseHelper.getColTipoFuncion()
                + ", " + DatabaseHelper.getColIdioma()
                + " from "+ DatabaseHelper.getDatabaseTableMovies() + " where "
                + DatabaseHelper.getColId() + " = '" + id + "'", null );
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

    public ArrayList<String> getFunctionDates(Context context, int id) {
        ArrayList<String> functionDates = null;
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor res = db.rawQuery( "select distinct " + DatabaseHelper.getColFecha()
                + " from "+ DatabaseHelper.getDatabaseTableFunctions() + " where "
                + DatabaseHelper.getColIdPelicula() + " = '" + id + "'", null );
        if(res.getCount() > 0){
            functionDates = new ArrayList<>();
            while(res.moveToNext()){
                functionDates.add(res.getString(0));
            }
        }
        res.close();
        return functionDates;
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
