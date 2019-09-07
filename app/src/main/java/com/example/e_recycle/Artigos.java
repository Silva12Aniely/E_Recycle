package com.example.e_recycle;

public class Artigos {
    private String data;
    private String titulo;
    private int imgArtigo;
    private String descricao;
    private String autor;

    public Artigos() {
    }

    public Artigos(String data, String titulo, int imgArtigo, String descricao, String autor) {
        this.data = data;
        this.titulo = titulo;
        this.imgArtigo = imgArtigo;
        this.descricao = descricao;
        this.autor = autor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImgArtigo() {
        return imgArtigo;
    }

    public void setImgArtigo(int imgArtigo) {
        this.imgArtigo = imgArtigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
