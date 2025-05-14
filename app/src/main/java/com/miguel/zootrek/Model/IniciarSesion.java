package com.miguel.zootrek.Model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.miguel.zootrek.R;

public class IniciarSesion extends AppCompatActivity {
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciarsesion);
        btnNext = findViewById(R.id.btnsiguiente22);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irsiguiente = new Intent(IniciarSesion.this, AnimalInterfaz.class);
                startActivity(irsiguiente);

            }
        });



    }
}