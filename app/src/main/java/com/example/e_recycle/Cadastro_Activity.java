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
    EditText cNome, cCPF, cTelefone, cEmail, /*cSenha,*/Codcliente;
    List<Clientes> ClientesList;

    boolean isUpdating = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_layout);

        toolbar = (Toolbar) findViewById(R.id.mCadastro);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        rLogin = (TextView) findViewById(R.id.RealizarLogin);

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
                }else {
                    createCliente();
                    cNome.setText("");
                    cCPF.setText("");
                    cTelefone.setText("");
                    cEmail.setText("");
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
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void createCliente() {
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

    private void deleteCliente(int id) {
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_DELETE_CLIENTES + id, null, CODE_POST_REQUEST);
        request.execute();
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
//        ClientesAdapter adapter = new ClientesAdapter(ClientesList);
    }

    private class PerformNetworkRequest extends AsyncTask<Void, Void, String> {
        String url;
        HashMap<String, String> params;
        int requestCode;

        PerformNetworkRequest(String url, HashMap<String, String> params, int requestCode) {
            this.url = url;
            this.params = params;
            this.requestCode = requestCode;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject object = new JSONObject(s);
                if (!object.getBoolean("error")) {
                    Toast.makeText(getApplicationContext(), object.getString("message"), Toast.LENGTH_SHORT).show();
                    refreshClienteList(object.getJSONArray("clientes"));
                }
            }
            catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Deu ruim", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected String doInBackground(Void... voids) {
            RequestHandler requestHandler = new RequestHandler();

            if (requestCode == CODE_POST_REQUEST) {
                return requestHandler.sendPostRequest(url,params);
            }
            if (requestCode == CODE_GET_REQUEST) {
                return requestHandler.sendGetRequest(url);
            }
            return null;
        }
    }

    class ClientesAdapter extends ArrayAdapter<Clientes> {
        List<Clientes> clientesList;

        public ClientesAdapter(List<Clientes> clientesList) {
            super(Cadastro_Activity.this, R.layout.cadastro_layout, clientesList);
            this.clientesList = clientesList;
        }

//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            final Button btnCadastrar = findViewById(R.id.btnCadastrar);
//            final Clientes clientes = clientesList.get(position);
//
//            btnCadastrar.setText(clientes.getNOME());
//
//            btnCadastrar.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    isUpdating = true;
//                    Codcliente.setText(String.valueOf(clientes.getCODCLIENTES()));
//                    cNome.setText(clientes.getNOME());
//                    cEmail.setText(clientes.getEMAIL());
//                    cTelefone.setText(clientes.getTELEFONE());
//                    cCPF.setText(clientes.getCPF());
//                    btnCadastrar.setText("Deu bom");
//                }
//            });
//
//            return super.getView(position, convertView, parent);
//        }
    }
}
