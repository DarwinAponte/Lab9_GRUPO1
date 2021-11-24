package com.example.lab9_grupo1.beans;

public class Universidades {
    private String nombre_universidad;
    private String pais_universidad;
    private int ranking;
    private int numero_alumnos;
    private String foto_universidad;

    public String getNombre_universidad() {
        return nombre_universidad;
    }

    public void setNombre_universidad(String nombre_universidad) {
        this.nombre_universidad = nombre_universidad;
    }

    public String getPais_universidad() {
        return pais_universidad;
    }

    public void setPais_universidad(String pais_universidad) {
        this.pais_universidad = pais_universidad;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getNumero_alumnos() {
        return numero_alumnos;
    }

    public void setNumero_alumnos(int numero_alumnos) {
        this.numero_alumnos = numero_alumnos;
    }

    public String getFoto_universidad() {
        return foto_universidad;
    }

    public void setFoto_universidad(String foto_universidad) {
        this.foto_universidad = foto_universidad;
    }
}
