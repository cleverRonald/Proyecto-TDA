package com.example.dlanor.proyectotda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

import DataBase.DBhelper;

public class Edit_recordatorio extends AppCompatActivity {
    int Ini=0;
    Button gucu;
    EditText nomcum,diacum,mescum,aniocum,inforcum;
    DBhelper helper=new DBhelper(this,"tda2",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_recordatorio);


        gucu=(Button)findViewById(R.id.guarcum);
        nomcum=(EditText)findViewById(R.id.nombrecumple);
        diacum=(EditText)findViewById(R.id.diacumple);
        mescum=(EditText)findViewById(R.id.mescumple);
        aniocum=(EditText)findViewById(R.id.aniocumple);
        inforcum=(EditText)findViewById(R.id.informacum);

        gucu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                helper.abrir();
                helper.insertarTarea(String.valueOf(nomcum.getText()),String.valueOf(diacum.getText()),String.valueOf(mescum.getText()),String.valueOf(aniocum.getText()),String.valueOf(inforcum.getText()));
                helper.cerrar();
                Toast.makeText(getApplicationContext(),"Tarea almacenada con exito",Toast.LENGTH_LONG).show();
                nomcum.setText("");
                diacum.setText("");
                mescum.setText("");
                aniocum.setText("");
                inforcum.setText("");

            }
        });


        final FloatingActionButton Rcor=(FloatingActionButton)findViewById(R.id.recor_1);
        Rcor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Ini==0){
                    Rcor.setTitle("Cargando...");
                    Ini=1;
                }else {
                    Rcor.setTitle("Editar recordatorio");
                    Ini=0;
                }
                Intent i=new Intent(Edit_recordatorio.this,Recordatorio.class);
                startActivity(i);
                finish();
            }
        });

        final FloatingActionButton agen=(FloatingActionButton)findViewById(R.id.recor_2);
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
                Intent i=new Intent(Edit_recordatorio.this,Agenda.class);
                startActivity(i);
                finish();
            }
        });

        final FloatingActionButton hor=(FloatingActionButton)findViewById(R.id.recor_3);
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
                Intent i=new Intent(Edit_recordatorio.this,Horario.class);
                startActivity(i);
                finish();
            }
        });


    }
    public void salir2 (View view){
        Intent i=new Intent(Edit_recordatorio.this,InicioSesion.class);
        startActivity(i);
        finish();
    }
}
