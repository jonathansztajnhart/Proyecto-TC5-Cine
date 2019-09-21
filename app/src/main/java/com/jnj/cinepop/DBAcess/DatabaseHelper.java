package com.jnj.cinepop.DBAcess;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.*;
import android.os.Bundle;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "Cinepop.db";
    private static final String DATABASE_TABLE = "Usuarios_table";
    private static final String COL_ID = "ID";
    private static final String COL_NOMBRE = "NOMBRE";
    private static final String COL_APELLIDO = "APELLIDO";
    private static final String COL_EMAIL = "EMAIL";
    private static final String COL_PASSWORD = "CONTRASEÑA";

    private static final String scriptTableUsuarios = "create table if not exists " + DATABASE_TABLE + "(\n" +
            COL_ID + " integer PRIMARY KEY autoincrement,\n" +
            COL_NOMBRE + " text,\n" +
            COL_APELLIDO + " text,\n" +
            COL_EMAIL + " text,\n" +
            COL_PASSWORD + " text)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(scriptTableUsuarios);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        db.execSQL(scriptTableUsuarios);
    }

    public boolean insertUsuario(String nombre, String apellido, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NOMBRE, nombre);
        contentValues.put(COL_APELLIDO, apellido);
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_PASSWORD, password);
        long result = db.insert(DATABASE_TABLE, null, contentValues);
        return (result != -1);
    }
}
