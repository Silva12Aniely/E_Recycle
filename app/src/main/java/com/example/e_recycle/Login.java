package com.example.e_recycle;

public class Login {
    private String email, senha, codUsu;

    public Login() {
    }

    public Login(String email, String senha, String codUsu) {
        this.email = email;
        this.senha = senha;
        this.codUsu = codUsu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCodUsu() {
        return codUsu;
    }

    public void setCodUsu(String codUsu) {
        this.codUsu = codUsu;
    }
}
