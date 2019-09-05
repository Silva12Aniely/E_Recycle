package com.example.e_recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Pag_Menu_Activity extends AppCompatActivity {
    CardView idColetores, idVSabia, idArtigos, idCadColetores, idSobre, idPerfilUsu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pag_menu_layout);

        idColetores = (CardView) findViewById(R.id.cvColetor);
        idVSabia = (CardView) findViewById(R.id.cvVoceSabia);
        idArtigos = (CardView) findViewById(R.id.cvArtigos);
        idCadColetores = (CardView) findViewById(R.id.cvCadColetor);
        idSobre = (CardView) findViewById(R.id.cvSobre);
        idPerfilUsu = (CardView) findViewById(R.id.cvMPerfil);

        idColetores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Coletores_Activity.class));
                finish();
            }
        });
        idVSabia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Voce_Sabia_Activity.class));
                finish();
            }
        });
        idArtigos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Artigos_Activity.class));
                finish();
            }
        });
        idCadColetores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Cad_Coletor_Activity.class));
                finish();
            }
        });
        idSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Sobre_Activity.class));
                finish();
            }
        });
        idPerfilUsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Perfil_Usuario_Activity.class));
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
           onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
