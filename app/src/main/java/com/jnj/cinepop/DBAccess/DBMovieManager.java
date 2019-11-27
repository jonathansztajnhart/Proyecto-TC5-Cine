package com.jnj.cinepop.DBAccess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jnj.cinepop.models.MovieModel;

import java.util.ArrayList;

public class DBMovieManager {

    public boolean insertMovie(Context context, String titulo, String sinopsis, String edad, String rutaImg) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.getColTitulo(), titulo);
        contentValues.put(DatabaseHelper.getColSinopsis(), sinopsis);
        contentValues.put(DatabaseHelper.getColEdad(), edad);
        contentValues.put(DatabaseHelper.getColRutaImg(), rutaImg);
        long result = db.insert(DatabaseHelper.getDatabaseTableMovies(), null, contentValues);
        return (result != -1);
    }

    public void loadMovies(Context context){
        insertMovie(context, "Avengers Endgame", "Los Vengadores restantes deben encontrar una manera de recuperar a sus aliados para un enfrentamiento épico con Thanos.", "+13", "avengers_endgame");
        insertMovie(context, "Angry Birds 2", "Red, Chuck, Bomb y el resto de sus amigos son abordados por un cerdo verde que les pide que se unan para luchar contra una amenaza común.", "ATP", "angry_birds_2");
        insertMovie(context, "Capitana Marvel", "Una guerrera extraterrestre de la civilización Kree con la ayuda de Nick Fury trata de descubrir los secretos de su pasado mientras aprovecha sus poderes para terminar la guerra.", "+13", "capitana_marvel");
        insertMovie(context, "Pokemon: Detective Pikachu", "Un joven une fuerzas con el detective Pikachu para desentrañar el misterio detrás de la desaparición de su padre.", "ATP", "pokemon_detective_pikachu");
        insertMovie(context, "Dora y la ciudad perdida", "Dora junto a su amigo Botas comienzan una aventura en la que deberán salvar a los padres de Dora y resolver el misterio oculto tras una ciudad perdida de oro.", "ATP", "dora_y_la_ciudad_perdida");
        insertMovie(context, "Dumbo", "El dueño de un circo en aprietos contrata a un hombre y sus dos hijos para cuidar de un elefante recién nacido que puede volar, que pronto ayuda a revitalizar al circo.", "ATP", "dumbo");
        insertMovie(context, "El hijo", "Una mujer embarazada se aísla cada vez más de su marido, quien posee un comportamiento obsesivo y sobreprotector.", "+16", "el_hijo");
        insertMovie(context, "Entre la razón y la locura", "El profesor James Murray comienza a recopilar palabras para la primera edición del Oxford English Dictionary a mitad del siglo XIX.", "+13", "entre_la_razon_y_la_locura");
        insertMovie(context, "Guason", "Una serie de trágicos sucesos harán que Arthur Fleck distorsione considerablemente su visión del mundo convirtiéndolo en un brillante criminal.", "+18", "guason");
        insertMovie(context, "La llorona", "Los Ángeles, década de 1970. Un legendario fantasma que se oculta en la oscuridad de la noche aterra a los niños.", "+16", "la_llorona");
        insertMovie(context, "Shazam", "Billy Batson, un astuto joven de 14 años, se transforma en el superhéroe Shazam, pero sus poderes son puestos a prueba cuando se enfrenta al mal.", "+13", "shazam");
    }

    public MovieModel getMovie(Context context, int id) {
        MovieModel movieModel = null;
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor res = db.rawQuery( "select " + DatabaseHelper.getColId() + ", " + DatabaseHelper.getColTitulo()
                + ", " + DatabaseHelper.getColSinopsis()
                + ", " + DatabaseHelper.getColEdad() + ", " + DatabaseHelper.getColRutaImg()
                + " from "+ DatabaseHelper.getDatabaseTableMovies() + " where "
                + DatabaseHelper.getColId() + " = '" + id + "'", null );
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
        Cursor res = db.rawQuery( "select " + DatabaseHelper.getColId() + ", " + DatabaseHelper.getColTitulo()
                + ", " + DatabaseHelper.getColSinopsis()
                + ", " + DatabaseHelper.getColEdad() + ", " + DatabaseHelper.getColRutaImg()
                + " from "+ DatabaseHelper.getDatabaseTableMovies(), null ); //agregar where validando fecha vigencia
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

    public String getNameMovie(Context context, int id) {
        String nameMovie = null;
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor res = db.rawQuery( "select " + DatabaseHelper.getColTitulo()
                + " from "+ DatabaseHelper.getDatabaseTableMovies() + " where "
                + DatabaseHelper.getColId() + " = '" + id + "'", null );
        if(res.getCount() > 0){
            res.moveToFirst();
                nameMovie = res.getString(0);
        }
        res.close();
        return nameMovie;
    }
}
