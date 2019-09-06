package com.example.e_recycle;

public class Clientes {
    private int codClientes;
    private String nome, email;
    private int telefone;
    private String cpf;

    public Clientes() {
    }

    public Clientes(int codClientes, String nome, String email, int telefone, String cpf) {
        this.codClientes = codClientes;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public int getCodClientes() {
        return codClientes;
    }

    public void setCodClientes(int codClientes) {
        this.codClientes = codClientes;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}