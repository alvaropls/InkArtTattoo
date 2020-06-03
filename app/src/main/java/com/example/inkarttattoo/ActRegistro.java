package com.example.inkarttattoo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActRegistro extends AppCompatActivity {

    EditText nombre, correo, pass, repass;
    Button btn_regis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_registro);

        nombre = findViewById(R.id.et_name);
        correo = findViewById(R.id.et_email);
        pass = findViewById(R.id.et_password);
        repass = findViewById(R.id.et_repassword);
        btn_regis = findViewById(R.id.btn_register);
    }

    public void irLogin(View v){
        Intent irLog = new Intent(this, MainActivity.class);
        startActivity(irLog);
    }

    public void insertar(View v){
        Intent irUser;
        AdminSQLiteOpenHelper adminSQLiteOpenHelper = new AdminSQLiteOpenHelper(this, "usuarios", null, 1);
        SQLiteDatabase sqLiteDatabase = adminSQLiteOpenHelper.getWritableDatabase();
        String email = correo.getText().toString();
        String name = nombre.getText().toString();
        String clave = pass.getText().toString();
        String re_clave = repass.getText().toString();

        if(email.length()<=0){
            Toast.makeText(this, "Por favor, rellene todos los campos", Toast.LENGTH_LONG).show();
        } else if (name.length()<=0){
            Toast.makeText(this, "Por favor, rellene todos los campos", Toast.LENGTH_LONG).show();
        } else if (clave.length()<=0){
            Toast.makeText(this, "Por favor, rellene todos los campos", Toast.LENGTH_LONG).show();
        } else if (re_clave.length()<=0){
            Toast.makeText(this, "Por favor, rellene todos los campos", Toast.LENGTH_LONG).show();
        } else {
            if(clave.equals(re_clave)==true){
                ContentValues contenido = new ContentValues();
                contenido.put("email", email);
                contenido.put("nombre_usuario", name);
                contenido.put("password", clave);

                sqLiteDatabase.insert("usuarios", null, contenido);
                sqLiteDatabase.close();

                irUser = new Intent(this, NormalUser.class);
                startActivity(irUser);
            } else {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
            }
        }

    }


}