package br.com.pedromota.segundoprojeto;


import br.com.pedromota.segundoprojeto.livros.Livro;
import br.com.pedromota.segundoprojeto.livros.LivroFiccao;
import br.com.pedromota.segundoprojeto.livros.LivroRomance;
import br.com.pedromota.segundoprojeto.livros.LivroSuspense;
import br.com.pedromota.segundoprojeto.pessoas.*;

import java.util.Scanner;

public class Main {
    public static void criarConta(GerenciaListaUsuarios gerenciaListaUsuarios) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a sua função (Bibliotecário, Aluno ou Professor): ");
        String funcao = scanner.nextLine();
        System.out.println("Insira seu usuário: ");
        String usuario = scanner.next();
        scanner.nextLine();
        System.out.println("Insira sua senha: ");
        String senha = scanner.next();
        scanner.nextLine();
        switch (funcao.toLowerCase()) {
            case "bibliotecario":
                Bibliotecario bibliotecario = new Bibliotecario(usuario, senha);
                gerenciaListaUsuarios.addUsuario(bibliotecario);
                gerenciaListaUsuarios.setUsuarioLogado(bibliotecario);
                break;
            case "aluno":
                Aluno aluno = new Aluno(usuario, senha);
                gerenciaListaUsuarios.addUsuario(aluno);
                gerenciaListaUsuarios.setUsuarioLogado(aluno);
                break;
            case "professor":
                Professor professor = new Professor(usuario, senha);
                gerenciaListaUsuarios.addUsuario(professor);
                gerenciaListaUsuarios.setUsuarioLogado(professor);
                break;
            default:
                System.out.println("Função inválida!");
        }
    }
    public static void entrarNaConta(GerenciaListaUsuarios gerenciaListaUsuarios){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu usuario: ");
        String usuario = scanner.next();
        scanner.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = scanner.next();
        scanner.nextLine();
        gerenciaListaUsuarios.verificaLogin(usuario, senha);
    }




    public static void main(String[] args) {
        GerenciaListaUsuarios gerenciaListaUsuarios = new GerenciaListaUsuarios();
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int resp = 0;
        int respConta = 0;
        do{
            System.out.println("""
                    Menu de entrada:
                    1 - Criar conta
                    2 - Entrar com uma conta ja existente
                    0 - Sair
                    """);
        respConta = scanner.nextInt();
        scanner.nextLine();
        switch (respConta){
            case 1:
                criarConta(gerenciaListaUsuarios);
                break;
            case 2:
                entrarNaConta(gerenciaListaUsuarios);
                break;
        }
        do{
            if(gerenciaListaUsuarios.getUsuarioLogado() instanceof Bibliotecario){
                System.out.println("Bem vindo bibliotecario " + gerenciaListaUsuarios.getUsuarioLogado().getUsuario() + "!");
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
                scanner.nextLine();
                switch (resp){
                    case 1:
                        System.out.println("Qual nome do livro que voce deseja adicionar? ");
                        String tituloLivro = scanner.nextLine();
                        System.out.println("Qual seria o tipo de livro adicionado(Suspense, Romance ou ficcao)");
                        String tipo = scanner.nextLine();
                        tipo.toLowerCase();
                        if(tipo.equalsIgnoreCase("romance")){
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
                            System.out.println("Voce deseja adicionar sinopse para o livro? [Sim/Nao]");
                            String respSinopse = scanner.next();
                            respSinopse.toLowerCase();
                            scanner.nextLine();
                            if(respSinopse.equalsIgnoreCase("sim")){
                                System.out.println("Insira a sinopse do livro: " + livro.getTitulo());
                                String sinopseMain = scanner.nextLine();
                                livro.setSinopse(sinopseMain);
                            }
                            biblioteca.adicionarLivro(livro);
                        }
                        else if(tipo.equalsIgnoreCase("Suspense")){
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
                            System.out.println("Voce deseja adicionar sinopse para o livro? [Sim/Nao]");
                            String respSinopse = scanner.next();
                            respSinopse.toLowerCase();
                            scanner.nextLine();
                            if(respSinopse.equalsIgnoreCase("sim")){
                                System.out.println("Insira a sinopse do livro: " + livro.getTitulo());
                                String sinopseMain = scanner.nextLine();
                                livro.setSinopse(sinopseMain);
                            }
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
                            System.out.println("Voce deseja adicionar sinopse para o livro? [Sim/Nao]");
                            String respSinopse = scanner.next();
                            respSinopse.toLowerCase();
                            scanner.nextLine();
                            if(respSinopse.equalsIgnoreCase("sim")){
                                System.out.println("Insira a sinopse do livro: " + livro.getTitulo());
                                String sinopseMain = scanner.nextLine();
                                livro.setSinopse(sinopseMain);
                            }
                            biblioteca.adicionarLivro(livro);
                        }
                    case 2:
                        biblioteca.exibeListaDisponiveis();
                        break;
                    case 3:
                        biblioteca.exibeTodosLivros();
                        break;
                    case 4:
                        biblioteca.exibeIndisponiveis();
                        break;
                    case 5:
                        biblioteca.exibeTodosLivros();
                        System.out.println("Qual ID do livro que voce deseja remover do sistema? ");
                        String IDlivroRemover = scanner.nextLine();
                        biblioteca.removerLivro(IDlivroRemover);
                        break;
                    case 6:
                        gerenciaListaUsuarios.exibeUsuariosSistema();
                        break;
                    case 7:

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
            }while (resp != 0);
        }while(respConta != 0);

    }
}

//idealizar novas funcoes para as subsclasses criadas\
//teste
//teste2
//teste3
//teste4