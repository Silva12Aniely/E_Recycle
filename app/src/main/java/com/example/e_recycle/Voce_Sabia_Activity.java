package com.example.e_recycle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Voce_Sabia_Activity extends AppCompatActivity {
    Toolbar tvSabia;
    CardView vs_cpu, vs_screen, vs_psu, vs_hd, vs_keyb, vs_mBoard, vs_ram, vs_gpu;
    Button btnVoltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voce_sabia_layout);

        tvSabia = (Toolbar) findViewById(R.id.TvSabia);
        vs_cpu = (CardView) findViewById(R.id.vs_cpu);
        vs_hd = (CardView) findViewById(R.id.vs_HD);
        vs_screen = (CardView) findViewById(R.id.vs_screen);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        setSupportActionBar(tvSabia);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

//        Cards
        vs_cpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Voce_Sabia_Activity.this);
                builder.setTitle("Procesadores").setMessage(R.string.cpu).show();
            }
        });
        vs_hd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Voce_Sabia_Activity.this);
                builder.setTitle("Hard Disk").setMessage(R.string.hd).show();
            }
        });
        vs_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Voce_Sabia_Activity.this);
                builder.setTitle("Tela de Monitor").setMessage("Contêm mercúrio, e pode causa transtornos digestivos, possibilidades de alteração cromossômica.").show();
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
