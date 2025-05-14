package com.miguel.zootrek.Model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.miguel.zootrek.R;

public class MetodosCompra extends AppCompatActivity {
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metodoscompra);
        btnNext = findViewById(R.id.btnvolver5);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(MetodosCompra.this, Menu.class);
                startActivity(volver);

            }
        });
    }
}