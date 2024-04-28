package br.com.pedromota.segundoprojeto.pessoas;

import br.com.pedromota.segundoprojeto.livros.Livro;

import java.util.ArrayList;
//seriam os 2 clientes da biblioteca
public class Aluno extends Pessoa{
    public ArrayList<Livro> listaLivrosEmprestados;
    private String idAluno;

    public Aluno(String usuario, String senha, String nome, String endereco, String telefone, String idAluno) {
        super(usuario, senha, nome, endereco, telefone);
        this.idAluno = idAluno;
        this.listaLivrosEmprestados = new ArrayList<>();
    }

    public void imprimeLivrosEmprestados(){
        for(Livro l:listaLivrosEmprestados){
            System.out.println(l);
        }
    }

    public String getIdAluno() {
        return idAluno;
    }

    @Override
    public String toString() {
        return super.toString() + "Id do aluno: " + getIdAluno();
    }
}
