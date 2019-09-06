package com.example.e_recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
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

        tbArtigos = (Toolbar) findViewById(R.id.idToolbarArtigos);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        setSupportActionBar(tbArtigos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        lstArtigos = new ArrayList<>();
        lstArtigos.add(new Artigos(R.drawable.thumb_art, "Titulo", "Pensando mais a longo prazo, a percepção das dificuldades representa uma abertura para a melhoria das regras de conduta normativas. Todas estas questões, devidamente ponderadas, levantam dúvidas sobre se o desafiador cenário globalizado afeta positivamente a correta previsão do fluxo de informações."));
        lstArtigos.add(new Artigos(R.drawable.thumb_art, "Titulo", "Pensando mais a longo prazo, a percepção das dificuldades representa uma abertura para a melhoria das regras de conduta normativas. Todas estas questões, devidamente ponderadas, levantam dúvidas sobre se o desafiador cenário globalizado afeta positivamente a correta previsão do fluxo de informações."));
        lstArtigos.add(new Artigos(R.drawable.thumb_art, "Titulo", "Pensando mais a longo prazo, a percepção das dificuldades representa uma abertura para a melhoria das regras de conduta normativas. Todas estas questões, devidamente ponderadas, levantam dúvidas sobre se o desafiador cenário globalizado afeta positivamente a correta previsão do fluxo de informações."));
        lstArtigos.add(new Artigos(R.drawable.thumb_art, "Titulo", "Pensando mais a longo prazo, a percepção das dificuldades representa uma abertura para a melhoria das regras de conduta normativas. Todas estas questões, devidamente ponderadas, levantam dúvidas sobre se o desafiador cenário globalizado afeta positivamente a correta previsão do fluxo de informações."));

        RecyclerView m_recyclerView = (RecyclerView) findViewById(R.id.idRVArtigos);
        RecyclerVAdapter vAdapter = new RecyclerVAdapter(getApplicationContext(), lstArtigos);
        m_recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        m_recyclerView.setAdapter(vAdapter);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Pag_Menu_Activity.class));
                finish();
            }
        });
    }
}
