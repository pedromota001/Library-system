package br.com.pedromota.segundoprojeto;

import br.com.pedromota.segundoprojeto.livros.Livro;
import br.com.pedromota.segundoprojeto.pessoas.Cliente;

import java.util.ArrayList;

public class Biblioteca {
    public ArrayList<Livro> listaDeLivros;

    public Biblioteca(ArrayList<Livro> listaDeLivros) {
        this.listaDeLivros = new ArrayList<Livro>();
    }

    public void adicionarLivro(Livro l){
        for(Livro livro:listaDeLivros){
            if(livro.getIdLivro().equalsIgnoreCase(l.getIdLivro())){
                System.out.println("Livro ja adicionado na biblioteca, erro ao adicionar ao sistema.");
                return;
            }
            else{
                this.listaDeLivros.add(l);
            }
        }
    }
    public void removerLivro(Livro l){
        for(Livro livro:listaDeLivros){
            if(livro.getIdLivro().equalsIgnoreCase(l.getIdLivro())){
                System.out.println("Removendo livro...");
                this.listaDeLivros.remove(l);
            }
            else{
                System.out.println("Livro não encontrado na biblioteca");
            }
        }
    }
    //public void emprestimo(Livro l)
}


















// metodos adicionar livro, remover livro, adicionar cliente, remover cliente, emprestar livro, devolver livro, manipular permissoes de acordo c subclasses;
// tentar adicionar diferentes tipos de funcionarios e também um ArrayList de funcionarios.