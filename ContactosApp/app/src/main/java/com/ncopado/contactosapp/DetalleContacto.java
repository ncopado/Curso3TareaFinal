package com.ncopado.contactosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    TextView tvNameConfirm;
    TextView tvDay;
    TextView tvPhone;
    TextView tvEmail;
    TextView tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("nombre");
        String fecha = bundle.getString("fecha");
        String tel = bundle.getString("tel");
        String correo = bundle.getString("correo");
        String desc = bundle.getString("desc");




        tvNameConfirm=(TextView) findViewById(R.id.tvNameConfirm);
        tvNameConfirm.setText(nombre);

        tvDay=(TextView) findViewById(R.id.tvDay);
        tvDay.setText(fecha);

        tvPhone=(TextView) findViewById(R.id.tvPhone);
        tvPhone.setText(tel);

        tvEmail=(TextView) findViewById(R.id.tvEmail);
        tvEmail.setText(correo);

        tvDesc=(TextView) findViewById(R.id.tvDesc);
        tvDesc.setText(desc);


        Button btnEdit=(Button) findViewById(R.id.btnEdit);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(DetalleContacto.this,MainActivity.class);
                intent.putExtra("nombre",tvNameConfirm.getText().toString().trim());
                intent.putExtra("fecha", tvDay.getText().toString().trim());
                intent.putExtra("tel",tvPhone.getText().toString().trim());
                intent.putExtra("correo",tvEmail.getText().toString().trim());
                intent.putExtra("desc",tvDesc.getText().toString().trim());
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent=new Intent(DetalleContacto.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onKeyDown(keyCode, event);
    }
}
