package com.miguel.zootrek.Model;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.miguel.zootrek.R;

public class Menu extends AppCompatActivity {
    Button btnNext;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        btnNext = findViewById(R.id.btniniciarsesion3);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irsiguiente = new Intent(Menu.this, Mapa.class);
                startActivity(irsiguiente);

            }
        });

        btnNext = findViewById(R.id.btnvolver2);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(Menu.this, MenuInicio.class);
                startActivity(volver);
    }
});
        btnNext = findViewById(R.id.btniniciarsesion4);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irsiguiente = new Intent(Menu.this, Complementos.class);
                startActivity(irsiguiente);
            }
            });
        btnNext = findViewById(R.id.btniniciarsesion5);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irsiguiente = new Intent(Menu.this, MetodosCompra.class);
                startActivity(irsiguiente);
            }
        });
        btnNext = findViewById(R.id.btniniciarsesion6);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irsiguiente = new Intent(Menu.this, Informacion.class);
                startActivity(irsiguiente);
            }
            });
    }
}