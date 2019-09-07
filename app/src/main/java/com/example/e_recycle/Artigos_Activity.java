package com.example.e_recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Artigos_Activity extends AppCompatActivity {
    Toolbar tbArtigos;
    List<Artigos> lstArtigos;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artigos_layout);

        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        tbArtigos = (Toolbar) findViewById(R.id.idToolbarArtigos);

        lstArtigos = new ArrayList<>();
        lstArtigos.add(new Artigos("07/09/2019", "Tittle Artigo", R.drawable.art_full, "Conteudo da materia, Conteudo da materia, Conteudo da materia", "Samuel"));
        lstArtigos.add(new Artigos("07/09/2019", "Tittle Artigo", R.drawable.art_full, "Conteudo da materia, Conteudo da materia, Conteudo da materia", "Samuel"));
        lstArtigos.add(new Artigos("07/09/2019", "Tittle Artigo Dois", R.drawable.art_full, "Materia dois para teste", "Samuel"));
        lstArtigos.add(new Artigos("07/09/2019", "Tittle Artigo Dois", R.drawable.art_full, "Materia dois para teste", "Samuel"));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.idRVArtigos);
        RecyclerVAdapter vAdapter = new RecyclerVAdapter(getApplicationContext(), lstArtigos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(vAdapter);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Pag_Menu_Activity.class));
                finish();
            }
        });
    }
}
