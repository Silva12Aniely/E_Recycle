package com.example.e_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import java.net.URI;

public class Perfil_Coletor_Activity extends AppCompatActivity {
    Button btnVoltar, btnwpp, btnRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil_coletor_layout);

        btnVoltar = (Button) findViewById(R.id.mVoltar);
        btnwpp = (Button) findViewById(R.id.idWpp);
        btnRating = (Button) findViewById(R.id.btnRating);
        final RatingBar ratingBarP = findViewById(R.id.ratingPcoletor);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Coletores_Activity.class));
                finish();
            }
        });
        btnwpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnWpp("https://wa.me/+5511000000000");
            }
        });

        btnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = "Sua avaliação foi: " + ratingBarP.getRating();
                Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void btnWpp(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
