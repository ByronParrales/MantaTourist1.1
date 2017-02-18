package com.facci.manta_tourist;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SqLite extends AppCompatActivity {
    EditText etId, etlugar, etdireccion;
    Button   btnGuardar, btnActualizar, btnEliminar, btnBuscar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq_lite);

        btnGuardar = (Button)findViewById(R.id.btnGuardar);
        btnBuscar = (Button)findViewById(R.id.btnBuscar);
        btnActualizar = (Button)findViewById(R.id.btnActualizar);
        btnEliminar = (Button)findViewById(R.id.btnEliminar);


        etId = (EditText)findViewById(R.id.etId);
        etdireccion = (EditText)findViewById(R.id.etdireccion);
        etlugar = (EditText)findViewById(R.id.etlugar);

        final AyudaBD ayudabd = new AyudaBD (getApplicationContext());


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = ayudabd.getWritableDatabase();
                ContentValues valores = new ContentValues();
                valores.put(AyudaBD.DatosTabla.Columna_Id,etId.getText().toString());
                valores.put(AyudaBD.DatosTabla.Columna_N_lugar,etlugar.getText().toString());
                valores.put(AyudaBD.DatosTabla.Columna_Direccion,etdireccion.getText().toString());

                Long IdGuardado = db.insert(AyudaBD.DatosTabla.Nombre_Tabla, AyudaBD.DatosTabla.Columna_Id, valores);
                Toast.makeText(getApplicationContext(), "Se guardo el dato: "+IdGuardado, Toast.LENGTH_LONG).show();

            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = ayudabd.getWritableDatabase();
                String Selection = AyudaBD.DatosTabla.Columna_Id+"=?";
                String [] argsel = {etId.getText().toString()};

                db.delete(AyudaBD.DatosTabla.Nombre_Tabla, Selection,argsel);



            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = ayudabd.getReadableDatabase();
                String [] argsel = {etId.getText().toString()};
                String [] projection = {AyudaBD.DatosTabla.Columna_N_lugar, AyudaBD.DatosTabla.Columna_Direccion};
                Cursor c = db.query(AyudaBD.DatosTabla.Nombre_Tabla, projection, AyudaBD.DatosTabla.Columna_Id+"=?",argsel,null,null,null);

                c.moveToFirst();
                etlugar.setText(c.getString(0));
                etdireccion.setText(c.getString(1));
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = ayudabd.getWritableDatabase();
                ContentValues valores = new ContentValues();
                valores.put(AyudaBD.DatosTabla.Columna_N_lugar, etlugar.getText().toString());
                valores.put(AyudaBD.DatosTabla.Columna_Direccion, etdireccion.getText().toString());
                String [] argsel = {etId.getText().toString()};
                String Selection = AyudaBD.DatosTabla.Columna_Id+"=?";

                int count = db.update(AyudaBD.DatosTabla.Nombre_Tabla, valores,Selection,argsel);

            }
        });


    }
}
