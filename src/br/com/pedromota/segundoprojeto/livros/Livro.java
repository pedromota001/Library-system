package br.com.pedromota.segundoprojeto.livros;

import java.util.ArrayList;

public abstract class Livro {
    private String autor;
    private String idLivro;
    private String titulo;
    private boolean status;
    private ArrayList<Double> listaAvaliacoes;
    private String editora;
    private String anoDePublicacao;
    private double avaliacaoMedia;
    private String sinopse;
    //manipular permissao de retirar livros a partir do status(disponivel(1) ou emprestado(0).
    //adicionar novas funcionalidades a classe livro podendo criar subclasses.


    public Livro(String autor, String idLivro, String titulo, String editora, String anoDePublicacao) {
        this.autor = autor;
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.listaAvaliacoes = new ArrayList<Double>();
        this.editora = editora;
        this.anoDePublicacao = anoDePublicacao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(String anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    public double getAvaliacaoMedia() {
        return avaliacaoMedia;
    }

    public void setAvaliacaoMedia(double avaliacaoMedia) {
        this.avaliacaoMedia = avaliacaoMedia;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(String idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public void setListaAvaliacoes(double nota){
        this.listaAvaliacoes.add(nota);
    }
    public void avalia(){
        for(Double n:listaAvaliacoes){
            avaliacaoMedia += n;
        }
    }

    @Override
    public String toString() {
        return "Titulo: " + getTitulo() + " //Autor: " + getAutor() + " //Editora: " + getEditora() + " //Ano de publicacao: " + getAnoDePublicacao() + " //Avaliacao: " + getAvaliacaoMedia();
    }
}
