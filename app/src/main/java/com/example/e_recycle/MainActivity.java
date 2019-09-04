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

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnEntrar, btnSair;
    EditText txtLogin, txtSenha;
    TextView lblCadastre, lblEsqueSenha;
    List<Login> loginList;
    ProgressBar pbLogin;

    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;

    boolean isUpdating = false;

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
//                String login, pass;
//
//                login = txtLogin.getText().toString();
//                pass = txtSenha.getText().toString();
//
//                if (login.equals("admin") && pass.equals("admin")) {
//                    startActivity(new Intent(getApplicationContext(), Pag_Menu_Activity.class));
//                    finish();
//                } else {
//                    Toast.makeText(getApplicationContext(), "Login ou Senha Inválidos!", Toast.LENGTH_SHORT).show();
//                    txtLogin.setText("");
//                    txtSenha.setText("");
//                    txtLogin.requestFocus();
//                }
                if (isUpdating) {

                }else {
                    loginUsu();
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
//                Toast.makeText(getApplicationContext(),"Verifique seu E-mail.", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Esqueceu a senha?")
                        .setMessage("Digite seu e-mail")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Verifique seu email", Toast.LENGTH_SHORT).show();
                    }
                }).setIcon(R.drawable.ic_bar).show();
            }
        });
    }

    public void loginUsu() {
        String login = txtLogin.getText().toString().trim();
        String senha = txtSenha.getText().toString().trim();
        pbLogin = (ProgressBar) findViewById(R.id.idpbLogin);

        if (TextUtils.isEmpty(login)) {
            txtLogin.setError("Insira seu email");
            txtLogin.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(senha)) {
            txtLogin.setError("Insira sua senha");
            txtSenha.requestFocus();
            return;
        }

        HashMap<String, String> params = new HashMap<>();
        params.put("login", login);
        params.put("pass", senha);

        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_Login, params, CODE_POST_REQUEST);
        request.execute();

    }

    private void readLogin() {
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_Read_Login, null, CODE_GET_REQUEST);
        request.execute();
    }

    private void refreshLogin(JSONArray login) throws JSONException {
        loginList.clear();

        for (int i = 0; i < login.length(); i++) {
            JSONObject object = login.getJSONObject(i);

            loginList.add(new Login(
               object.getString("login"),
               object.getString("senha")
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
            pbLogin.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pbLogin.setVisibility(View.GONE);
            try {
                JSONObject object = new JSONObject(s);
                if (!object.getBoolean("error")) {
                    Toast.makeText(getApplicationContext(), object.getString("message"), Toast.LENGTH_SHORT).show();
                    refreshLogin(object.getJSONArray("login"));
                }
            }catch (Exception e){
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
