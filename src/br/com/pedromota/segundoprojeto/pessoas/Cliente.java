package br.com.pedromota.segundoprojeto.pessoas;

import br.com.pedromota.segundoprojeto.livros.Livro;

import java.util.ArrayList;

public class Cliente extends Pessoa{
    //cliente da biblioteca
    //adicionar outros atributos e niveis de permissao
    private String idCliente;
    public ArrayList<Livro> listaLivrosEmprestados;

    public Cliente(String usuario, String senha, String nome, String endereco, String telefone, String id) {
        super(usuario, senha, nome, endereco, telefone);
        this.idCliente = id;
        this.listaLivrosEmprestados = new ArrayList<>();
    }


    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
}
