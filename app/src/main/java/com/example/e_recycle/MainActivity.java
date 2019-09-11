package com.example.e_recycle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnEntrar, btnSair;
    EditText txtLogin, txtSenha, codusu;
    TextView lblCadastre, lblEsqueSenha;
    List<Login> loginList;
    ProgressBar pbLogin;

//    private static final int CODE_GET_REQUEST = 1024;
//    private static final int CODE_POST_REQUEST = 1025;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnSair = (Button) findViewById(R.id.btnSair);
        codusu = (EditText) findViewById(R.id.IdUsu);
        txtLogin = (EditText) findViewById(R.id.txtLogin);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        lblCadastre = (TextView) findViewById(R.id.lblcadastre);
        lblEsqueSenha = (TextView) findViewById(R.id.lblEsqSenha);
        pbLogin = (ProgressBar) findViewById(R.id.idpbLogin);

        loginList = new ArrayList<>();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                loginUsuarios();
                String user, pass;
                user = txtLogin.getText().toString();
                pass = txtSenha.getText().toString();

                if (user.equals("admin") && pass.equals("admin")) {
                    startActivity(new Intent(getApplicationContext(), Pag_Menu_Activity.class));
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(),"Login inválido!", Toast.LENGTH_SHORT).show();
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
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Esqueceu a senha?")
                        .setMessage("Digite seu e-mail")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "Verifique seu email", Toast.LENGTH_SHORT).show();
                            }
                        }).setIcon(R.drawable.ic_search).show();
            }
        });
        readLogin();
    }

    private void loginUsuarios() {
        String email = txtLogin.getText().toString();
        String senha = txtSenha.getText().toString();
        String codUsu = codusu.getText().toString();


        if (TextUtils.isEmpty(email)) {
            txtLogin.setError("Por favor, insira o email");
            txtLogin.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(senha)) {
            txtSenha.setError("Por favor, insira sua senha");
            txtSenha.requestFocus();
        }

        HashMap<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("senha", senha);
        params.put("codUsu", codUsu);

//        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_LOGIN, params, CODE_POST_REQUEST);
//        request.execute();
    }

    private void readLogin() {
//        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_READ_LOGIN, null, CODE_GET_REQUEST);
//        request.execute();
    }

    private void refreshUsuariosList(JSONArray usuarios) throws JSONException {
        loginList.clear();
        for (int i = 0; i < usuarios.length(); i++) {
            JSONObject object = usuarios.getJSONObject(i);

            loginList.add(new Login(
                    object.getString("email"),
                    object.getString("senha"),
                    object.getString("codUsu")
            ));
        }
    }

//    private class PerformNetworkRequest extends AsyncTask<Void, Void, String> {
//        String url;
//        HashMap<String, String> params;
//        int requestCode;
//
//        public PerformNetworkRequest(String url, HashMap<String, String> params, int requestCod) {
//            this.url = url;
//            this.params = params;
//            this.requestCode = requestCod;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            pbLogin.setVisibility(View.VISIBLE);
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            pbLogin.setVisibility(View.GONE);
//            try {
//                JSONObject object = new JSONObject(s);
//                if (!object.getBoolean("error")) {
//                    Toast.makeText(getApplicationContext(), object.getString("message"), Toast.LENGTH_SHORT).show();
//                    refreshUsuariosList(object.getJSONArray("usuarios"));
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//                Toast.makeText(getApplicationContext(), "Cheguei aqui", Toast.LENGTH_SHORT).show();
//            }
//        }
//
////        @Override
////        protected String doInBackground(Void... voids) {
////            RequestHandler requestHandler = new RequestHandler();
////
////            if (requestCode == CODE_POST_REQUEST) {
////                return requestHandler.sendPostRequest(url, params);
////            }
////            if (requestCode == CODE_GET_REQUEST) {
////                return requestHandler.sendGetRequest(url);
////            }
////            return null;
////        }
//    }

}
