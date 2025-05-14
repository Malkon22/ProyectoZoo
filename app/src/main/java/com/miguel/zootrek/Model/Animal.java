package com.miguel.zootrek.Model;

import java.io.Serializable;

public class Animal implements Serializable {
    private String nombre;
    private String especie;
    private String comida;
    private String frecuencia;
    private String habitat;

    public Animal(String nombre, String especie, String comida, String frecuencia, String habitat) {
        this.nombre = nombre;
        this.especie = especie;
        this.comida = comida;
        this.frecuencia = frecuencia;
        this.habitat = habitat;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public String getComida() {
        return comida;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public String getHabitat() {
        return habitat;
    }

    @Override
    public String toString() {
        return nombre + " (" + especie + ") | Comida: " + comida +
                " | Cada: " + frecuencia + " | Hábitat: " + habitat;
    }
}
