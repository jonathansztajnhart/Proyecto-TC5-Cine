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
        insertSeat(context, 100, 37);
        insertSeat(context, 100, 38);
        insertSeat(context, 100, 39);
        insertSeat(context, 100, 40);
        insertSeat(context, 100, 41);
        insertSeat(context, 100, 42);
        insertSeat(context, 100, 43);
        insertSeat(context, 100, 44);
        insertSeat(context, 100, 45);
        insertSeat(context, 100, 46);
        insertSeat(context, 100, 47);
        insertSeat(context, 100, 48);
        insertSeat(context, 100, 49);
        insertSeat(context, 100, 50);
        insertSeat(context, 100, 51);
        insertSeat(context, 100, 52);
        insertSeat(context, 100, 53);
        insertSeat(context, 100, 54);
        insertSeat(context, 100, 55);
        insertSeat(context, 100, 56);
        insertSeat(context, 100, 57);
        insertSeat(context, 100, 58);
        insertSeat(context, 100, 59);
        insertSeat(context, 100, 60);
        insertSeat(context, 100, 61);
        insertSeat(context, 100, 62);
        insertSeat(context, 100, 63);
        insertSeat(context, 100, 64);
        insertSeat(context, 100, 65);
        insertSeat(context, 100, 66);
        insertSeat(context, 100, 67);
        insertSeat(context, 100, 68);
        insertSeat(context, 100, 69);
        insertSeat(context, 100, 70);
        insertSeat(context, 100, 71);
        insertSeat(context, 100, 72);
        insertSeat(context, 100, 73);
        insertSeat(context, 100, 74);
        insertSeat(context, 100, 75);
        insertSeat(context, 100, 76);
        insertSeat(context, 100, 77);
        insertSeat(context, 100, 78);
        insertSeat(context, 100, 79);
        insertSeat(context, 100, 80);
        insertSeat(context, 100, 81);
        insertSeat(context, 100, 82);
        insertSeat(context, 100, 83);
        insertSeat(context, 100, 84);
        insertSeat(context, 100, 85);
        insertSeat(context, 100, 86);
        insertSeat(context, 100, 87);
        insertSeat(context, 100, 88);
        insertSeat(context, 100, 89);
        insertSeat(context, 100, 90);
        insertSeat(context, 100, 91);
        insertSeat(context, 100, 92);
        insertSeat(context, 100, 93);
        insertSeat(context, 100, 94);
        insertSeat(context, 100, 95);
        insertSeat(context, 100, 96);
        insertSeat(context, 100, 97);
        insertSeat(context, 100, 98);
        insertSeat(context, 100, 99);
        insertSeat(context, 100, 100);
        insertSeat(context, 100, 101);
        insertSeat(context, 100, 102);
        insertSeat(context, 100, 103);
        insertSeat(context, 100, 104);
        insertSeat(context, 100, 105);
        insertSeat(context, 100, 106);
        insertSeat(context, 100, 107);
        insertSeat(context, 100, 108);
        insertSeat(context, 100, 109);
        insertSeat(context, 100, 110);
        insertSeat(context, 100, 111);
        insertSeat(context, 100, 112);
        insertSeat(context, 100, 113);
        insertSeat(context, 100, 114);
        insertSeat(context, 100, 115);
        insertSeat(context, 100, 116);
        insertSeat(context, 100, 117);
        insertSeat(context, 100, 118);
        insertSeat(context, 100, 119);
        insertSeat(context, 100, 120);
        insertSeat(context, 100, 121);
        insertSeat(context, 100, 122);
        insertSeat(context, 100, 123);
        insertSeat(context, 100, 124);
        insertSeat(context, 100, 125);
        insertSeat(context, 100, 126);
        insertSeat(context, 100, 127);
        insertSeat(context, 100, 128);
        insertSeat(context, 100, 129);
        insertSeat(context, 100, 130);
        insertSeat(context, 100, 131);
        insertSeat(context, 100, 132);
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
        int asientosRestantes = getCantAsientos(context, idFuncion) - cantAsientosSeleccionados;
        db.execSQL("update " + DatabaseHelper.getDatabaseTableSeats()
                + " set "+ DatabaseHelper.getColCantAsientos() + " = '"
                +  String.valueOf(asientosRestantes) + "'"
                + " where " + DatabaseHelper.getColIdFuncion() + " = '" + idFuncion + "'");
    }
}
