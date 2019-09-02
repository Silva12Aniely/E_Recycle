package com.example.e_recycle;

public class Clientes {
    private int codclientes;
    private String nome, email;
    private int telefone, cpf;

    public Clientes() {
    }

    public Clientes(int codclientes, String nome, String email, int telefone, int cpf) {
        this.codclientes = codclientes;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public int getCodclientes() {
        return codclientes;
    }

    public void setCodclientes(int codclientes) {
        this.codclientes = codclientes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}