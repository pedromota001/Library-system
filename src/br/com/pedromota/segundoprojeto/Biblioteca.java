package br.com.pedromota.segundoprojeto;

import br.com.pedromota.segundoprojeto.livros.Livro;
import br.com.pedromota.segundoprojeto.livros.LivroAcademico;

import java.util.ArrayList;

public class Biblioteca {
    public ArrayList<Livro> listaDeLivros;

    public Biblioteca() {
        this.listaDeLivros = new ArrayList<Livro>();
    }

    public void adicionarLivro(Livro l){
        for(Livro livro: listaDeLivros){
            if(livro.getIdLivro().equalsIgnoreCase(l.getIdLivro())){
                System.out.println("Livro já adicionado na biblioteca, erro ao adicionar ao sistema.");
                return;
            }
        }
        this.listaDeLivros.add(l);
        l.setStatus(true);
        System.out.println("Livro adicionado!");
    }


    public void removerLivro(String id){
        boolean achou = false;
        for(Livro livro:listaDeLivros){
            if(livro.getIdLivro().equalsIgnoreCase(id)){
                achou = true;
                System.out.println("Removendo livro...");
                this.listaDeLivros.remove(livro);
            }
        }
        if(!achou){
            System.out.println("Livro nao encontrado, erro na remocao");
        }
    }

    public void exibeListaDisponiveis(){
        for(Livro livro: listaDeLivros){
            if(livro.isStatus()) {
                System.out.println(livro);
            }
        }
    }
    public void exibeTodosLivros() {
        if (listaDeLivros.isEmpty()) {
            System.out.println("Lista vazia!");
        } else {
            for (Livro livro : listaDeLivros) {
                System.out.println(livro);
            }
        }
    }

    public void exibeIndisponiveis(){
        for(Livro livro:listaDeLivros){
            if(!livro.isStatus()){
                System.out.println(livro);
            }
        }
    }

    public void adicionaSinopse(String id, String sinopse){
        boolean achou = false;
        for(Livro l:listaDeLivros){
            if(l.getIdLivro().equalsIgnoreCase(id)){
                achou = true;
                System.out.println("Adicionando sinopse...");
                l.setSinopse(sinopse);
                return;
            }
        }
        if(!achou){
            System.out.println("Erro, Livro nao encontrado");
        }
    }
    public void exibeSinopse(String nome){
        for(Livro l: listaDeLivros){
            if(l.getTitulo().equalsIgnoreCase(nome)){
                System.out.println("Sinopse: " + l.getSinopse());
                return;
            }
        }
        System.out.println("Erro ao exibir sinopse");
    }




    public Livro emprestimoAluno(String nome){
        for(Livro l:listaDeLivros){
            if(l.getTitulo().equalsIgnoreCase(nome) && l instanceof LivroAcademico){
                if(l.isStatus()){
                    l.setStatus(false);
                    return l;
                }
            }
        }
        System.out.println("Erro ao adicionar livro, livro nao encontrado, indisponivel ou nao academico");
        return null;
    }

    public Livro devolucaoAluno(String nome){
        for(Livro l: listaDeLivros){
            if(l.getTitulo().equalsIgnoreCase(nome) && l instanceof LivroAcademico){
                if(!l.isStatus()){
                    l.setStatus(true);
                    return l;
                }
            }
        }
        System.out.println("Erro ao devolver livro, livro nao encontrado no sistema ou ja disponivel para emprestimo!");
        return null;
    }
}


















// metodos adicionar livro, remover livro, adicionar cliente, remover cliente, emprestar livro, devolver livro, manipular permissoes de acordo c subclasses;
// tentar adicionar diferentes tipos de funcionarios e também um ArrayList de funcionarios.