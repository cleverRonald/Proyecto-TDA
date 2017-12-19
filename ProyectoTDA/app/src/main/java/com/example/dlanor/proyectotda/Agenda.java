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

public class Agenda extends AppCompatActivity {
int Ini=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

       cargartarea();




        final FloatingActionButton editag=(FloatingActionButton)findViewById(R.id.Agen_a);
        editag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Ini==0){
                    editag.setTitle("Cargando...");
                    Ini=1;
                }else {
                    editag.setTitle("Editar agenda");
                    Ini=0;
                }
                Intent i=new Intent(Agenda.this,Edit_agenda.class);
                startActivity(i);
                finish();

            }
        });

        final FloatingActionButton Horario=(FloatingActionButton)findViewById(R.id.Agen_b);
        Horario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Ini==0){
                    Horario.setTitle("Cargando...");
                    Ini=1;
                }else {
                    Horario.setTitle("Horario");
                    Ini=0;
                }
                Intent i=new Intent(Agenda.this,Horario.class);
                startActivity(i);
                finish();

            }
        });

        final FloatingActionButton recordatorio=(FloatingActionButton)findViewById(R.id.Agen_c);
        recordatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Ini==0){
                    recordatorio.setTitle("Cargando...");
                    Ini=1;
                }else {
                    recordatorio.setTitle("Horario");
                    Ini=0;
                }
                Intent i=new Intent(Agenda.this,Recordatorio.class);
                startActivity(i);
                finish();

            }
        });


    }
    private void cargartarea(){
        DBhelper helper=new DBhelper(this,"tda",null,1);
        SQLiteDatabase db=helper.getWritableDatabase();
        if (db !=null) {
            Cursor c = db.rawQuery("select * from usuarios", null);
            int cantidad = c.getCount();


            int i = 0;
            String[] arreglo = new String[cantidad];
            if (c.moveToFirst()) {
                do {
                    String linea = c.getString(2);
                    ;
                    arreglo[i] = linea;
                    i++;

                } while (c.moveToNext());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arreglo);

            ListView lista = (ListView) findViewById(R.id.mostrartarea);

            lista.setAdapter(adapter);
        }
    }
    public void salir (View view){
        Intent i=new Intent(Agenda.this,InicioSesion.class);
        startActivity(i);
        finish();

    }
}
