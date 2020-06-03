package com.example.inkarttattoo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuPedirCita extends AppCompatActivity {

    TextView titulo, subtitulo;
    EditText size, design, tlfn, zona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pedir_cita);

        titulo = findViewById(R.id.tv_tituloPedirCita);
        subtitulo = findViewById(R.id.tv_subtitle);
        size = findViewById(R.id.et_tamanoTattoo);
        design = findViewById(R.id.et_descripTattoo);
        tlfn = findViewById(R.id.et_phone);
        zona = findViewById(R.id.et_zonaTatuar);
    }

    public void confirmar(View v){
        String telef = tlfn.getText().toString();
        String zona_Confirmado = zona.getText().toString();
        String size_Confirmado = size.getText().toString();
        String design_Confirmado = design.getText().toString();


        if(telef.length()<=0){
            Toast.makeText(this, "Por favor, rellene todos los campos", Toast.LENGTH_LONG).show();
        }
        else if(zona_Confirmado.length()<=0){
            Toast.makeText(this, "Por favor, rellene todos los campos", Toast.LENGTH_LONG).show();
        }
        else if(size_Confirmado.length()<=0){
            Toast.makeText(this, "Por favor, rellene todos los campos", Toast.LENGTH_LONG).show();
        }
        else if(design_Confirmado.length()<=0){
            Toast.makeText(this, "Por favor, rellene todos los campos", Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(this, ResumenDatos.class);
            i.putExtra("tel", telef);
            i.putExtra("zona", zona_Confirmado);
            i.putExtra("tamano", size_Confirmado);
            i.putExtra("diseno", design_Confirmado);
            startActivity(i);
        }

    }
}