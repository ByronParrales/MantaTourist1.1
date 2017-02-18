package com.facci.manta_tourist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class Comentario extends AppCompatActivity {
    Button btnComent;
    EditText etmail, et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentario);

        btnComent = (Button)findViewById(R.id.btnComent);
        et1 = (EditText)findViewById(R.id.et1);
        etmail = (EditText)findViewById(R.id.etEmail);

        btnComent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent0 = new Intent(Comentario.this, Explorar.class);
                startActivity(intent0);
            }
        });
    }
}
