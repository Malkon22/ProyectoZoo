package com.miguel.zootrek.model;

public class Admin {
    private String nombre;
    private String cargo;
    private String turno;
    private String telefono;

    public Admin(String nombre, String cargo, String turno, String telefono) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.turno = turno;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " | Cargo: " + cargo +
                " | Turno: " + turno + " | Teléfono: " + telefono;
    }

}
