package com.example.dlanor.proyectotda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Aplicacion extends AppCompatActivity {
Button ingre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplicacion);

        ingre=(Button)findViewById(R.id.btingre);
        ingre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Aplicacion.this,InicioSesion.class);
                startActivity(i);
                finish();
            }
        });
    }

}
