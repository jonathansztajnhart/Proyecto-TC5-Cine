package com.jnj.cinepop.models;

public class FuncionModel {

        private int id;
        private int idPelicula;
        private String fecha;
        private String hora;
        private int idSucursal;
        private int tipoFuncion;
        private String idioma;

    public FuncionModel(int id, int idPelicula, String fecha, String hora, int idSucursal, int tipoFuncion, String idioma) {
        this.id = id;
        this.idPelicula = idPelicula;
        this.fecha = fecha;
        this.hora = hora;
        this.idSucursal = idSucursal;
        this.tipoFuncion = tipoFuncion;
        this.idioma = idioma;
    }

    public int getId() {
        return id;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public int getTipoFuncion() {
        return tipoFuncion;
    }

    public String getIdioma() {
        return idioma;
    }
}



