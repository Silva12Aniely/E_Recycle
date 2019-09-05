package com.example.e_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URI;

public class Perfil_Coletor_Activity extends AppCompatActivity {
    Button btnVoltar, btnwpp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil_coletor_layout);

        btnVoltar = (Button) findViewById(R.id.mVoltar);
        btnwpp = (Button) findViewById(R.id.idWpp);

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
                btnWpp("https://wa.me/+5511974828871");
            }
        });

    }
    public void btnWpp(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
