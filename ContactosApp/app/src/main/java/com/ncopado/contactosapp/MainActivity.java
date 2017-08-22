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
    // private  TextInputEditText tvDate;
    private  TextInputEditText tvPhone;
    private  TextInputEditText tvEmail;
    private  TextInputEditText tvDesc;
    private DatePicker tvDate ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        Button btn=(Button) findViewById(R.id.btnNext);
        tvName=(TextInputEditText)  findViewById(R.id.tvName);
        tvDate= (DatePicker) findViewById(R.id.datePicker);
        tvPhone=(TextInputEditText)  findViewById(R.id.tvPhone);
        tvEmail=(TextInputEditText)  findViewById(R.id.tvEmail);
        tvDesc=(TextInputEditText)  findViewById(R.id.tvDesc);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 int day = tvDate.getDayOfMonth();
                 int month = tvDate.getMonth() + 1;
                 int year = tvDate.getYear();


                Intent intent=new Intent(MainActivity.this,DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre),tvName.getText().toString().trim());
                intent.putExtra(getResources().getString(R.string.pfecha), day +"/" + month + "/"+year);
                intent.putExtra(getResources().getString(R.string.ptel),tvPhone.getText().toString().trim());
                intent.putExtra(getResources().getString(R.string.pcorreo),tvEmail.getText().toString().trim());
                intent.putExtra(getResources().getString(R.string.pdesc),tvDesc.getText().toString().trim());
                startActivity(intent);
                finish();
            }
        });



      Bundle bundle = getIntent().getExtras();

        if(bundle !=null){
        String nombre = bundle.getString(getResources().getString(R.string.pnombre));
        String fecha = bundle.getString(getResources().getString(R.string.pfecha));
        String tel = bundle.getString(getResources().getString(R.string.ptel));
        String correo = bundle.getString(getResources().getString(R.string.pcorreo));
        String desc = bundle.getString(getResources().getString(R.string.pdesc));

        tvName=(TextInputEditText) findViewById(R.id.tvName);
        tvName.setText(nombre);


        String[] parts = fecha.split("/");
        tvDate.updateDate(Integer.parseInt(parts[2]), (Integer.parseInt(parts[1]) - 1), Integer.parseInt(parts[0]));



        tvPhone=(TextInputEditText) findViewById(R.id.tvPhone);
        tvPhone.setText(tel);

        tvEmail=(TextInputEditText) findViewById(R.id.tvEmail);
        tvEmail.setText(correo);

        tvDesc=(TextInputEditText) findViewById(R.id.tvDesc);
        tvDesc.setText(desc);

        }

    }



}
