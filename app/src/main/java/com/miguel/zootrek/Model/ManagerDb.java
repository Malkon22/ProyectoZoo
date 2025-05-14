package com.miguel.zootrek.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.miguel.zootrek.Empleado;

import java.util.ArrayList;

public class ManagerDb {

    ConexionHelper conexionHelper;
    SQLiteDatabase db;

    public ManagerDb(Context context) {
        conexionHelper = new ConexionHelper(context);
    }

    public void openBdWr() {
        db = conexionHelper.getWritableDatabase();
    }

    public void openBdRd() {
        db = conexionHelper.getReadableDatabase();
    }

    public long insertAdministrador(Animal animal) {
        openBdWr();
        ContentValues values = new ContentValues();
        values.put("nombre", animal.getNombre());
        values.put("especie", animal.getEspecie());
        values.put("comida", animal.getComida());
        values.put("frecuencia", animal.getFrecuencia());
        values.put("habitat", animal.getHabitat());

        Log.d("DB_INSERT", "Insertando animal: " + animal.toString());
        long result = db.insert("Administrador", null, values);
        if (result == -1) {
            Log.e("DB_ERROR", "Error al insertar animal: " + animal.toString());
        }
        db.close();
        return result;
    }

    public ArrayList<Animal> listarAnimales() {
        openBdRd();
        ArrayList<Animal> lista = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM Administrador", null);

        if (cursor.moveToFirst()) {
            do {
                String nombre = cursor.getString(0);
                String especie = cursor.getString(1);
                String comida = cursor.getString(2);
                String frecuencia = cursor.getString(3);
                String habitat = cursor.getString(4);

                Animal animal = new Animal(nombre, especie, comida, frecuencia, habitat);
                lista.add(animal);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return lista;
    }
    public long insertPersonal(Empleado empleado) {
        openBdWr();
        ContentValues values = new ContentValues();
        values.put("nombre", empleado.getNombre());
        values.put("cargo", empleado.getCargo());
        values.put("turno", empleado.getTurno());
        values.put("telefono", empleado.getTelefono());

        long result = db.insert("Personal", null, values);
        db.close();
        return result;
    }

    public ArrayList<Empleado> listarPersonal() {
        openBdRd();
        ArrayList<Empleado> lista = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM Personal", null);

        if (cursor.moveToFirst()) {
            do {
                String nombre = cursor.getString(0);
                String cargo = cursor.getString(1);
                String turno = cursor.getString(2);
                String telefono = cursor.getString(3);

                Empleado empleado = new Empleado(nombre, cargo, turno, telefono);
                lista.add(empleado);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return lista;
    }

}
