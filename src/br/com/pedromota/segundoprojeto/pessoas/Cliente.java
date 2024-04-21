package br.com.pedromota.segundoprojeto.pessoas;

import br.com.pedromota.segundoprojeto.livros.Livro;

import java.util.ArrayList;

public class Cliente extends Pessoa{
    //cliente da biblioteca
    //adicionar outros atributos e niveis de permissao
    private String idCliente;
    public ArrayList<Livro> listaLivrosEmprestados;

    public Cliente(String usuario, String senha, String idCliente, ArrayList<Livro> listaLivrosEmprestados) {
        super(usuario, senha);
        this.idCliente = idCliente;
        this.listaLivrosEmprestados = listaLivrosEmprestados;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
}
