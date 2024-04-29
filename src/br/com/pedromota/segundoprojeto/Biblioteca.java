package br.com.pedromota.segundoprojeto;

import br.com.pedromota.segundoprojeto.avaliacoes.Avalia;
import br.com.pedromota.segundoprojeto.livros.Livro;
import br.com.pedromota.segundoprojeto.livros.LivroAcademico;

import java.util.ArrayList;
import java.util.Comparator;

public class Biblioteca implements Avalia {
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
        this.listaDeLivros.sort(Comparator.comparing(Livro::getIdLivro));
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
                this.listaDeLivros.sort(Comparator.comparing(Livro::getIdLivro));
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




    public Livro emprestimoAluno(String id){
        for(Livro l:listaDeLivros){
            if(l.getIdLivro().equalsIgnoreCase(id) && l instanceof LivroAcademico){
                if(l.isStatus()){
                    l.setStatus(false);
                    return l;
                }
            }
        }
        System.out.println("Erro ao adicionar livro, livro nao encontrado, indisponivel ou nao academico");
        return null;
    }

    public Livro devolucaoAluno(String id){
        for(Livro l: listaDeLivros){
            if(l.getIdLivro().equalsIgnoreCase(id) && l instanceof LivroAcademico){
                if(!l.isStatus()){
                    l.setStatus(true);
                    return l;
                }
            }
        }
        System.out.println("Erro ao devolver livro, livro nao encontrado no sistema ou ja disponivel para emprestimo!");
        return null;
    }

    public Livro emprestimoCliente(String id){
        for(Livro l:listaDeLivros){
            if(l.getIdLivro().equalsIgnoreCase(id) && !(l instanceof LivroAcademico)){
                if(l.isStatus()){
                    l.setStatus(false);
                    return l;
                }
            }
        }
        System.out.println("Erro ao fazer emprestimo, livro nao encontrado, nao disponivel ou o livro selecionado era academico");
        return null;
    }
    public Livro devolucaoCliente(String id){
        for(Livro l: listaDeLivros){
            if(l.getIdLivro().equalsIgnoreCase(id) && !(l instanceof LivroAcademico)){
                if(!l.isStatus()){
                    l.setStatus(true);
                    return l;
                }
            }
        }
        System.out.println("Erro ao devolver livro, livro nao encontrado no sistema ou ja disponivel para emprestimo!");
        return null;
    }

    public void exibeDisponiveisAluno(){
        for(Livro l:listaDeLivros){
            if(l.isStatus() && l instanceof LivroAcademico){
                System.out.println(l);
            }
        }
    }
    public void exibeDisponiveisClientes(){
        for(Livro l:listaDeLivros){
            if(l.isStatus() && !(l instanceof LivroAcademico)){
                System.out.println(l);
            }
        }
    }


    @Override
    public void pegaavaliacao(String nome, double nota) {
        for(Livro l: listaDeLivros){
            if(l.getTitulo().equalsIgnoreCase(nome)){
                l.setListaAvaliacoes(nota);
                l.setAvaliacaoMedia(l.avaliaLivro());
                break;
            }
        }
    }
}


















