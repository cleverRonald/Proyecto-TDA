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

public class Edit_agenda extends AppCompatActivity {
    Button guarta;
    EditText nomta,diata,mesta,aniota,infota;
    DBhelper helper=new DBhelper(this,"tda",null,1);
    int Ini=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_agenda);


        guarta=(Button)findViewById(R.id.guardarTA);
        nomta=(EditText)findViewById(R.id.noTarea);
        diata=(EditText)findViewById(R.id.editdiaTA);
        mesta=(EditText)findViewById(R.id.editmesTA);
        aniota=(EditText)findViewById(R.id.editanioTA);
        infota=(EditText)findViewById(R.id.editinforTA);

        guarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                helper.abrir();
                helper.insertarTarea(String.valueOf(nomta.getText()),String.valueOf(diata.getText()),String.valueOf(mesta.getText()),String.valueOf(aniota.getText()),String.valueOf(infota.getText()));
            helper.cerrar();
                Toast.makeText(getApplicationContext(),"Tarea almacenada con exito",Toast.LENGTH_LONG).show();
                nomta.setText("");
                diata.setText("");
                mesta.setText("");
                aniota.setText("");
                infota.setText("");

            }
        });









        final FloatingActionButton agen=(FloatingActionButton)findViewById(R.id.Agen_1);
        agen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Ini==0){
                    agen.setTitle("Cargando...");
                    Ini=1;
                }else {
                    agen.setTitle("Editar agenda");
                    Ini=0;
                }
                Intent i=new Intent(Edit_agenda.this,Agenda.class);
                startActivity(i);
                finish();
            }
        });

        final FloatingActionButton hrio=(FloatingActionButton)findViewById(R.id.Agen_2);
        hrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Ini==0){
                    hrio.setTitle("Cargando...");
                    Ini=1;
                }else {
                    hrio.setTitle("Horario");
                    Ini=0;
                }
                Intent i=new Intent(Edit_agenda.this,Horario.class);
                startActivity(i);
                finish();
            }
        });

        final FloatingActionButton recor=(FloatingActionButton)findViewById(R.id.Agen_3);
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
                Intent i=new Intent(Edit_agenda.this,Agenda.class);
                startActivity(i);
                finish();
            }
        });




    }


    public void salira (View view){
        Intent i=new Intent(Edit_agenda.this,InicioSesion.class);
        startActivity(i);
        finish();

    }
}
