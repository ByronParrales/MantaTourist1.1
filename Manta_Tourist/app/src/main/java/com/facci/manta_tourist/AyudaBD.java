package com.facci.manta_tourist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Byron Parrales on 11/02/2017.
 */

public class AyudaBD extends SQLiteOpenHelper {
    public static class DatosTabla implements BaseColumns {
        public static final String Nombre_Tabla = "Lugares";
        public static final String Columna_Id = "Id";
        public static final String Columna_N_lugar = "Nombre del Lugar";
        public static final String Columna_Direccion = "Direccion";


        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";
        private static final String Crear_Tabla1 =
                "CREATE TABLE " + DatosTabla.Nombre_Tabla + " (" +
                        DatosTabla.Columna_Id + " INTEGER PRIMARY KEY," +
                        DatosTabla.Columna_N_lugar + TEXT_TYPE + COMMA_SEP +
                        DatosTabla.Columna_Direccion + TEXT_TYPE + " )";

        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + DatosTabla.Nombre_Tabla;
    }


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "BasedeDatosTurist.db";

    public AyudaBD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatosTabla.Crear_Tabla1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DatosTabla.SQL_DELETE_ENTRIES);
        onCreate(db);

    }
}
