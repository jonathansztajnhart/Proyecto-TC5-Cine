package com.jnj.cinepop.DBAcess;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.*;
import android.os.Bundle;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper{

    //Base de datos
    private static final String DATABASE_NAME = "Cinepop.db";

    //Tablas
    private static final String DATABASE_TABLE_USERS = "Usuarios_table";
    private static final String DATABASE_TABLE_MOVIES = "Movies_table";

    //Campos
    private static final String COL_ID = "ID";
    private static final String COL_NOMBRE = "NOMBRE";
    private static final String COL_APELLIDO = "APELLIDO";
    private static final String COL_EMAIL = "EMAIL";
    private static final String COL_PASSWORD = "CONTRASEÑA";
    private static final String COL_TITULO = "TITULO";
    private static final String COL_SINOPSIS = "SINOPSIS";
    private static final String COL_EDAD = "EDAD";
    private static final String COL_RUTA_IMG = "RUTA_IMG";
    private static final String COL_F_INICIO = "F_INICIO";
    private static final String COL_F_FIN = "F_FIN";
    private static final String COL_ACTIVA = "ACTIVA";

    //Scripts tablas
    private static final String scriptTableUsuarios = "create table if not exists " + DATABASE_TABLE_USERS + "(\n" +
            COL_ID + " integer PRIMARY KEY autoincrement,\n" +
            COL_NOMBRE + " text,\n" +
            COL_APELLIDO + " text,\n" +
            COL_EMAIL + " text,\n" +
            COL_PASSWORD + " text)";

    private static final String scriptTableMovies = "create table if not exists " + DATABASE_TABLE_MOVIES + "(\n" +
            COL_ID + " integer PRIMARY KEY autoincrement,\n" +
            COL_TITULO + " text,\n" +
            COL_SINOPSIS + " text,\n" +
            COL_EDAD + " text,\n" +
            COL_RUTA_IMG + " text,\n" +
            COL_F_INICIO + " text,\n" +
            COL_F_FIN + " text,\n" +
            COL_ACTIVA + " text)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(scriptTableUsuarios);
        db.execSQL(scriptTableMovies);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_MOVIES);
        db.execSQL(scriptTableUsuarios);
        db.execSQL(scriptTableMovies);
    }

    public static String getDatabaseTableUsers() {
        return DATABASE_TABLE_USERS;
    }

    public static String getDatabaseTableMovies() {
        return DATABASE_TABLE_MOVIES;
    }

    public static String getColId() {
        return COL_ID;
    }

    public static String getColNombre() {
        return COL_NOMBRE;
    }

    public static String getColApellido() {
        return COL_APELLIDO;
    }

    public static String getColEmail() {
        return COL_EMAIL;
    }

    public static String getColPassword() {
        return COL_PASSWORD;
    }

    public static String getColTitulo() {
        return COL_TITULO;
    }

    public static String getColSinopsis() {
        return COL_SINOPSIS;
    }

    public static String getColEdad() {
        return COL_EDAD;
    }

    public static String getColRutaImg() {
        return COL_RUTA_IMG;
    }

    public static String getColFInicio() {
        return COL_F_INICIO;
    }

    public static String getColFFin() {
        return COL_F_FIN;
    }

    public static String getColActiva() {
        return COL_ACTIVA;
    }

    /* boolean insertUsuario(String nombre, String apellido, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NOMBRE, nombre);
        contentValues.put(COL_APELLIDO, apellido);
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_PASSWORD, password);
        long result = db.insert(DATABASE_TABLE, null, contentValues);
        return (result != -1);
    }*/
}
