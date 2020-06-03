package com.example.inkarttattoo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AdminUser extends AppCompatActivity {

    TextView titulo;
    Button bt_consulta, bt_volver;
    ListView lista;
    ArrayList<String> resultados = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user);

        titulo = findViewById(R.id.tv_adminUser);
        bt_consulta = findViewById(R.id.bt_consultarUser);
        bt_volver = findViewById(R.id.bt_volverMenu);
        lista = findViewById(R.id.listaConsulta);

        lista.setVisibility(View.GONE);

    }

    public void consultaBD (View v){
        lista.setVisibility(View.VISIBLE);
        AdminSQLiteOpenHelper adminSQLiteOpenHelper = new AdminSQLiteOpenHelper(this, "usuarios", null, 1);
        SQLiteDatabase sqLiteDatabase = adminSQLiteOpenHelper.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM  usuarios", null);
        if (cursor.moveToFirst()){
            do{
                resultados.add(cursor.getString(0) + " - " + cursor.getString(1) + " - " +cursor.getString(2));
            } while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resultados);
        lista.setAdapter(adapter);

    }

    public void volver (View v){
        Intent volver = new Intent(this, MainActivity.class);
        startActivity(volver);
    }
}