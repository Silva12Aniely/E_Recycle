package com.example.e_recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Perfil_Usuario_Activity extends AppCompatActivity {
    Toolbar toolbar;
    Button btnVoltar;
    TextView Sair, edtTel, edtCpf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil_usuario_layout);

        toolbar = (Toolbar) findViewById(R.id.mUsuperfil);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        Sair = (TextView) findViewById(R.id.txtSair);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);



        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Pag_Menu_Activity.class));
            }
        });
        Sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

}
