package com.example.e_recycle;

public class Artigos {
    private int imgArtigo;
    private String titulo, descricao;

    public Artigos() {
    }

    public Artigos(int imgArtigo, String titulo, String descricao) {
        this.imgArtigo = imgArtigo;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public int getImgArtigo() {
        return imgArtigo;
    }

    public void setImgArtigo(int imgArtigo) {
        this.imgArtigo = imgArtigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
