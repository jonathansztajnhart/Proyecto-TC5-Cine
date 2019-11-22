package com.jnj.cinepop.DBAccess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBSeatManager {

    public boolean insertSeat(Context context, int cantAsientos, int idFuncion) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.getColCantAsientos(), String.valueOf(cantAsientos));
        contentValues.put(DatabaseHelper.getColIdFuncion(), String.valueOf(idFuncion));
        long result = db.insert(DatabaseHelper.getDatabaseTableSeats(), null, contentValues);
        return (result != -1);
    }

    public void loadSeats(Context context){
        insertSeat(context, 100, 1);
        insertSeat(context, 100, 2);
        insertSeat(context, 100, 3);
        insertSeat(context, 100, 4);
        insertSeat(context, 100, 5);
        insertSeat(context, 100, 6);
        insertSeat(context, 100, 7);
        insertSeat(context, 100, 8);
        insertSeat(context, 100, 9);
        insertSeat(context, 100, 10);
        insertSeat(context, 100, 11);
        insertSeat(context, 100, 12);
        insertSeat(context, 100, 13);
        insertSeat(context, 100, 14);
        insertSeat(context, 100, 15);
        insertSeat(context, 100, 16);
        insertSeat(context, 100, 17);
        insertSeat(context, 100, 18);
        insertSeat(context, 100, 19);
        insertSeat(context, 100, 20);
        insertSeat(context, 100, 21);
        insertSeat(context, 100, 22);
        insertSeat(context, 100, 23);
        insertSeat(context, 100, 24);
        insertSeat(context, 100, 25);
        insertSeat(context, 100, 26);
        insertSeat(context, 100, 27);
        insertSeat(context, 100, 28);
        insertSeat(context, 100, 29);
        insertSeat(context, 100, 30);
        insertSeat(context, 100, 31);
        insertSeat(context, 100, 32);
        insertSeat(context, 100, 33);
        insertSeat(context, 100, 34);
        insertSeat(context, 100, 35);
        insertSeat(context, 100, 36);

    }

    public int getCantAsientos(Context context, int idFuncion) {
        int cantAsientos = 0;
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor res = db.rawQuery( "select distinct " + DatabaseHelper.getColCantAsientos()
                + " from "+ DatabaseHelper.getDatabaseTableSeats() + " where "
                + DatabaseHelper.getColIdFuncion() + " = '" + idFuncion + "'", null );
        if(res.getCount() > 0){
            res.moveToFirst();
            cantAsientos = Integer.parseInt(res.getString(0));
        }
        res.close();
        return cantAsientos;
    }

    public void disminuirCantAsientos(Context context, int idFuncion, int cantAsientosSeleccionados) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("update " + DatabaseHelper.getDatabaseTableSeats()
                + " set "+ DatabaseHelper.getColCantAsientos() + " = ''"
                + (getCantAsientos(context,idFuncion) - cantAsientosSeleccionados) + "'"
                + " where " + DatabaseHelper.getColIdFuncion() + " = '" + idFuncion + "'", null );
    }

    public void aumentarCantAsientos(Context context, int idFuncion, int cantAsientosSeleccionados) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("update " + DatabaseHelper.getDatabaseTableSeats()
                + " set "+ DatabaseHelper.getColCantAsientos() + " = ''"
                + (getCantAsientos(context,idFuncion) + cantAsientosSeleccionados) + "'"
                + " where " + DatabaseHelper.getColIdFuncion() + " = '" + idFuncion + "'", null );
    }
}
