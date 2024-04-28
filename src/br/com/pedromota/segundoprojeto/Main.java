package br.com.pedromota.segundoprojeto;


import br.com.pedromota.segundoprojeto.livros.Livro;
import br.com.pedromota.segundoprojeto.livros.LivroFiccao;
import br.com.pedromota.segundoprojeto.livros.LivroRomance;
import br.com.pedromota.segundoprojeto.livros.LivroAcademico;
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
                        System.out.println("Opcao 3 - Exibir lista de livros indisponiveis no sistema");
                        System.out.println("Opcao 4 - Exibir lista de todos os livros");
                        System.out.println("Opcao 5 - Remover livro do sistema");
                        System.out.println("Opcao 6 - Exibir lista de clientes");
                        System.out.println("Opcao 7 - Adicionar sinopse a um livro");
                        System.out.println("Opcao 8 - Exibir sinopse de livro");
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

                                    System.out.println("De um mini spoiler ao usuario e diga se o livro tem um triangulo amoroso: [sim/nao]");
                                    String trianguloAmoroso = scanner.nextLine();
                                    trianguloAmoroso = trianguloAmoroso.toLowerCase();
                                    if(trianguloAmoroso.equalsIgnoreCase("sim")){
                                        livro.setTrianguloAmoroso(true);
                                    }
                                    else{
                                        livro.setTrianguloAmoroso(false);
                                        livro.setCasal(true);
                                    }

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
                                else if(tipoLivro.equalsIgnoreCase("ficcao")){
                                    System.out.println("Informe o autor do livro: ");
                                    String autorMain = scanner.nextLine();
                                    System.out.println("Informe o id do livro que sera adicionado: ");
                                    String idMain = scanner.nextLine();
                                    System.out.println("Informe a editora do livro: ");
                                    String editoraMain = scanner.nextLine();
                                    System.out.println("Informe o ano de lancamento do livro: ");
                                    String anoDePublicacaoMain = scanner.nextLine();

                                    LivroFiccao livro = new LivroFiccao(autorMain, idMain, tituloLivro, editoraMain, anoDePublicacaoMain);

                                    System.out.println("De um mini spoiler ao usuario e diga sem tem algum evento sobrenatural no livro: [sim/nao]");
                                    String eventoSobrenatural = scanner.nextLine();
                                    eventoSobrenatural = eventoSobrenatural.toLowerCase();
                                    if(eventoSobrenatural.equalsIgnoreCase("sim")){
                                        livro.setEventosSobreNaturais(true);
                                    }
                                    else{
                                        livro.setEventosSobreNaturais(false);
                                    }
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

                                    LivroAcademico livro = new LivroAcademico(autorMain, idMain, tituloLivro, editoraMain, anoDePublicacaoMain);

                                    System.out.println("Digite o assunto que esse livro academico se trata: ");
                                    String assuntoMain = scanner.nextLine();
                                    livro.setAssuntoLivro(assuntoMain);
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
                                biblioteca.exibeTodosLivros();
                                System.out.println("Digite o ID do livro que voce deseja remover: ");
                                String id = scanner.nextLine();
                                biblioteca.removerLivro(id);
                                break;
                            case 6:
                                System.out.println("Exibindo lista de clientes:");
                                gerenciaListaUsuarios.exibirClientes();
                                break;
                            case 7:
                                biblioteca.exibeTodosLivros();
                                System.out.println("Digite o id do livro: ");
                                String idSinopse = scanner.nextLine();
                                System.out.println("Digite a sinopse para esse livro: ");
                                String sinopseAdd = scanner.nextLine();
                                biblioteca.adicionaSinopse(idSinopse,sinopseAdd);
                                break;
                            case 8:
                                biblioteca.exibeTodosLivros();
                                System.out.println("Digite o nome do livro que voce deseja ver a sinopse: ");
                                String nomeSinopse = scanner.nextLine();
                                biblioteca.exibeSinopse(nomeSinopse);
                                break;
                            case 0:
                                System.out.println("Encerrando...");
                                gerenciaListaUsuarios.setUsuarioLogado(null);
                                break;
                        }
                    }
                    else if(gerenciaListaUsuarios.getUsuarioLogado() instanceof Professor){
                        System.out.println("Bem vindo professor " + gerenciaListaUsuarios.getUsuarioLogado().getNome() + "!");
                        System.out.println("""
                                Menu de opcoes:
                                1 - Adicionar livro ao sistema
                                2 - Exibir lista de livros disponiveis
                                3 - Adicionar ou editar sinopse
                                4 - Exibir lista de alunos da biblioteca
                                5 - Exibir sinopse de um livro
                                0 - Sair
                                """);
                        int respProf = scanner.nextInt();
                        switch (respProf){
                            case 1:
                                System.out.println("Insira o tipo de livro que voce deseja adicionar: [Romance, academico, suspense] ");
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
                                else if(tipoLivro.equalsIgnoreCase("ficcao")){
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
                                else{
                                    System.out.println("Informe o autor do livro: ");
                                    String autorMain = scanner.nextLine();
                                    System.out.println("Informe o id do livro que sera adicionado: ");
                                    String idMain = scanner.nextLine();
                                    System.out.println("Informe a editora do livro: ");
                                    String editoraMain = scanner.nextLine();
                                    System.out.println("Informe o ano de lancamento do livro: ");
                                    String anoDePublicacaoMain = scanner.nextLine();

                                    LivroAcademico livro = new LivroAcademico(autorMain, idMain, tituloLivro, editoraMain, anoDePublicacaoMain);

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
                                System.out.println("Exibindo lista de livros disponiveis no sistema: ");
                                biblioteca.exibeListaDisponiveis();
                                break;

                            case 3:
                                System.out.println("Digite o ID do livro: ");
                                String id = scanner.nextLine();
                                System.out.println("Digite a sinopse do livro: ");
                                String sinopse = scanner.nextLine();
                                biblioteca.adicionaSinopse(id, sinopse);
                                break;

                            case 4:
                                System.out.println("Exibindo lista de alunos da biblioteca: ");
                                gerenciaListaUsuarios.exibirAlunos();
                                break;

                            case 5:
                                biblioteca.exibeListaDisponiveis();
                                System.out.println("Digite o nome do livro que voce deseja ver a sinopse: ");
                                String nomeSinopse = scanner.nextLine();
                                biblioteca.exibeSinopse(nomeSinopse);
                                break;

                            case 0:
                                System.out.println("Encerrando...");
                                gerenciaListaUsuarios.setUsuarioLogado(null);
                                break;
                        }
                    }
                    else if(gerenciaListaUsuarios.getUsuarioLogado() instanceof Aluno){
                        System.out.println("Bem vindo aluno " + gerenciaListaUsuarios.getUsuarioLogado().getNome() + "!");
                        System.out.println("""
                                Menu de opcoes:
                                1 - Pegar livro emprestado(Apenas academicos)
                                2 - Devolver livro
                                3 - Exibir livros disponiveis
                                4 - Exibir meus livros
                                5 - Exibir sinopse de livro
                                6 - Avaliar livro
                                0 - Sair
                                """);
                        int respAluno = scanner.nextInt();
                        scanner.nextLine();
                        switch (respAluno){

                            case 1:
                                biblioteca.exibeDisponiveisAluno();
                                System.out.println("Digite o ID do livro que voce deseja: ");
                                String idLivro = scanner.nextLine();
                                Livro livro = biblioteca.emprestimoAluno(idLivro);

                                if(livro == null){
                                    System.out.println("Erro ao fazer emprestimo, tente novamente! ");
                                }
                                else{
                                    ((Aluno) gerenciaListaUsuarios.getUsuarioLogado()).listaLivrosEmprestados.add(livro);
                                }

                                break;
                            case 2:
                                ((Aluno) gerenciaListaUsuarios.getUsuarioLogado()).imprimeLivrosEmprestados();
                                System.out.println("Digite o ID do livro que voce ira devolver: ");
                                String idDevolucao = scanner.nextLine();
                                Livro livro1 = biblioteca.devolucaoAluno(idDevolucao);

                                if(livro1 == null){
                                    System.out.println("Erro ao fazer devolucao, tente novamente!");
                                }
                                else{
                                    ((Aluno) gerenciaListaUsuarios.getUsuarioLogado()).listaLivrosEmprestados.remove(livro1);
                                }
                                break;

                            case 3:
                                System.out.println("Exibindo lista de disponiveis: ");
                                biblioteca.exibeDisponiveisAluno();
                                break;

                            case 4:
                                ((Aluno) gerenciaListaUsuarios.getUsuarioLogado()).imprimeLivrosEmprestados();
                                break;

                            case 5:
                                biblioteca.exibeTodosLivros();
                                System.out.println("Digite o nome do livro que voce deseja visualizar a sinopse: ");
                                String nomeSinopse = scanner.nextLine();
                                biblioteca.exibeSinopse(nomeSinopse);
                                break;
                            case 6:
                                System.out.println("Digite o nome do livro que voce deseja avaliar: ");
                                String nomeAvalia = scanner.nextLine();
                                System.out.println("Digite a nota que voce da para esse livro: ");
                                double notaLivro = scanner.nextDouble();
                                scanner.nextLine();
                                biblioteca.pegaavaliacao(nomeAvalia, notaLivro);
                                break;

                            case 0:
                                System.out.println("Encerrando...");
                                gerenciaListaUsuarios.setUsuarioLogado(null);
                                break;
                        }
                    }
                    else if(gerenciaListaUsuarios.getUsuarioLogado() instanceof Cliente){
                        System.out.println("Bem vindo cliente " + gerenciaListaUsuarios.getUsuarioLogado().getNome() + "!");
                        System.out.println("""
                                Menu de opcoes:
                                1 - Pegar livro emprestado [Apenas livros sem ser academicos]
                                2 - Devolver livro emprestado
                                3 - Exibir lista de livros disponiveis no sistema
                                4 - Exibir meus livros
                                5 - Exibir sinopse de livro
                                6 - Avaliar livro
                                0 - Sair
                                """);
                        int respCliente = scanner.nextInt();
                        scanner.nextLine();
                        switch (respCliente){

                            case 1:
                                biblioteca.exibeDisponiveisClientes();
                                System.out.println("Digite o id do livro: ");
                                String idLivroCliente = scanner.nextLine();
                                Livro livro = biblioteca.emprestimoCliente(idLivroCliente);

                                if(livro == null){
                                    System.out.println("Erro ao fazer emprestimo, tente novamente!");
                                }
                                else{
                                    ((Cliente) gerenciaListaUsuarios.getUsuarioLogado()).listaLivrosEmprestados.add(livro);
                                }
                                break;

                            case 2:
                                ((Cliente) gerenciaListaUsuarios.getUsuarioLogado()).imprimeLivrosCliente();
                                System.out.println("Digite o id do livro que voce ira devolver: ");
                                String idDevolveCliente = scanner.nextLine();
                                Livro livro1 = biblioteca.devolucaoCliente(idDevolveCliente);

                                if(livro1 == null){
                                    System.out.println("Erro na devolucao, tente novamente!");
                                }
                                else{
                                    ((Cliente) gerenciaListaUsuarios.getUsuarioLogado()).listaLivrosEmprestados.remove(livro1);
                                }

                                break;

                            case 3:
                                System.out.println("Exibindo lista de disponiveis: ");
                                biblioteca.exibeDisponiveisClientes();
                                break;

                            case 4:
                                ((Cliente) gerenciaListaUsuarios.getUsuarioLogado()).imprimeLivrosCliente();
                                break;

                            case 5:
                                biblioteca.exibeTodosLivros();
                                System.out.println("Digite o nome do livro que voce deseja ver a sinopse: ");
                                String nomeSinopse = scanner.nextLine();
                                biblioteca.exibeSinopse(nomeSinopse);
                                break;
                            case 6:
                                System.out.println("Digite o nome do livro que voce deseja avaliar: ");
                                String nomeAvalia = scanner.nextLine();
                                System.out.println("Digite a nota que voce da para esse livro: ");
                                double notaLivro = scanner.nextDouble();
                                scanner.nextLine();
                                biblioteca.pegaavaliacao(nomeAvalia, notaLivro);
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
