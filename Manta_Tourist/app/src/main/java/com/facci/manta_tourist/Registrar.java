package com.facci.manta_tourist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Registrar extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnEnviarReg;
    TextView tvCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);


        etEmail = (EditText)findViewById(R.id.etEmail);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnEnviarReg = (Button)findViewById(R.id.btnEnviarReg);
        tvCuenta = (TextView)findViewById(R.id.tvCuenta);


        btnEnviarReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Registrar.this, Inicio.class);
                startActivity(intent2);
            }
        });



    }
}
