package com.facci.manta_tourist;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {

    Button btnIniciar,btnRegistrar;
    TextView tvIniciar;
    EditText etNombre, etContraseña;
    CheckBox cbdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


        btnIniciar = (Button)findViewById(R.id.btnIniciar);
        btnRegistrar = (Button)findViewById(R.id.btnRegistrar);
        tvIniciar = (TextView)findViewById(R.id.tvIniciar);
        etNombre = (EditText)findViewById(R.id.etNombre);
        etContraseña = (EditText)findViewById(R.id.etContraseña);
        cbdata =(CheckBox)findViewById(R.id.cbdata);




    }

    public void iniciar (View view){
        Intent iniciarintent = new Intent(Inicio.this, Explorar.class);
        startActivity(iniciarintent);
    }
    public void facebook (View view){
        Intent facebookintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
        startActivity(facebookintent);
    }
    public void browser (View view){
        Intent browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gmail.com"));
        startActivity(browserintent);
    }

    public void Registrar (View view){
        Intent registrar = new Intent(Inicio.this, Registrar.class);
        startActivity(registrar);
    }
}
