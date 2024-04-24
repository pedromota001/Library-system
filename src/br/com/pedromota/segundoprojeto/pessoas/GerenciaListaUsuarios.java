package br.com.pedromota.segundoprojeto.pessoas;

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

    public void removerUsuario(Pessoa usuario){
        if (mapaUsuarios.containsKey(usuario.getUsuario())) {
            mapaUsuarios.remove(usuario.getUsuario());
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

    public void exibeUsuariosSistema(){
        for(Pessoa p: mapaUsuarios.values()){
            System.out.println(p);
        }
    }
}
