package com.facci.manta_tourist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class PrimeraPantalla extends AppCompatActivity {

    Button btnContinuar;
    TextView tvTitulo;
    TextView tvTitulo2;
    CheckBox checkBox1;
    CheckBox checkBox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_pantalla);


        btnContinuar = (Button)findViewById(R.id.btnContinuar);
        tvTitulo = (TextView)findViewById(R.id.tvTitulo);
        tvTitulo2 = (TextView)findViewById(R.id.tvTitulo2);
        checkBox1 = (CheckBox)findViewById(R.id.checkbox1);
        checkBox2 = (CheckBox)findViewById(R.id.checkbox2);

       btnContinuar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(PrimeraPantalla.this, Inicio.class);
               startActivity(intent);
           }
       });


        }
}
