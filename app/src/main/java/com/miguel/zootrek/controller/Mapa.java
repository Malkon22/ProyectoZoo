package com.miguel.zootrek.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.miguel.zootrek.R;

public class Mapa extends AppCompatActivity {
    Button btnubicacion, btntiendas, btnrestaurantes, btnbaños;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa);
        btnubicacion = findViewById(R.id.btniniciarsesion7);
        btnrestaurantes = findViewById(R.id.btniniciarsesion8);
        btntiendas = findViewById(R.id.btniniciarsesion9);
        btnbaños = findViewById(R.id.btniniciarsesion10);

        btnubicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irsiguiente = new Intent(Mapa.this, UbicacionAnimales.class);
                startActivity(irsiguiente);
            }
        });
        btnrestaurantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irsiguiente = new Intent(Mapa.this, Restaurantes.class);
                startActivity(irsiguiente);
            }
        });

        btntiendas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irsiguiente = new Intent(Mapa.this, Tiendas.class);
                startActivity(irsiguiente);
            }
        });

        btnbaños.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irsiguiente = new Intent(Mapa.this, Banos.class);
                startActivity(irsiguiente);
            }
        });
    }
}
