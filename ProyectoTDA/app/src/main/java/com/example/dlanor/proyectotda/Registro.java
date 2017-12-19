package com.example.dlanor.proyectotda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import DataBase.DBhelper;

public class Registro extends AppCompatActivity {

    Button btGrabarusu;
    EditText txtdni,txtNom,txtApe,txtUsu,txtPass,txtdia,txtmes,txtanio;
    TextView ingre;

    DBhelper helper=new DBhelper(this,"tda",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btGrabarusu=(Button)findViewById(R.id.btRegisUsu);
        txtdni=(EditText)findViewById(R.id.txtDni);
        txtNom=(EditText)findViewById(R.id.txtNomUsu);
        txtApe=(EditText)findViewById(R.id.txtApeUsu);
        txtUsu=(EditText)findViewById(R.id.txtusuario);
        txtPass=(EditText)findViewById(R.id.txtpassword);
        txtdia=(EditText)findViewById(R.id.txtDia);
        txtmes=(EditText)findViewById(R.id.txtMes);
        txtanio=(EditText)findViewById(R.id.txtAnio);

        btGrabarusu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                helper.abrir();
                helper.insertarReg(String.valueOf(txtdni.getText()),String.valueOf(txtNom.getText()),String.valueOf(txtApe.getText()), String.valueOf(txtUsu.getText()),String.valueOf(txtPass.getText()),String.valueOf(txtdia.getText()),String.valueOf(txtmes.getText()),String.valueOf(txtanio.getText()));
                helper.cerrar();

                Toast.makeText(getApplicationContext(),"Registro almacenado con exito",Toast.LENGTH_LONG).show();

                Intent i=new Intent(getApplicationContext(),InicioSesion.class);
                startActivity(i);
                txtdni.setText("");
                txtNom.setText("");
                txtApe.setText("");
                txtUsu.setText("");
                txtPass.setText("");
                txtdia.setText("");
                txtmes.setText("");
                txtanio.setText("");
            }
        });
        ingre=(TextView)findViewById(R.id.Ingree);
        ingre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Registro.this,InicioSesion.class);
                startActivity(i);
                finish();
            }
        });

    }
}
