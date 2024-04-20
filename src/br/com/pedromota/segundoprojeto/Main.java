package br.com.pedromota.segundoprojeto;


import br.com.pedromota.segundoprojeto.livros.Livro;
import br.com.pedromota.segundoprojeto.livros.LivroFiccao;
import br.com.pedromota.segundoprojeto.livros.LivroRomance;
import br.com.pedromota.segundoprojeto.livros.LivroSuspense;
import br.com.pedromota.segundoprojeto.pessoas.*;

import java.util.Scanner;

public class Main {
    public static int verificaFuncao(String funcao) {
        if (funcao.equalsIgnoreCase("Bibliotecario")) {
            return 1;
        } else if (funcao.equalsIgnoreCase("Aluno")) {
            return 2;
        } else if (funcao.equalsIgnoreCase("Professor")) {
            return 3;
        }
        return 0;
    }

    public static int verificaTipoLivro(String tipo) {
        if (tipo.toLowerCase().equalsIgnoreCase("romance")) {
            return 1;
        } else if (tipo.toLowerCase().equalsIgnoreCase("suspense")) {
            return 2;
        } else if (tipo.toLowerCase().equalsIgnoreCase("Ficcao cientifica")) {
            return 3;
        }
        return 0;
    }

    public static void main(String[] args) {
        GerenciaListaUsuarios gerenciaListaUsuarios = new GerenciaListaUsuarios();
        Biblioteca biblioteca = new Biblioteca();
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
                System.out.println("""
                        Escolha uma opcao:
                        Opcao 1 - Adicionar livro ao sistema
                        Opcao 2 - Exibir lista de livros disponiveis no sistema
                        Opcao 3 - Exibir lista de livros disponiveis e indisponiveis no sistema
                        Opcao 4 - Exibir lista de indisponiveis no sistema
                        Opcao 5 - Remover livro do sistema
                        Opcao 6 - Exibir lista de clientes
                        Opcao 7 - Fazer devolucao de livro emprestado ao cliente
                        Opcao 8 - Adicionar sinopse a livro
                        Opcao 0 - Sair
                        """);
                resp = scanner.nextInt();
                switch (resp){
                    case 1:
                        System.out.println("Qual nome do livro que voce deseja adicionar? ");
                        String tituloLivro = scanner.nextLine();
                        System.out.println("Qual seria o tipo de livro adicionado(Suspense, Romance ou ficcao)");
                        String tipo = scanner.nextLine();
                        int tipoLivro = verificaTipoLivro(tipo);
                        if(tipoLivro == 1){
                            System.out.println("Informe o autor do livro: ");
                            String autorMain = scanner.nextLine();
                            System.out.println("Informe o id do livro que sera adicionado: ");
                            String idMain = scanner.nextLine();
                            System.out.println("Informe a editora do livro: ");
                            String editoraMain = scanner.nextLine();
                            System.out.println("Informe o ano de lancamento do livro: ");
                            String anoDePublicacaoMain = scanner.nextLine();
                            LivroRomance livro = new LivroRomance(autorMain, idMain, tituloLivro, editoraMain, anoDePublicacaoMain);
                            biblioteca.adicionarLivro(livro);
                        }
                        else if(tipoLivro == 2){
                            System.out.println("Informe o autor do livro: ");
                            String autorMain = scanner.nextLine();
                            System.out.println("Informe o id do livro que sera adicionado: ");
                            String idMain = scanner.nextLine();
                            System.out.println("Informe a editora do livro: ");
                            String editoraMain = scanner.nextLine();
                            System.out.println("Informe o ano de lancamento do livro: ");
                            String anoDePublicacaoMain = scanner.nextLine();
                            LivroSuspense livro = new LivroSuspense(autorMain, idMain, tituloLivro, editoraMain, anoDePublicacaoMain);
                            biblioteca.adicionarLivro(livro);
                        }
                        else{
                            System.out.println("Informe o autor do livro: ");
                            String autorMain = scanner.nextLine();
                            System.out.println("Informe o id do livro que sera adicionado: ");
                            String idMain = scanner.nextLine();
                            System.out.println("Informe a editora do livro: ");
                            String editoraMain = scanner.nextLine();
                            System.out.println("Informe o ano de lancamento do livro: ");
                            String anoDePublicacaoMain = scanner.nextLine();
                            LivroFiccao livro = new LivroFiccao(autorMain, idMain, tituloLivro, editoraMain, anoDePublicacaoMain);
                            biblioteca.adicionarLivro(livro);
                            //adicionar pergunta de inserir sinopse ou nao nos 3 livros DIA 19/04
                        }

                    case 2:
                        //IMPLEMENTAR FUNCAO DE EXIBIR LISTA DIA 19/04
                        break;

                    case 3:
                        break;
                }

            }
            else if(gerenciaListaUsuarios.getUsuarioLogado() instanceof Aluno){
                System.out.println("Bem vindo aluno!");
                System.out.println("---------------------------");
                System.out.println("""
                        Escolha uma opcao: 
                        Opcao 1 - Pegar livro emprestado
                        Opcao 2 - Exibir lista de livros disponiveis no sistema
                        Opcao 3 - Exibir sinopse de livro
                        Opcao 4 - Adicionar avaliacao a livro
                        Opcao 5 - Exibir resumo do tipo do livro
                        Opcao 0 - Sair
                        """);
                resp = scanner.nextInt();
                switch (resp){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 0:
                        break;
                }
            }
            else if(gerenciaListaUsuarios.getUsuarioLogado() instanceof Professor){
                System.out.println("Bem vindo Professor");
                System.out.println("-------------------------------");
                System.out.println("""
                        Escolha uma opcao:
                        Opcao 1 - Pegar livro emprestado
                        Opcao 2 - Exibir lista de livros disponiveis no sistema
                        Opcao 3 - Adicionar avaliacao a livro
                        Opcao 4 - Adicionar livro ao sistema
                        Opcao 5 - Adicionar sinopse a livro
                        """);
            }
            }while(resp != 0);
    }
}
//idealizar novas funcoes para as subsclasses criadas\
//teste
//teste2
//teste3
//teste4