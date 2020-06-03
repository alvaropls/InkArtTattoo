package com.example.inkarttattoo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NormalUser extends AppCompatActivity {

    TextView bienvenidopleb;
    ImageView tattoo;
    Button pideCita, volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_user);

        bienvenidopleb = findViewById(R.id.textView_PlebUser);
        tattoo = findViewById(R.id.iv_tattoo);
        pideCita = findViewById(R.id.btn_pedirCitaMenu);
        volver = findViewById(R.id.bt_volverMenu);
    }

    public void irMenuCita(View view){
        Intent i = new Intent(this, MenuPedirCita.class);
        startActivity(i);
    }

    public void volver(View v){
        Intent irAtras = new Intent(this, MainActivity.class);
        startActivity(irAtras);
    }
}