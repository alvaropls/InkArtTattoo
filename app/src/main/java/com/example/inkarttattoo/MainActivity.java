package com.example.inkarttattoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText log_correo, log_clave;
    Button btn_log;
    String[] datosAdmin = {"admin@inkart.com", "admin", "admin"};
    String[] datosNormal = {"pleb@pleb.com", "pleb", "1234"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        log_correo = findViewById(R.id.et_email);
        log_clave = findViewById(R.id.et_password);
        btn_log = findViewById(R.id.btn_login);

        datosPorDefecto(datosAdmin);
        datosPorDefecto(datosNormal);

    }

    public void logear(View v){
        Intent i;
        AdminSQLiteOpenHelper adminSQLiteOpenHelper = new AdminSQLiteOpenHelper(this, "usuarios", null, 1);
        SQLiteDatabase sqLiteDatabase = adminSQLiteOpenHelper.getWritableDatabase();
        String email = log_correo.getText().toString();
        String clave = log_clave.getText().toString();
        Cursor fila = sqLiteDatabase.rawQuery("SELECT password, nombre_usuario FROM usuarios WHERE email = '" + email + "'", null);
        String nombreUsuario = "";
        String contraUsuario = "";
        if(fila.moveToFirst()){
            contraUsuario = fila.getString(0);
            nombreUsuario = fila.getString(1);
        }
        if(email.equals("admin@inkart.com") && clave.equals(contraUsuario)){
            i = new Intent(this, AdminUser.class);
            startActivity(i);
        }
        if(!email.equals("admin@inkart.com") && !email.equals("") && clave.equals(contraUsuario)){
            i = new Intent(this, NormalUser.class);
            i.putExtra("nombre_usuario", nombreUsuario);
            startActivity(i);
        }
        sqLiteDatabase.close();
    }

    public void datosPorDefecto(String[] datos){
        AdminSQLiteOpenHelper adminSQLiteOpenHelper = new AdminSQLiteOpenHelper(this, "usuarios", null, 1);
        SQLiteDatabase sqLiteDatabase = adminSQLiteOpenHelper.getWritableDatabase();

        ContentValues contenido = new ContentValues();
        contenido.put("email", datos[0]);
        contenido.put("nombre_usuario", datos[1]);
        contenido.put("password", datos[2]);

        sqLiteDatabase.insert("usuarios", null, contenido);
        sqLiteDatabase.close();
    }

    public void irRegistro(View v){
        Intent irReg = new Intent(this, ActRegistro.class);
        startActivity(irReg);
    }
}