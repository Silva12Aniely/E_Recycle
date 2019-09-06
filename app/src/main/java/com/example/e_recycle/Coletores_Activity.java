package com.example.e_recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
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
    Toolbar toolbar;
    ListView listView;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coletores_layout);

        toolbar = (Toolbar) findViewById(R.id.mColetores);
        listView = (ListView) findViewById(R.id.lstColetores);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        final RatingBar ratingBar = findViewById(R.id.idRatingColetor);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                Intent intent = new Intent(getApplicationContext(), Coletores_Activity.class);
//                startActivity(intent);
//                finish();
//                Toast.makeText(getApplicationContext(), "Cliquei aqui!", Toast.LENGTH_SHORT).show();
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
