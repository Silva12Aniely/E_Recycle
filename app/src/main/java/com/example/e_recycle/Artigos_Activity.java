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
        lstArtigos.add(new Artigos("07/09/2019", "O Meio Ambiente", R.drawable.art_full, "O meio ambiente integra a natureza ambiental e artificial, solo, água, o ar, a flora, a fauna, e ela são muito importantes e equivalentes. O relacionamento da humanidade com a natureza, que teve início com um mínimo de intervenção dos ecossistemas. Atualmente são comuns a contaminação dos cursos de água, a poluição atmosférica, a devastação das florestas, a caça indiscriminada e a redução ou mesmo destruição dos habitats, além de outras formas de agressão ao meio ambiente. Levando em consideração esta questão, o tema a ser abordado refere-se ao Meio Ambiente, uma vez que a questão ambiental tem sido parte integrante no currículo ministrado nas escolas de forma geral. Além do mais, entender o ambiente em que vivemos é parte imprescindível de cada cidadão. Nas escolas através dos educadores há a possibilidade de se conscientizar os educandos e estes ‘levarem’ as informações a seus lares da consciência e da importância de se preservar o espaço em que vivemos.", "Samuel"));
        lstArtigos.add(new Artigos("07/09/2019", "Stentabilidade", R.drawable.space, "O modelo capitalista adotado atualmente expõe o meio ambiente à situação degradante por que passa, estimulando ao consumo permanente, tendo ainda a natureza como fonte inesgotável de energia e matéria prima servindo também de abrigo a dejetos produzidos pelas indústrias e cidades. Assim, uma penalização realmente impactante, além de uma educação ambiental objetiva, poderá inibir ações dos atuais e futuros devastadores do meio ambiente, produzindo assim, consciência de sustentabilidade", "Samuel"));
        lstArtigos.add(new Artigos("07/09/2019", "O Meio Ambiente", R.drawable.art_full, "O meio ambiente integra a natureza ambiental e artificial, solo, água, o ar, a flora, a fauna, e ela são muito importantes e equivalentes. O relacionamento da humanidade com a natureza, que teve início com um mínimo de intervenção dos ecossistemas. Atualmente são comuns a contaminação dos cursos de água, a poluição atmosférica, a devastação das florestas, a caça indiscriminada e a redução ou mesmo destruição dos habitats, além de outras formas de agressão ao meio ambiente. Levando em consideração esta questão, o tema a ser abordado refere-se ao Meio Ambiente, uma vez que a questão ambiental tem sido parte integrante no currículo ministrado nas escolas de forma geral. Além do mais, entender o ambiente em que vivemos é parte imprescindível de cada cidadão. Nas escolas através dos educadores há a possibilidade de se conscientizar os educandos e estes ‘levarem’ as informações a seus lares da consciência e da importância de se preservar o espaço em que vivemos.", "Samuel"));
        lstArtigos.add(new Artigos("07/09/2019", "Sustentabilidade", R.drawable.space, "O modelo capitalista adotado atualmente expõe o meio ambiente à situação degradante por que passa, estimulando ao consumo permanente, tendo ainda a natureza como fonte inesgotável de energia e matéria prima servindo também de abrigo a dejetos produzidos pelas indústrias e cidades. Assim, uma penalização realmente impactante, além de uma educação ambiental objetiva, poderá inibir ações dos atuais e futuros devastadores do meio ambiente, produzindo assim, consciência de sustentabilidade", "Samuel"));

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
