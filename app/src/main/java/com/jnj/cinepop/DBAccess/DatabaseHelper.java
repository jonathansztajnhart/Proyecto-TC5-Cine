package com.jnj.cinepop.DBAccess;

import android.content.Context;
import android.database.sqlite.*;

public class DatabaseHelper extends SQLiteOpenHelper{

    //Base de datos
    private static final String DATABASE_NAME = "Cinepop.db";

    //Tablas
    private static final String DATABASE_TABLE_USERS = "Usuarios_table";
    private static final String DATABASE_TABLE_MOVIES = "Movies_table";
    private static final String DATABASE_TABLE_FUNCTIONS = "Funciones_table";
    private static final String DATABASE_TABLE_SUBSIDIARY = "Sucursales_table";
    private static final String DATABASE_TABLE_FUNCTIONS_TYPE = "Tipo_Funciones_table";

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
    private static final String COL_ID_PELICULA = "ID_MOVIE";

    private static final String COL_ID_SUCURSAL= "ID_SUCURSAL";
    private static final String COL_TIPO_FUNCION = "TIPO_FUNCION";
    private static final String COL_FECHA = "FECHA";
    private static final String COL_HORA = "HORA";
    private static final String COL_IDIOMA = "IDIOMA";

    private static final String COL_ID_TIPO = "ID_TIPO";
    private static final String COL_PRECIO = "PRECIO";

    private static final String COL_NOMBRE_SUC = "NOMBRE_SUC";
    private static final String COL_DIREC_SUC = "DIREC_SUC";

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
            COL_RUTA_IMG + " text)";

    private static final String scriptTableFunctions = "create table if not exists " + DATABASE_TABLE_FUNCTIONS + "(\n" +
            COL_ID + " integer PRIMARY KEY autoincrement,\n" +
            COL_ID_PELICULA + " text,\n" +
            COL_FECHA + " text,\n" +
            COL_HORA + " text,\n" +
            COL_ID_SUCURSAL + " text,\n" +
            COL_TIPO_FUNCION + " text,\n" +
            COL_IDIOMA + " text)";

    private static final String scriptTableFunctionsType = "create table if not exists " + DATABASE_TABLE_FUNCTIONS_TYPE + "(\n" +
            COL_ID_TIPO + " integer PRIMARY KEY autoincrement,\n" +
            COL_TIPO_FUNCION + " text,\n" +
            COL_PRECIO + " text)";

    private static final String scriptTableSubsidiary = "create table if not exists " + DATABASE_TABLE_SUBSIDIARY + "(\n" +
            COL_ID_SUCURSAL + " integer PRIMARY KEY autoincrement,\n" +
            COL_NOMBRE_SUC + " text,\n" +
            COL_DIREC_SUC + " text)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(scriptTableUsuarios);
        db.execSQL(scriptTableMovies);
        db.execSQL(scriptTableFunctions);
        db.execSQL(scriptTableFunctionsType);
        db.execSQL(scriptTableSubsidiary);
    }

    public void uploadTables(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_MOVIES);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_FUNCTIONS);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_FUNCTIONS_TYPE);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_SUBSIDIARY);
        db.execSQL(scriptTableMovies);
        db.execSQL(scriptTableFunctions);
        db.execSQL(scriptTableFunctionsType);
        db.execSQL(scriptTableSubsidiary);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_MOVIES);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_FUNCTIONS);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_FUNCTIONS_TYPE);
        db.execSQL(scriptTableUsuarios);
        db.execSQL(scriptTableMovies);
        db.execSQL(scriptTableFunctions);
        db.execSQL(scriptTableFunctionsType);
        db.execSQL(scriptTableSubsidiary);
    }

    public static String getDatabaseTableUsers() {
        return DATABASE_TABLE_USERS;
    }

    public static String getDatabaseTableMovies() {
        return DATABASE_TABLE_MOVIES;
    }

    public static String getDatabaseTableFunctions() {
        return DATABASE_TABLE_FUNCTIONS;
    }

    public static String getDatabaseTableFunctionsType() {
        return DATABASE_TABLE_FUNCTIONS_TYPE;
    }

    public static String getDatabaseTableSubsidiary() {
        return DATABASE_TABLE_SUBSIDIARY;
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

    public static String getColIdPelicula() {
        return COL_ID_PELICULA;
    }

    public static String getColIdSucursal() {
        return COL_ID_SUCURSAL;
    }

    public static String getColTipoFuncion() {
        return COL_TIPO_FUNCION;
    }

    public static String getColFecha() {
        return COL_FECHA;
    }

    public static String getColHora() {
        return COL_HORA;
    }

    public static String getColIdioma() {
        return COL_IDIOMA;
    }

    public static String getColIdTipo() {
        return COL_ID_TIPO;
    }

    public static String getColPrecio() {
        return COL_PRECIO;
    }

    public static String getColNombreSuc() {
        return COL_NOMBRE_SUC;
    }

    public static String getColDirecSuc() {
        return COL_DIREC_SUC;
    }
}
