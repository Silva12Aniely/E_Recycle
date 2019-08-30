package com.example.e_recycle;

public class Clientes {
    private int CODCLIENTES;
    private String NOME, EMAIL;
    private int TELEFONE, CPF;

    public Clientes() {
    }

    public Clientes(int CODCLIENTES, String NOME, String EMAIL, int TELEFONE, int CPF) {
        this.CODCLIENTES = CODCLIENTES;
        this.NOME = NOME;
        this.EMAIL = EMAIL;
        this.TELEFONE = TELEFONE;
        this.CPF = CPF;
    }

    public int getCODCLIENTES() {
        return CODCLIENTES;
    }

    public String getNOME() {
        return NOME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public int getTELEFONE() {
        return TELEFONE;
    }

    public int getCPF() {
        return CPF;
    }
}