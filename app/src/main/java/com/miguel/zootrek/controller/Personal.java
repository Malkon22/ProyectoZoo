package com.miguel.zootrek.controller;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.miguel.zootrek.model.Empleado;
import com.miguel.zootrek.model.ManagerDb;
import com.miguel.zootrek.R;
import java.util.ArrayList;

public class Personal extends AppCompatActivity {

    EditText etNombrePersonal, etCargo, etTurno, etTelefono;
    Button btnGuardarPersonal, btnVerPersonal;
    TextView tvMensajePersonal;
    ListView lvPersonal;

    ArrayAdapter<String> adapter;
    ArrayList<String> textoPersonal = new ArrayList<>();
    ManagerDb managerDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal);

        etNombrePersonal = findViewById(R.id.etNombrePersonal);
        etCargo = findViewById(R.id.etCargo);
        etTurno = findViewById(R.id.etTurno);
        etTelefono = findViewById(R.id.etTelefono);
        btnGuardarPersonal = findViewById(R.id.btnGuardarPersonal);
        btnVerPersonal = findViewById(R.id.btnVerPersonal);
        tvMensajePersonal = findViewById(R.id.tvMensajePersonal);
        lvPersonal = findViewById(R.id.lvPersonal);

        managerDb = new ManagerDb(this);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, textoPersonal);
        lvPersonal.setAdapter(adapter);

        btnGuardarPersonal.setOnClickListener(v -> {
            String nombre = etNombrePersonal.getText().toString();
            String cargo = etCargo.getText().toString();
            String turno = etTurno.getText().toString();
            String telefono = etTelefono.getText().toString();

            Empleado empleado = new Empleado(nombre, cargo, turno, telefono);
            long res = managerDb.insertPersonal(empleado);

            if (res > 0) {
                Toast.makeText(this, "Personal guardado correctamente", Toast.LENGTH_SHORT).show();
                textoPersonal.clear();
                for (Empleado e : managerDb.listarPersonal()) {
                    textoPersonal.add(e.toString());
                }
                adapter.notifyDataSetChanged();
            } else {
                Toast.makeText(this, "Error al guardar personal", Toast.LENGTH_SHORT).show();
            }

            etNombrePersonal.setText("");
            etCargo.setText("");
            etTurno.setText("");
            etTelefono.setText("");
        });

        btnVerPersonal.setOnClickListener(v -> {
            int total = managerDb.listarPersonal().size();
            tvMensajePersonal.setText("Total de personal registrado: " + total);
        });
    }
}