package com.miguel.zootrek.model;

public class Empleado {

    private String nombre;
private String cargo;
 private String turno;
 private String telefono;

public Empleado(String nombre, String cargo, String turno, String telefono) {
 this.nombre = nombre;
 this.cargo = cargo;
this.turno = turno;
this.telefono = telefono;
}

public String getNombre() {
return nombre;
}

 public String getCargo() {
return cargo;
}

 public String getTurno() {
 return turno;
 }

public String getTelefono() {
 return telefono;
 }

 @Override
public String toString() {
return nombre + " | Cargo: " + cargo + " | Turno: " + turno + " | Tel: " + telefono;
}

}
