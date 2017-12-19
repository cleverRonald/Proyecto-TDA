package com.example.dlanor.proyectotda;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.getbase.floatingactionbutton.FloatingActionButton;

import DataBase.DBhelper;

public class Recordatorio extends AppCompatActivity {
    int Ini=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordatorio);

        cargarcumple();

        final FloatingActionButton ediRcor=(FloatingActionButton)findViewById(R.id.recor_a);
        ediRcor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Ini==0){
                    ediRcor.setTitle("Cargando...");
                    Ini=1;
                }else {
                    ediRcor.setTitle("Editar recordatorio");
                    Ini=0;
                }
                Intent i=new Intent(Recordatorio.this,Edit_recordatorio.class);
                startActivity(i);
                finish();
            }
        });

        final FloatingActionButton agen=(FloatingActionButton)findViewById(R.id.recor_b);
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
                Intent i=new Intent(Recordatorio.this,Agenda.class);
                startActivity(i);
                finish();
            }
        });

        final FloatingActionButton hor=(FloatingActionButton)findViewById(R.id.recor_c);
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
                Intent i=new Intent(Recordatorio.this,Horario.class);
                startActivity(i);
                finish();
            }
        });

    }

    private void cargarcumple(){
        DBhelper helper=new DBhelper(this,"tda2",null,1);
        SQLiteDatabase db=helper.getWritableDatabase();
        if (db !=null) {
            Cursor c = db.rawQuery("select * from usuarios", null);
            int cantidad = c.getCount();


            int i = 0;
            String[] arreglo = new String[cantidad];
            if (c.moveToFirst()) {
                do {
                    String linea = c.getString(1);
                    ;
                    arreglo[i] = linea;
                    i++;

                } while (c.moveToNext());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arreglo);

            ListView lista = (ListView) findViewById(R.id.moscumpl);

            lista.setAdapter(adapter);
        }
    }
    public void salir4 (View view){
        Intent i=new Intent(Recordatorio.this,InicioSesion.class);
        startActivity(i);
        finish();

    }
}
