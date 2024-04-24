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
        System.out.println("Digite a sua função (Administradores: Bibliotecario ou professor// Clientes: Aluno ou cliente): ");
        String funcao = scanner.nextLine();
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite seu endereco: ");
        String endereco = scanner.nextLine();
        System.out.println("Digite seu numero de contato: ");
        String telefone = scanner.nextLine();
        System.out.println("Insira seu usuário: ");
        String usuario = scanner.next();
        scanner.nextLine();
        System.out.println("Insira sua senha: ");
        String senha = scanner.next();
        scanner.nextLine();
        switch (funcao.toLowerCase()) {
            case "bibliotecario":
                Bibliotecario bibliotecario = new Bibliotecario(usuario, senha, nome, endereco, telefone);
                gerenciaListaUsuarios.addUsuario(bibliotecario);
                gerenciaListaUsuarios.setUsuarioLogado(bibliotecario);
                break;
            case "aluno":
                System.out.println("Insira seu id: ");
                String idAluno = scanner.nextLine();
                Aluno aluno = new Aluno(usuario, senha, nome, endereco, telefone, idAluno);
                gerenciaListaUsuarios.addUsuario(aluno);
                gerenciaListaUsuarios.setUsuarioLogado(aluno);
                break;
            case "professor":
                Professor professor = new Professor(usuario, senha, nome, endereco, telefone);
                gerenciaListaUsuarios.addUsuario(professor);
                gerenciaListaUsuarios.setUsuarioLogado(professor);
                break;
            case "cliente":
                System.out.println("Insira seu id: ");
                String idCliente = scanner.nextLine();
                Cliente cliente = new Cliente(usuario, senha, nome,endereco,telefone,idCliente);
                gerenciaListaUsuarios.addUsuario(cliente);
                gerenciaListaUsuarios.setUsuarioLogado(cliente);
                break;
            default:
                System.out.println("Função inválida!");
        }
    }

    public static void entrarNaConta(GerenciaListaUsuarios gerenciaListaUsuarios) {
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
        int respConta = 0;
        do {
            try {
                System.out.println("""
                        Menu de entrada:
                        1 - Criar conta
                        2 - Entrar com uma conta ja existente
                        0 - Sair
                        """);
                respConta = scanner.nextInt();
                scanner.nextLine();
                switch (respConta) {
                    case 1:
                        criarConta(gerenciaListaUsuarios);
                        break;
                    case 2:
                        entrarNaConta(gerenciaListaUsuarios);
                        break;
                    case 0:
                        System.out.println("Encerrando sistema...");
                        break;
                    default:
                        System.out.println("Opcao invalida");
                }
                while(gerenciaListaUsuarios.getUsuarioLogado() != null){
                    if(gerenciaListaUsuarios.getUsuarioLogado() instanceof Bibliotecario){
                        System.out.println("Bem vindo bibliotecario " + gerenciaListaUsuarios.getUsuarioLogado().getNome());
                        System.out.println("Escolha uma opcao: ");
                        System.out.println("Opcao 1 - Adicionar livro ao sistema");
                        System.out.println("Opcao 2 - Exibir lista de livros disponiveis no sistema");
                        System.out.println("Opcao 3 - Exibir lista de livros Indisponiveis no sistema");
                        System.out.println("Opcao 4 - Exibir lista de todos os livros");
                        System.out.println("Opcao 5 - Remover livro do sistema");
                        System.out.println("Opcao 6 - Exibir lista de clientes");
                        System.out.println("Opcao 7 - Adicionar sinopse a um livro");
                        System.out.println("Opcao 0 - Sair");
                        int resp = scanner.nextInt();
                        scanner.nextLine();
                        switch (resp){
                            case 1:
                                System.out.println("Insira o tipo de livro que voce deseja adicionar: ");
                                String tipoLivro = scanner.nextLine();
                                System.out.println("Insira o nome do livro que voce deseja adicionar: ");
                                String tituloLivro = scanner.nextLine();
                                tipoLivro = tipoLivro.toLowerCase();
                                if(tipoLivro.equalsIgnoreCase("romance")){
                                    System.out.println("Informe o autor do livro: ");
                                    String autorMain = scanner.nextLine();
                                    System.out.println("Informe o id do livro que sera adicionado: ");
                                    String idMain = scanner.nextLine();
                                    System.out.println("Informe a editora do livro: ");
                                    String editoraMain = scanner.nextLine();
                                    System.out.println("Informe o ano de lancamento do livro: ");
                                    String anoDePublicacaoMain = scanner.nextLine();
                                    LivroRomance livro = new LivroRomance(autorMain, idMain, tituloLivro, editoraMain, anoDePublicacaoMain);
                                    System.out.println("Voce deseja adicionar sinopse para o livro? [Sim/Nao]");
                                    String respSinopse = scanner.next();
                                    respSinopse = respSinopse.toLowerCase();
                                    scanner.nextLine();
                                    if(respSinopse.equalsIgnoreCase("sim")){
                                        System.out.println("Insira a sinopse do livro: " + livro.getTitulo());
                                        String sinopseMain = scanner.nextLine();
                                        livro.setSinopse(sinopseMain);
                                    }
                                    biblioteca.adicionarLivro(livro);
                                }
                                else if(tipoLivro.equalsIgnoreCase("suspense")){
                                    System.out.println("Informe o autor do livro: ");
                                    String autorMain = scanner.nextLine();
                                    System.out.println("Informe o id do livro que sera adicionado: ");
                                    String idMain = scanner.nextLine();
                                    System.out.println("Informe a editora do livro: ");
                                    String editoraMain = scanner.nextLine();
                                    System.out.println("Informe o ano de lancamento do livro: ");
                                    String anoDePublicacaoMain = scanner.nextLine();
                                    LivroSuspense livro = new LivroSuspense(autorMain, idMain, tituloLivro, editoraMain, anoDePublicacaoMain);
                                    System.out.println("Voce deseja adicionar sinopse para o livro? [Sim/Nao]");
                                    String respSinopse = scanner.next();
                                    respSinopse =  respSinopse.toLowerCase();
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
                                    respSinopse =  respSinopse.toLowerCase();
                                    scanner.nextLine();
                                    if(respSinopse.equalsIgnoreCase("sim")){
                                        System.out.println("Insira a sinopse do livro: " + livro.getTitulo());
                                        String sinopseMain = scanner.nextLine();
                                        livro.setSinopse(sinopseMain);
                                    }
                                    biblioteca.adicionarLivro(livro);
                                }
                                break;
                            case 2:
                                System.out.println("Exibindo lista dos livros disponiveis no sistema: ");
                                biblioteca.exibeListaDisponiveis();
                                break;
                            case 3:
                                System.out.println("Exibindo lista dos livros indisponiveis no sistema: ");
                                biblioteca.exibeIndisponiveis();
                                break;
                            case 4:
                                System.out.println("Exibindo lista de todos os livros do sistema: ");
                                biblioteca.exibeTodosLivros();
                                break;
                            case 5:
                                System.out.println("Digite o ID do livro que voce deseja remover: ");
                                String id = scanner.nextLine();
                                biblioteca.removerLivro(id);
                                //revisar funcao de remover pra ver se esta certa
                                break;
                            case 6:
                                System.out.println("Exibir lista de clientes");
                                //implementar funcao dia 24/04/2024
                                break;
                            case 0:
                                System.out.println("Encerrando...");
                                gerenciaListaUsuarios.setUsuarioLogado(null);
                                break;
                        }
                    }
                }










            }catch (Exception e){
                System.out.println("Erro, entrada invalida");
                break;
            }
        } while (respConta != 0);
    }
}