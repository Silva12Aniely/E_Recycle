package com.example.e_recycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class Perfil_Usuario_Activity extends AppCompatActivity {
    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;

    Toolbar toolbar;
    Button btnVoltar, btnColetor;
    TextView Sair, nomeUsu, emailUsu, infoColetor;
    EditText edtTel, edtCpf;
    List<Coletor_Cad> coletor_cads;
    Spinner spinnerRegioes;
    CheckBox stoAmaro, socorro;
    LinearLayout idCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil_usuario_layout);

        toolbar = (Toolbar) findViewById(R.id.mUsuperfil);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        Sair = (TextView) findViewById(R.id.txtSair);
        btnColetor = (Button) findViewById(R.id.btnCadastroColetor);
        infoColetor = (TextView) findViewById(R.id.lblInfoColero);
        idCheck = (LinearLayout) findViewById(R.id.idCheck);

        nomeUsu = (TextView) findViewById(R.id.usuNome);
        emailUsu = (TextView) findViewById(R.id.usuEmail);
        edtTel = (EditText) findViewById(R.id.edtTel);
        edtCpf = (EditText) findViewById(R.id.edtCpf);

        stoAmaro = (CheckBox) findViewById(R.id.idZstoAmaro);
        socorro = (CheckBox) findViewById(R.id.idZsocorro);


        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Pag_Menu_Activity.class));
            }
        });
        Sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
        btnColetor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createColetor();
            }
        });

        readColetor();


    }

    private void createColetor() {
        String nome = nomeUsu.getText().toString().trim();
        String email = emailUsu.getText().toString().trim();
        String tel = edtTel.getText().toString().trim();
        String cpf = edtCpf.getText().toString().trim();
        String stAmaro = stoAmaro.getText().toString();
        String zsocorro = socorro.getText().toString();

        HashMap<String, String> params = new HashMap<>();
        params.put("codregioes", stAmaro);
        params.put("nome", nome);
        params.put("email", email);
        params.put("telefone", tel);
        params.put("cpf", cpf);

        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_CREATE_COLETOR, params, CODE_POST_REQUEST);
        request.execute();

        Toast.makeText(getApplicationContext(), "Parabéns! Você agora é um coletor.", Toast.LENGTH_LONG).show();
        btnColetor.setVisibility(View.GONE);
        infoColetor.setVisibility(View.GONE);

    }

    private void readColetor() {
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_READ_COLETOR, null, CODE_GET_REQUEST);
        request.execute();
    }

    private void refreshColetorList(JSONArray coletores) throws JSONException {
        coletor_cads.clear();
        for (int i = 0; i < coletores.length(); i++) {
            JSONObject obj = coletores.getJSONObject(i);

            coletor_cads.add(new Coletor_Cad(
                    obj.getString("codregiao"),
                    obj.getString("nome"),
                    obj.getString("email"),
                    obj.getString("telefone"),
                    obj.getString("cpf")
            ));
        }
    }

    private class PerformNetworkRequest extends AsyncTask<Void, Void, String> {
        String url;
        HashMap<String, String> params;
        int requestCode;

        public PerformNetworkRequest(String url, HashMap<String, String> params, int requestCode) {
            this.url = url;
            this.params = params;
            this.requestCode = requestCode;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject object = new JSONObject(s);
                if (!object.getBoolean("error")) {
                    Toast.makeText(getApplicationContext(), object.getString("message"), Toast.LENGTH_SHORT).show();
                    refreshColetorList(object.getJSONArray("coletores"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(Void... voids) {
            RequestHandler requestHandler = new RequestHandler();

            if (requestCode == CODE_POST_REQUEST) {
                return requestHandler.sendPostRequest(url, params);
            }
            if (requestCode == CODE_GET_REQUEST) {
                return requestHandler.sendGetRequest(url);
            }
            return null;
        }
    }


}
