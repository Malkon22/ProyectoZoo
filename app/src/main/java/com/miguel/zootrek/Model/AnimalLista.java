package com.miguel.zootrek.Model;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.miguel.zootrek.R;
import java.util.ArrayList;

public class AnimalLista extends AppCompatActivity {
    EditText etNombreAnimal, etEspecie, etComida, etFrecuencia, etHabitat;
    Button btnAgregar, btnContContar;
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
        btnContContar = findViewById(R.id.btnVerAnimales);
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

            Animal animal = new Animal(nombre, especie, comida, frecuencia, habitat);
            long resul = managerDb.insertAdministrador(animal);

            if (resul > 0) {
                Toast.makeText(this, "Animal insertado correctamente", Toast.LENGTH_SHORT).show();
                textoAnimales.clear();
                for (Animal a : managerDb.listarAnimales()) {
                    textoAnimales.add(a.toString());
                }
                adapter.notifyDataSetChanged();
            } else {
                Toast.makeText(this, "Error al insertar animal", Toast.LENGTH_SHORT).show();
            }

            etNombreAnimal.setText("");
            etEspecie.setText("");
            etComida.setText("");
            etFrecuencia.setText("");
            etHabitat.setText("");
        });

        btnContContar.setOnClickListener(v -> {
            int total = managerDb.listarAnimales().size();
            tvResultado.setText("Total de animales registrados: " + total);
        });
    }
}
