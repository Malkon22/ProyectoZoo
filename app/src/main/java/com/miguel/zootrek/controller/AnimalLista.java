package com.miguel.zootrek.controller;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.miguel.zootrek.model.Animal;
import com.miguel.zootrek.model.ManagerDb;
import com.miguel.zootrek.R;
import java.util.ArrayList;

public class AnimalLista extends AppCompatActivity {
    EditText etNombreAnimal, etEspecie, etComida, etFrecuencia, etHabitat;
    Button btnAgregar, btnVerLista;
    TextView tvResultado;
    ListView lvAnimales;

    ArrayAdapter<String> adapter;
    ArrayList<String> textoAnimales = new ArrayList<>();

    ManagerDb managerDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animallista);

        etNombreAnimal = findViewById(R.id.etNombreAnimal);
        etEspecie = findViewById(R.id.etEspecie);
        etComida = findViewById(R.id.etComida);
        etFrecuencia = findViewById(R.id.etFrecuencia);
        etHabitat = findViewById(R.id.etHabitat);
        btnAgregar = findViewById(R.id.btnGuardar);
        btnVerLista = findViewById(R.id.btnVerAnimales);
        tvResultado = findViewById(R.id.tvMensaje);
        lvAnimales = findViewById(R.id.lvAnimales);

        managerDb = new ManagerDb(this);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, textoAnimales);
        lvAnimales.setAdapter(adapter);

        btnAgregar.setOnClickListener(v -> {
            String nombre = etNombreAnimal.getText().toString();
            String especie = etEspecie.getText().toString();
            String comida = etComida.getText().toString();
            String frecuencia = etFrecuencia.getText().toString();
            String habitat = etHabitat.getText().toString();

            if (nombre.isEmpty() || especie.isEmpty() || comida.isEmpty() || frecuencia.isEmpty() || habitat.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            Animal animal = new Animal(frecuencia,nombre, especie, comida, habitat);
            long resultado = managerDb.insertAdministrador(animal);

            if (resultado > 0) {
                Toast.makeText(this, "Animal guardado", Toast.LENGTH_SHORT).show();
                actualizarLista();
            } else {
                Toast.makeText(this, "Error al guardar", Toast.LENGTH_SHORT).show();
            }

            etNombreAnimal.setText("");
            etEspecie.setText("");
            etComida.setText("");
            etFrecuencia.setText("");
            etHabitat.setText("");
        });

        btnVerLista.setOnClickListener(v -> actualizarLista());
    }

    private void actualizarLista() {
        textoAnimales.clear();
        for (Animal a : managerDb.listarAnimales()) {
            textoAnimales.add(a.toString());
        }
        adapter.notifyDataSetChanged();

        tvResultado.setText("Total de animales: " + textoAnimales.size());
    }
}
