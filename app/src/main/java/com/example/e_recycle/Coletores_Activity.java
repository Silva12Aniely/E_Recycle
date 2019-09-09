package com.example.e_recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;

public class Coletores_Activity extends AppCompatActivity {
    ListView lstColetores;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coletores_layout);

        lstColetores = (ListView) findViewById(R.id.lstColetores);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        final RatingBar ratingBar = findViewById(R.id.idRatingColetor);

        CustomAdapter customAdapter = new CustomAdapter();
        lstColetores.setAdapter(customAdapter);


        lstColetores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                startActivity(new Intent(getApplicationContext(), Perfil_Coletor_Activity.class));
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


    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.lst_coletores, null);

            return view1;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(getApplicationContext(), Pag_Menu_Activity.class));
        finish();

        return super.onOptionsItemSelected(item);
    }
}
