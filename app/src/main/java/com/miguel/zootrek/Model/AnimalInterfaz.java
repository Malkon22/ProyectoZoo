package com.miguel.zootrek.Model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.miguel.zootrek.R;

public class AnimalInterfaz extends AppCompatActivity {

    Button btnAnimales, btnPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animales);

        btnAnimales = findViewById(R.id.btnAnimales);
        btnAnimales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irsiguiente = new Intent(AnimalInterfaz.this, AnimalLista.class);
                startActivity(irsiguiente);
            }
        });

        btnPerson = findViewById(R.id.btnPerson);
        btnPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irsiguiente2 = new Intent(AnimalInterfaz.this, Personal.class);
                startActivity(irsiguiente2);
            }
        });

    }
}