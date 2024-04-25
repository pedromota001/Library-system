package br.com.pedromota.segundoprojeto;

import br.com.pedromota.segundoprojeto.livros.Livro;

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
                System.out.println(l.getSinopse());
                return;
            }
        }
        if(!achou){
            System.out.println("Erro, Livro nao encontrado");
        }
    }
    public void exibeSinopse(String id){
        //implementar
    }





    //public void emprestimo(Livro l)
}


















// metodos adicionar livro, remover livro, adicionar cliente, remover cliente, emprestar livro, devolver livro, manipular permissoes de acordo c subclasses;
// tentar adicionar diferentes tipos de funcionarios e também um ArrayList de funcionarios.