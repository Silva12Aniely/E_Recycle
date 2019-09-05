package com.example.e_recycle;

import androidx.annotation.NonNull;
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

import java.util.List;

import it.sephiroth.android.library.tooltip.Tooltip;

public class Voce_Sabia_Activity extends AppCompatActivity {
    Toolbar tvSabia;
    GridView idVSgrid;

    String[] txtVS = {"CPU", "Monitor", "Fonte", "HD",  "Teclado",  "Placa Mãe",  "Memória Ram",  "Placa de Video"};
    int[] imgVS = {R.drawable.vs_cpu, R.drawable.vs_desktop, R.drawable.vs_fonte, R.drawable.vs_harddisk,  R.drawable.vs_keyboard, R.drawable.vs_motherboard, R.drawable.vs_ramemory, R.drawable.vs_gpu};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voce_sabia_layout);

        tvSabia = (Toolbar) findViewById(R.id.TvSabia);
        idVSgrid = (GridView) findViewById(R.id.idVSgrid) ;

        setSupportActionBar(tvSabia);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CustomAdapter customAdapter = new CustomAdapter();
        idVSgrid.setAdapter(customAdapter);

        idVSgrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }

//    public void bottomToolTip(View view) {
//        Button bottomToolTip = (Button) findViewById(R.id.bottomToolTip);
//
//        Tooltip.make(this, new Tooltip.Builder(101)
//            .anchor(bottomToolTip, Tooltip.Gravity.BOTTOM)
//            .closePolicy(new Tooltip.ClosePolicy().insidePolicy(true, false).outsidePolicy(true, false), 4000)
//            .activateDelay(900).showDelay(400)
//            .text("Cliquei aqui para exibir mensagem").maxWidth(600).withArrow(true).withOverlay(true).build()
//        ).show();
//    }

    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imgVS.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.model_voce_sabia, null);

            TextView comp = view1.findViewById(R.id.txtVs);
            ImageView imgVs = view1.findViewById(R.id.imgVs);

            comp.setText(txtVS[position]);
            imgVs.setImageResource(imgVS[position]);

            return view1;
        }
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
