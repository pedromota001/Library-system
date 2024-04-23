package br.com.pedromota.segundoprojeto.pessoas;

import br.com.pedromota.segundoprojeto.livros.Livro;

import java.util.ArrayList;
//seriam os 2 clientes da biblioteca
public class Aluno extends Cliente{


    public Aluno(String usuario, String senha, String nome, String endereco, String telefone, String id) {
        super(usuario, senha, nome, endereco, telefone, id);
        this.listaLivrosEmprestados = new ArrayList<>();
    }
}
