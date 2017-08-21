package com.ncopado.contactosapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;


public class MainActivity extends AppCompatActivity {

    private  DatePickerDialog.OnDateSetListener dlg;
    private TextInputEditText txt;
    private TextInputEditText tvName;
    private  TextInputEditText tvDate;
    private  TextInputEditText tvPhone;
    private  TextInputEditText tvEmail;
    private  TextInputEditText tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=(TextInputEditText) findViewById(R.id.tvDate);

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog =new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,dlg
                        ,year,month,day);

                dialog.show();



            }
        });




        dlg =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String date=day +"/"+month + "/" + year;
                txt.setText(date);
            }
        };

        Button btn=(Button) findViewById(R.id.btnNext);
        tvName=(TextInputEditText)  findViewById(R.id.tvName);
        tvDate=(TextInputEditText)  findViewById(R.id.tvDate);
        tvPhone=(TextInputEditText)  findViewById(R.id.tvPhone);
        tvEmail=(TextInputEditText)  findViewById(R.id.tvEmail);
        tvDesc=(TextInputEditText)  findViewById(R.id.tvDesc);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DetalleContacto.class);
                intent.putExtra("nombre",tvName.getText().toString().trim());
                intent.putExtra("fecha", tvDate.getText().toString().trim());
                intent.putExtra("tel",tvPhone.getText().toString().trim());
                intent.putExtra("correo",tvEmail.getText().toString().trim());
                intent.putExtra("desc",tvDesc.getText().toString().trim());
                startActivity(intent);
                finish();
            }
        });



      Bundle bundle = getIntent().getExtras();

        if(bundle !=null){
        String nombre = bundle.getString("nombre");
        String fecha = bundle.getString("fecha");
        String tel = bundle.getString("tel");
        String correo = bundle.getString("correo");
        String desc = bundle.getString("desc");

        tvName=(TextInputEditText) findViewById(R.id.tvName);
        tvName.setText(nombre);

        tvDate=(TextInputEditText) findViewById(R.id.tvDate);
        tvDate.setText(fecha);

        tvPhone=(TextInputEditText) findViewById(R.id.tvPhone);
        tvPhone.setText(tel);

        tvEmail=(TextInputEditText) findViewById(R.id.tvEmail);
        tvEmail.setText(correo);

        tvDesc=(TextInputEditText) findViewById(R.id.tvDesc);
        tvDesc.setText(desc);

        }

    }



}
