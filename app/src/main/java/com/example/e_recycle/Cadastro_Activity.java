package com.example.e_recycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cadastro_Activity extends AppCompatActivity {
    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;

    Toolbar toolbar;
    Button btnCadastrar;
    TextView rLogin;
    ImageView cImg;
    EditText cNome, cCPF, cTelefone, cEmail, /*cSenha,*/
            Codcliente;
    List<Clientes> ClientesList;
    ProgressBar progressBar;

    boolean isUpdating = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_layout);

        toolbar = (Toolbar) findViewById(R.id.mCadastro);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        rLogin = (TextView) findViewById(R.id.RealizarLogin);
        progressBar = (ProgressBar) findViewById(R.id.idPBCad);

//        Dados Clientes/Usuario
        Codcliente = (EditText) findViewById(R.id.idCodclientes);
        cImg = (ImageView) findViewById(R.id.cImgUsu);
        cNome = (EditText) findViewById(R.id.cNome_Sobrenome);
        cCPF = (EditText) findViewById(R.id.cCPF);
        cTelefone = (EditText) findViewById(R.id.cTelefone);
        cEmail = (EditText) findViewById(R.id.cEmail);
//        cSenha = (EditText) findViewById(R.id.cSenha);
        ClientesList = new ArrayList<>();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                btnCadastrar.setEnabled(false);
//                btnCadastrar.setBackgroundResource(R.drawable.btn_disabled);

                if (isUpdating) {
                    updateClientes();
                } else {
                    createClientes();
                    cNome.setText("");
                    cEmail.setText("");
                    cTelefone.setText("");
                    cCPF.setText("");
                    cNome.requestFocus();
                }
            }
        });
        rLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

        readClientes();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
//            startActivity(new Intent(getApplicationContext(), MainActivity.class));
//            finish();
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void createClientes() {
        String nome = cNome.getText().toString().trim();
        String email = cEmail.getText().toString().trim();
        String telefone = cTelefone.getText().toString().trim();
        String cpf = cCPF.getText().toString().trim();
//        String senha = cSenha.getText().toString().trim();

        if (TextUtils.isEmpty(nome)) {
            cNome.setError("Insira seu nome");
            cNome.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            cEmail.setError("Insira seu e-mail");
            cEmail.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(telefone)) {
            cTelefone.setError("Insira um telefone");
            cTelefone.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(cpf)) {
            cCPF.setError("Insira seu CPF");
            cCPF.requestFocus();
            return;
        }
//        if (TextUtils.isEmpty(senha)) {
//            cSenha.setError("Insira uma senha");
//            cSenha.requestFocus();
//            return;
//        }

        HashMap<String, String> params = new HashMap<>();
        params.put("NOME", nome);
        params.put("EMAIL", email);
        params.put("TELEFONE", telefone);
        params.put("CPF", cpf);
//        params.put("SENHA", senha);

        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_CREATE_CLIENTES, params, CODE_POST_REQUEST);
        request.execute();
        Toast.makeText(getApplicationContext(), "Cadastrado(a) com sucesso!", Toast.LENGTH_SHORT).show();
    }

    private void readClientes() {
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_READ_CLIENTES, null, CODE_GET_REQUEST);
        request.execute();
    }

    private void updateClientes() {
        String codcliente = Codcliente.getText().toString();
        String nome = cNome.getText().toString().trim();
        String cpf = cCPF.getText().toString().trim();
        String telefone = cTelefone.getText().toString().trim();
        String email = cEmail.getText().toString().trim();
//        String senha = cSenha.getText().toString().trim();

        if (TextUtils.isEmpty(nome)) {
            cNome.setError("Insira seu nome");
            cNome.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(cpf)) {
            cCPF.setError("Insira seu CPF");
            cCPF.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(telefone)) {
            cTelefone.setError("Insira um telefone");
            cTelefone.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            cEmail.setError("Insira seu e-mail");
            cEmail.requestFocus();
            return;
        }
//        if (TextUtils.isEmpty(senha)) {
//            cSenha.setError("Insira uma nova senha");
//            cSenha.requestFocus();
//            return;
//        }

        HashMap<String, String> params = new HashMap<>();
        params.put("CODCLIENTES", codcliente);
        params.put("NOME", nome);
        params.put("EMAIL", email);
        params.put("TELEFONE", telefone);
        params.put("CPF", cpf);

        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_UPDATE_CLIENTES, params, CODE_POST_REQUEST);
        request.execute();

        btnCadastrar.setText("Atualizado");

        isUpdating = false;
    }

    private void refreshClienteList(JSONArray clientes) throws JSONException {
        ClientesList.clear();

        for (int i = 0; i < clientes.length(); i++) {
            JSONObject obj = clientes.getJSONObject(i);

            ClientesList.add(new Clientes(
                    obj.getInt("CODCLIENTES"),
                    obj.getString("NOME"),
                    obj.getString("EMAIL"),
                    obj.getInt("TELEFONE"),
                    obj.getInt("CPF")
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
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.GONE);
            try {
                JSONObject object = new JSONObject(s);
                if (!object.getBoolean("error")) {
                    Toast.makeText(getApplicationContext(), object.getString("message"), Toast.LENGTH_SHORT).show();
                    refreshClienteList(object.getJSONArray("clientes"));
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
