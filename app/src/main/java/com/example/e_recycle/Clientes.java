package com.example.e_recycle;

public class Clientes {
    private int CODCLIENTES, CPF, TELEFONE;
    private String NOME, EMAIL;

    public Clientes() {
    }

    public Clientes(int CODCLIENTES, int CPF, int TELEFONE, String NOME, String EMAIL) {
        this.CODCLIENTES = CODCLIENTES;
        this.CPF = CPF;
        this.TELEFONE = TELEFONE;
        this.NOME = NOME;
        this.EMAIL = EMAIL;
    }

    public int getCODCLIENTES() {
        return CODCLIENTES;
    }

    public int getCPF() {
        return CPF;
    }

    public int getTELEFONE() {
        return TELEFONE;
    }

    public String getNOME() {
        return NOME;
    }

    public String getEMAIL() {
        return EMAIL;
    }
}
