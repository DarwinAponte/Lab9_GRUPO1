package com.example.lab9_grupo1.beans;

public class Paises {
    private String nombre_pais;
    private String continente;
    private String poblacion;
    private double tamano_pais;

    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public double getTamano_pais() {
        return tamano_pais;
    }

    public void setTamano_pais(double tamano_pais) {
        this.tamano_pais = tamano_pais;
    }
}
