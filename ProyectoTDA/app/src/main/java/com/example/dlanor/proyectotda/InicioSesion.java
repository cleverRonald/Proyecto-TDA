package com.example.dlanor.proyectotda;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import DataBase.DBhelper;

public class InicioSesion extends AppCompatActivity {
    TextView txtRegistarse;
    Button btIngresar;

    DBhelper helper=new DBhelper(this,"tda",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        txtRegistarse=(TextView)findViewById(R.id.tvregistrar);
        txtRegistarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Registro.class);
                startActivity(i);
            }
        });
        btIngresar=(Button)findViewById(R.id.btingresar);
        btIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtdni=(EditText)findViewById(R.id.txtdnI);
                EditText txtusu=(EditText)findViewById(R.id.txtusuario);
                EditText txtpass=(EditText)findViewById(R.id.txtpassword);
                Cursor cursor=helper.ConsultorUsuPass( txtdni.getText().toString(),txtusu.getText().toString(),txtpass.getText().toString());
                if(cursor.getCount()>0){
                    Intent i=new Intent(getApplicationContext(),Agenda.class);
                    startActivity(i);
                }else
                    Toast.makeText(getApplicationContext(),"usuario y/o contraseña incorrecto",Toast.LENGTH_LONG).show();
                txtdni.setText("");
                txtusu.setText("");
                txtpass.setText("");
                txtusu.findFocus();
            }
        });
    }
}
