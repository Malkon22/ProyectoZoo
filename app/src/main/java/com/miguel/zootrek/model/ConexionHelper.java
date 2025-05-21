package com.miguel.zootrek.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionHelper extends SQLiteOpenHelper {

    public ConexionHelper(Context context) {
        super(context, Constantes.NOM_BD, null, Constantes.VERSION_BD);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Administrador");
        db.execSQL("DROP TABLE IF EXISTS Personal");
        onCreate(db);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constantes.SENTENCIATABLA);
        db.execSQL(Constantes.SENTENCIAPERSONAL);

    }
}
