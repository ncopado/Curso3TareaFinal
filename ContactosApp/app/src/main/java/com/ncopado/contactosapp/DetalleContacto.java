package com.ncopado.contactosapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    TextView tvNameConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("nombre");

        tvNameConfirm=(TextView) findViewById(R.id.tvNameConfirm);

        tvNameConfirm.setText(nombre);
    }
}
