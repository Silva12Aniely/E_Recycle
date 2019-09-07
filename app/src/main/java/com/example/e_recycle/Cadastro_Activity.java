package com.example.e_recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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
    Button btnCadastrar, btnVoltar;
    TextView rLogin;
    ImageView cImg;
    EditText cNome, cCPF, cTelefone, cEmail, cSenha;
    List<Clientes> clientesList;
    List<Usuarios> usuariosList;
    ProgressBar progressBar;

    boolean isUpdating = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_layout);

        toolbar = (Toolbar) findViewById(R.id.idCadastro);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        rLogin = (TextView) findViewById(R.id.RealizarLogin);
        progressBar = (ProgressBar) findViewById(R.id.idPBCad);

//        Dados Clientes/Usuario
        cImg = (ImageView) findViewById(R.id.cImgUsu);
        cNome = (EditText) findViewById(R.id.cNome_Sobrenome);
        cCPF = (EditText) findViewById(R.id.cCPF);
        cTelefone = (EditText) findViewById(R.id.cTelefone);
        cEmail = (EditText) findViewById(R.id.cEmail);
        cSenha = (EditText) findViewById(R.id.cSenha);
        clientesList = new ArrayList<>();
        usuariosList = new ArrayList<>();

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUsuario();
                createClientes();
                cNome.setText("");
                cEmail.setText("");
                cTelefone.setText("");
                cCPF.setText("");
                cSenha.setText("");
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
        readUsuario();
    }

    private void createClientes() {
        String nome = cNome.getText().toString().trim();
        String email = cEmail.getText().toString().trim();
        String telefone = cTelefone.getText().toString().trim();
        String cpf = cCPF.getText().toString().trim();

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

        HashMap<String, String> params = new HashMap<>();
        params.put("nome", nome);
        params.put("email", email);
        params.put("telefone", telefone);
        params.put("cpf", cpf);

        btnCadastrar.setEnabled(false);
        btnCadastrar.setBackgroundResource(R.drawable.btn_disabled);

        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_CREATE_CLIENTES, params, CODE_POST_REQUEST);
        request.execute();
    }

    private void readClientes() {
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_READ_CLIENTES, null, CODE_GET_REQUEST);
        request.execute();
    }

    // U S U A R I O
    private void createUsuario() {
        String senha = cSenha.getText().toString().trim();
        String email = cEmail.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            cEmail.setError("Insira seu email");
            cEmail.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(senha)) {
            cSenha.setError("Insira sua senha");
            cSenha.requestFocus();
            return;
        }

        HashMap<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("senha", senha);

        btnCadastrar.setEnabled(false);
        btnCadastrar.setBackgroundResource(R.drawable.btn_disabled);

        PerformNetworkRequestUsuario request = new PerformNetworkRequestUsuario(Api.URL_CREATE_USUARIOS, params, CODE_POST_REQUEST);
        request.execute();
    }

    // U S U A R I O
    private void readUsuario() {
        PerformNetworkRequestUsuario request = new PerformNetworkRequestUsuario(Api.URL_READ_USUARIOS, null, CODE_GET_REQUEST);
        request.execute();
    }

    private void refreshClienteList(JSONArray clientes) throws JSONException {
        clientesList.clear();

        for (int i = 0; i < clientes.length(); i++) {
            JSONObject obj = clientes.getJSONObject(i);

            clientesList.add(new Clientes(
                    obj.getInt("codclientes"),
                    obj.getString("nome"),
                    obj.getString("email"),
                    obj.getInt("telefone"),
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

    // U S U A R I O
    private void refreshUsuarioList(JSONArray usuario) throws JSONException {
        usuariosList.clear();

        for (int i = 0; i < usuario.length(); i++) {
            JSONObject obj = usuario.getJSONObject(i);

            usuariosList.add(new Usuarios(
                    obj.getString("email"),
                    obj.getString("senha")
            ));
        }
    }

    // U S U A R I O
    private class PerformNetworkRequestUsuario extends AsyncTask<Void, Void, String> {
        String url;
        HashMap<String, String> params;
        int requestCode;

        public PerformNetworkRequestUsuario(String url, HashMap<String, String> params, int requestCode) {
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
                    refreshUsuarioList(object.getJSONArray("usuario"));
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
