package com.example.dlanor.proyectotda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;

public class Edit_horario extends AppCompatActivity {
    int Ini=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_horario);


        final FloatingActionButton hor=(FloatingActionButton)findViewById(R.id.hor_1);
        hor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Ini==0){
                    hor.setTitle("Cargando...");
                    Ini=1;
                }else {
                    hor.setTitle("Horario");
                    Ini=0;
                }
                Intent i=new Intent(Edit_horario.this,Horario.class);
                startActivity(i);
                finish();
            }
        });

        final FloatingActionButton agen=(FloatingActionButton)findViewById(R.id.hor_2);
        agen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Ini==0){
                    agen.setTitle("Cargando...");
                    Ini=1;
                }else {
                    agen.setTitle("Agenda");
                    Ini=0;
                }
                Intent i=new Intent(Edit_horario.this,Agenda.class);
                startActivity(i);
                finish();
            }
        });

        final FloatingActionButton recor=(FloatingActionButton)findViewById(R.id.hor_3);
        recor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Ini==0){
                    recor.setTitle("Cargando...");
                    Ini=1;
                }else {
                    recor.setTitle("Recordatorio");
                    Ini=0;
                }
                Intent i=new Intent(Edit_horario.this,Recordatorio.class);
                startActivity(i);
                finish();
            }
        });

    }
    public void sali (View view){
        Intent i=new Intent(Edit_horario.this,InicioSesion.class);
        startActivity(i);
        finish();


    }
}
