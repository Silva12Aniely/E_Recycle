package com.example.e_recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Pag_Menu_Activity extends AppCompatActivity {
    CardView idColetores, idVSabia, idArtigos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pag_menu_layout);

        idColetores = (CardView) findViewById(R.id.cvColetor);
        idVSabia = (CardView) findViewById(R.id.cvVoceSabia);
        idArtigos = (CardView) findViewById(R.id.cvArtigos);

        idColetores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Coletores_Activity.class));
//                Toast.makeText(getApplicationContext(), "Cliquei", Toast.LENGTH_SHORT).show();
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

    }
}
