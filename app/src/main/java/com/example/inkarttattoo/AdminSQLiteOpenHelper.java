package com.example.inkarttattoo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static final String tablaUsuarios = "usuarios";

    private static final String cEmail = "email";
    private static final String cNombre = "nombre_usuario";
    private static final String cPassword = "password";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + tablaUsuarios + "("
                + cEmail + " VARCHAR(50) PRIMARY KEY," + cNombre + " varchar(20),"
                + cPassword + " varchar(20)" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
