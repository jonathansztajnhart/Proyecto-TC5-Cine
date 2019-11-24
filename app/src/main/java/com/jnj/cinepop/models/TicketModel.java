package com.jnj.cinepop.models;

public class TicketModel {

        private int id;
        private String tituloPelicula;
        private String fechaFuncion;
        private String horaFuncion;
        private String tipoFuncion;
        private String idioma;
        private String sucursalFuncion;
        private int cantAsientos;
        private double precioFuncion;

    public TicketModel(int id, String tituloPelicula, String fechaFuncion, String horaFuncion,
                       String tipoFuncion, String idioma, String sucursalFuncion, int cantAsientos, double precioFuncion) {
        this.id = id;
        this.tituloPelicula = tituloPelicula;
        this.fechaFuncion = fechaFuncion;
        this.horaFuncion = horaFuncion;
        this.tipoFuncion = tipoFuncion;
        this.idioma = idioma;
        this.sucursalFuncion = sucursalFuncion;
        this.cantAsientos = cantAsientos;
        this.precioFuncion = precioFuncion;
    }

    public int getId() {
        return id;
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public String getFechaFuncion() {
        return fechaFuncion;
    }

    public String getHoraFuncion() {
        return horaFuncion;
    }

    public String getTipoFuncion() {
        return tipoFuncion;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getSucursalFuncion() {
        return sucursalFuncion;
    }

    public int getCantAsientos() {
        return cantAsientos;
    }

    public double getPrecioFuncion() {
        return precioFuncion;
    }
}



