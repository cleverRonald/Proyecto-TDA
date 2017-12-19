package com.example.dlanor.proyectotda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;

public class Horario extends AppCompatActivity {
    int Ini=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);

        final FloatingActionButton edithor=(FloatingActionButton)findViewById(R.id.Hor_a);
        edithor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Ini==0){
                    edithor.setTitle("Cargando...");
                    Ini=1;
                }else {
                    edithor.setTitle("Editar horario");
                    Ini=0;
                }
                Intent i=new Intent(Horario.this,Edit_horario.class);
                startActivity(i);
                finish();
            }
        });

        final FloatingActionButton agen=(FloatingActionButton)findViewById(R.id.Hor_b);
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
                Intent i=new Intent(Horario.this,Agenda.class);
                startActivity(i);
                finish();
            }
        });

        final FloatingActionButton recor=(FloatingActionButton)findViewById(R.id.Hor_c);
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
                Intent i=new Intent(Horario.this,Recordatorio.class);
                startActivity(i);
                finish();
            }
        });

    }
    public void salir3 (View view){
        Intent i=new Intent(Horario.this,InicioSesion.class);
        startActivity(i);
        finish();

    }
}
