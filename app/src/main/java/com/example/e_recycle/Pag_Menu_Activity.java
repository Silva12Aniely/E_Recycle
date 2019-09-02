package com.example.e_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Pag_Menu_Activity extends AppCompatActivity {
    TextView idColetores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pag_menu_layout);

        idColetores = (TextView) findViewById(R.id.idColetores);

        idColetores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Coletores_Activity.class));
//                Toast.makeText(getApplicationContext(), "Cliquei", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
