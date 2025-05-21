package com.miguel.zootrek.controller;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.miguel.zootrek.model.Animal;
import com.miguel.zootrek.model.ManagerDb;
import com.miguel.zootrek.R;

import java.util.ArrayList;

public class ListarDatos extends AppCompatActivity {

    ListView listView;
    ArrayList<Animal> listaAnimal;
    ArrayAdapter<String> adapter;
    ManagerDb managerDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listardatos);

        listView = findViewById(R.id.lvAnimales);

        managerDb = new ManagerDb(this);
        listaAnimal = managerDb.listarAnimales();

        ArrayList<String> textoAnimales = new ArrayList<>();
        for (Animal animal : listaAnimal) {
            textoAnimales.add(animal.toString());
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, textoAnimales);
        listView.setAdapter(adapter);
    }
}