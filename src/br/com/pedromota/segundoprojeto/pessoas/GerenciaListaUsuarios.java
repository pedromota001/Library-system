package br.com.pedromota.segundoprojeto.pessoas;

import br.com.pedromota.segundoprojeto.livros.Livro;

import java.util.HashMap;

public class GerenciaListaUsuarios {
    private HashMap<String, Pessoa> mapaUsuarios;
    private Pessoa usuarioLogado;

    public GerenciaListaUsuarios() {
        this.mapaUsuarios = new HashMap<>();
    }

    public Pessoa getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Pessoa usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public void addUsuario(Pessoa usuario){
        if (mapaUsuarios.containsKey(usuario.getUsuario())) {
            System.out.println("Nome de usuário já cadastrado, tente com outro nome");
        } else {
            mapaUsuarios.put(usuario.getUsuario(), usuario);
        }
    }

    public void removerUsuario(String nomeUsuario){
        if (mapaUsuarios.containsKey(nomeUsuario)) {
            mapaUsuarios.remove(nomeUsuario);
            System.out.println("Usuário removido com sucesso.");
        } else {
            System.out.println("Usuário não encontrado, remoção não efetuada.");
        }
    }

    public Pessoa verificaLogin(String usuario, String senha){
        Pessoa usuarioEncontrado = mapaUsuarios.get(usuario);
        if (usuarioEncontrado != null && usuarioEncontrado.getSenha().equals(senha)) {
            System.out.println("Login bem sucedido!");
            setUsuarioLogado(usuarioEncontrado);
            return usuarioEncontrado;
        } else {
            System.out.println("Nome de usuário ou senha incorretos.");
            return null;
        }
    }


    public void exibirClientes(){
        for(Pessoa p:mapaUsuarios.values()){
            if(p instanceof Cliente || p instanceof Aluno){
                System.out.println(p);
            }
        }
    }
    public void exibeUsuariosSistema(){
        for(Pessoa p: mapaUsuarios.values()){
            System.out.println(p);
        }
    }
    public void exibirAlunos(){
        boolean achou = false;
        for(Pessoa p:mapaUsuarios.values()){
            if(p instanceof Aluno){
                achou = true;
                System.out.println(p);
            }
        }

        if(!achou){
            System.out.println("Nenhum aluno esta cadastrado no sistema!");
        }

    }
}
