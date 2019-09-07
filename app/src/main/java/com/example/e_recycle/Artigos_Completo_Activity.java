package com.example.e_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Artigos_Completo_Activity extends AppCompatActivity {
    private TextView iddata, idtitulo, idconteudo, idnome;
    private ImageView idimg;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artigos_completo_layout);

        iddata = (TextView) findViewById(R.id.idDate);
        idtitulo = (TextView) findViewById(R.id.idTittle);
        idimg = (ImageView) findViewById(R.id.imgArtFull);
        idconteudo = (TextView) findViewById(R.id.idmateria);
        idnome = (TextView) findViewById(R.id.idnAutor);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Artigos_Activity.class));
                finish();
            }
        });

        Intent intent = getIntent();
        String data = intent.getExtras().getString("data");
        String titulo = intent.getExtras().getString("titulo");
        String conteudo = intent.getExtras().getString("descricao");
        String nome = intent.getExtras().getString("autor");
        int img = intent.getExtras().getInt("imgArtigo");

        iddata.setText(data);
        idtitulo.setText(titulo);
        idconteudo.setText(conteudo);
        idnome.setText(nome);
        idimg.setImageResource(img);
    }
}
