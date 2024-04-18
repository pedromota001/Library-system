package br.com.pedromota.segundoprojeto.pessoas;

import java.util.ArrayList;

public class GerenciaListaUsuarios {
    public ArrayList<Usuario> listaUsuarios;
    private Usuario usuarioLogado;

    public GerenciaListaUsuarios() {
        this.listaUsuarios = new ArrayList<Usuario>();
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public void addUsuario(Usuario usuario){
        for(Usuario u:listaUsuarios){
            if(u.getUsuario().equalsIgnoreCase(usuario.getUsuario())){
                System.out.println(("Nome de usuario já cadastrado, tente com outro nome"));
            }
            else{
                this.listaUsuarios.add(usuario);
            }
        }
    }
    public void removerUsuario(Usuario usuario){
        for(Usuario u: listaUsuarios){
            if(u.getUsuario().equalsIgnoreCase(usuario.getUsuario())){
                System.out.println("Removendo usuario...");
                this.listaUsuarios.remove((usuario));
            }
            else{
                System.out.println("Usuario não encontrado, remoção não efetuada.");
            }
        }
    }

    public void verificaLista(Usuario usuario){
        for(Usuario u:listaUsuarios){
            if(u.getUsuario().equalsIgnoreCase(usuario.getUsuario())){
                System.out.println("Usuario encontrado no sistema!");
            }
            else{
                System.out.println("Usuario nao encontrado no sistema!");
                return;
            }
        }
    }
}
