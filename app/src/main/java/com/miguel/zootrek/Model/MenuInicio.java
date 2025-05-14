package com.miguel.zootrek.Model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.miguel.zootrek.Controller.Inicio;
import com.miguel.zootrek.R;

public class MenuInicio extends AppCompatActivity {
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuinicio);
        btnNext = findViewById(R.id.btniniciarsesion2);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irsiguiente = new Intent(MenuInicio.this, Menu.class);
                startActivity(irsiguiente);

            }
        });
                btnNext = findViewById(R.id.btnvolver1);
                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent volver = new Intent(MenuInicio.this, Inicio.class);
                        startActivity(volver);
                    }
                });
        btnNext = findViewById(R.id.btniniciarsesion1);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(MenuInicio.this, IniciarSesion.class);
                startActivity(volver);
            }
        });
    }
}
