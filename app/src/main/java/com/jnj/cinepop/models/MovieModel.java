package com.jnj.cinepop.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovieModel {

        private int id;
        private String titulo;
        private String sinopsis;
        private String edad;
        private String rutaImg;
        private int idDrawable;

    public MovieModel(int id, String titulo, String sinopsis, String edad, String rutaImg) {
        this.id = id;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.edad = edad;
        this.rutaImg = rutaImg;
    }

    public MovieModel(int id, String titulo, String sinopsis, String edad, int idDrawable) {
        this.id = id;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.edad = edad;
        this.idDrawable = idDrawable;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getEdad() {
        return edad;
    }

    public String getRutaImg() {
        return rutaImg;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public void setIdDrawable(int idDrawable) {
        this.idDrawable = idDrawable;
    }
}



