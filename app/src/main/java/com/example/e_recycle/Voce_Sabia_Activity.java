package com.example.e_recycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.TooltipCompat;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import it.sephiroth.android.library.tooltip.Tooltip;

public class Voce_Sabia_Activity extends AppCompatActivity {
    Toolbar tvSabia;
    CardView vs_cpu, vs_screen, vs_psu, vs_hd, vs_keyb, vs_mBoard, vs_ram, vs_gpu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voce_sabia_layout);

        tvSabia = (Toolbar) findViewById(R.id.TvSabia);
        vs_cpu = (CardView) findViewById(R.id.vs_cpu);
        vs_hd = (CardView) findViewById(R.id.vs_HD);
        vs_screen = (CardView) findViewById(R.id.vs_screen);

        setSupportActionBar(tvSabia);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(getApplicationContext(), Pag_Menu_Activity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
