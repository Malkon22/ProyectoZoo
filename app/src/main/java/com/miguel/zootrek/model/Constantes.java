package com.miguel.zootrek.model;

public class Constantes {
    public static final String NOM_BD = "zootrek.db";
    public static final int VERSION_BD = 4;
    public static final String SENTENCIATABLA = "CREATE TABLE Administrador (" +
            "nombre TEXT, " +
            "especie TEXT, " +
            "comida TEXT, " +
            "frecuencia TEXT, " +
            "habitat TEXT)";

    public static final String SENTENCIAPERSONAL = "CREATE TABLE Personal (" +
            "nombre TEXT, " +
            "cargo TEXT, " +
            "turno TEXT, " +
            "telefono TEXT)";
}