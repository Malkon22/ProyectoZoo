package com.miguel.zootrek.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.miguel.zootrek.Model.MenuInicio;
import com.miguel.zootrek.R;

public class Inicio extends AppCompatActivity {
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        btnNext = findViewById(R.id.btnSiguiente);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irsiguiente = new Intent(Inicio.this, MenuInicio.class);
                startActivity(irsiguiente);

            }
        });



    }
}