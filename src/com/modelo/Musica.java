package com.modelo;

import java.util.Date;

public class Musica {

    private int idregistromusica;
    private String titulo;
    private String artista;
    private String album;
    private Date año_creacion;
    private String genero;
    private Date fecha_registro;

    public int getIdregistromusica() {
        return idregistromusica;
    }

    public void setIdregistromusica(int idregistromusica) {
        this.idregistromusica = idregistromusica;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Date getAño_creacion() {
        return año_creacion;
    }

    public void setAño_creacion(Date año_creacion) {
        this.año_creacion = año_creacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

}
