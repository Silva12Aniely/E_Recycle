package com.example.e_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnEntrar, btnSair;
    EditText txtLogin, txtSenha;
    TextView lblCadastre, lblEsqueSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnSair = (Button) findViewById(R.id.btnSair);
        txtLogin = (EditText) findViewById(R.id.txtLogin);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        lblCadastre = (TextView) findViewById(R.id.lblcadastre);
        lblEsqueSenha = (TextView) findViewById(R.id.lblEsqSenha);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login, pass;

                login = txtLogin.getText().toString();
                pass = txtSenha.getText().toString();

                if (login.equals("admin") && pass.equals("admin")) {
//                    startActivity(new Intent(getApplicationContext(), Pag_Principal_Activity.class));
//                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Login ou Senha Inválidos!", Toast.LENGTH_SHORT).show();
                    txtLogin.setText("");
                    txtSenha.setText("");
                    txtLogin.requestFocus();
                }
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        lblCadastre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             startActivity(new Intent(getApplicationContext(), Cadastro_Activity.class));
             finish();
            }
        });

        lblEsqueSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Verifique seu E-mail.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
