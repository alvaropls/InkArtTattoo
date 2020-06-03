package com.example.inkarttattoo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResumenDatos extends AppCompatActivity {

    TextView resumen;
    Bundle datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_datos);

        resumen = findViewById(R.id.textView_ResumenDatos);

        datos = getIntent().getExtras();

        resumen.setText("Tu reserva ha sido completada. Este es el resumen de los datos introducidos: " +System.getProperty("line.separator")+ "Telefono:" +datos.getString("tel") +
                System.getProperty("line.separator") + "Zona: " +datos.getString("zona") + System.getProperty("line.separator")
                + "Tamaño: " + datos.getString("tamano") + System.getProperty("line.separator") + "Diseño: " + datos.getString("diseno") + System.getProperty("line.separator") +
                "Nos pondremos en contacto contigo para concretar la fecha con la mayor brevedad posible.");

    }

    public void volver (View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}