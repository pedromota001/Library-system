package br.com.pedromota.segundoprojeto;


import br.com.pedromota.segundoprojeto.pessoas.*;

import java.util.Scanner;

public class Main {
    public static int verificaFuncao(String funcao){
        if(funcao.equalsIgnoreCase("Bibliotecario")){
            return 1;
        }
        else if(funcao.equalsIgnoreCase("Aluno")){
            return 2;
        }
        else if(funcao.equalsIgnoreCase("Professor")){
            return 3;
        }
        return 0;
    }





    public static void main(String[] args) {
        GerenciaListaUsuarios gerenciaListaUsuarios = new GerenciaListaUsuarios();
        Scanner scanner = new Scanner(System.in);
        int resp = 0;
        String usuarioMain;
        String senhaMain;
        String funcaoMain;
        System.out.println("Digite a sua funcao: ");
        funcaoMain = scanner.nextLine();
        System.out.println("Insira seu usuario: ");
        usuarioMain = scanner.next();
        scanner.nextLine();
        System.out.println("Insira sua senha: ");
        senhaMain = scanner.next();
        scanner.nextLine();
        int func = verificaFuncao(funcaoMain);
        if(func == 1){
            Bibliotecario bibliotecario = new Bibliotecario(usuarioMain, senhaMain);
            gerenciaListaUsuarios.addUsuario(bibliotecario);
            gerenciaListaUsuarios.setUsuarioLogado(bibliotecario);
        }
        else if(func == 2){
            Aluno aluno = new Aluno(usuarioMain, senhaMain);
            gerenciaListaUsuarios.addUsuario(aluno);
            gerenciaListaUsuarios.setUsuarioLogado(aluno);
        }
        else{
            Professor professor = new Professor(usuarioMain, senhaMain);
            gerenciaListaUsuarios.addUsuario(professor);
            gerenciaListaUsuarios.setUsuarioLogado(professor);
        }
        do {
            if(gerenciaListaUsuarios.getUsuarioLogado() instanceof Bibliotecario){
                System.out.println("Bem vindo bibliotecario!");
                System.out.println("------------------------------------");
                //exibir menu de opcoes do bibliotecario
            }
            else if(gerenciaListaUsuarios.getUsuarioLogado() instanceof Aluno){
                System.out.println("Bem vindo aluno!");
                System.out.println("---------------------------");
                //exibir menu de opcoes do aluno
            }
            else if(gerenciaListaUsuarios.getUsuarioLogado() instanceof Professor){
                System.out.println("Bem vindo Professor");
                System.out.println("-------------------------------");
                //exibir menu de opcoes do professor
            }
            }while(resp != 0);
    }
}
//idealizar novas funcoes para as subsclasses criadas\
//teste
//teste2
//teste3
//teste4
