package com.example.e_recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Cad_Coletor_Activity extends AppCompatActivity {
    Toolbar toolbar;
    Button btnCadColetor, btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cad_coletor_layout);

        toolbar = (Toolbar) findViewById(R.id.idToolbarCadColetor);
        btnCadColetor = (Button) findViewById(R.id.btnCadColetor);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        btnCadColetor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Cadastro Coletor", Toast.LENGTH_SHORT).show();
            }
        });
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Pag_Menu_Activity.class));
                finish();
            }
        });
    }
}
