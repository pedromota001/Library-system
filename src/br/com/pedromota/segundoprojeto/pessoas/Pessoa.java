package br.com.pedromota.segundoprojeto.pessoas;

public class Pessoa {
    //pessoas que vão interagir c a biblioteca, manipular permissoes atraves de subclasses de pessoas.
    private String nome;
    private String endereco;
    private String telefone;
    private String usuario;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereço(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public Pessoa(String usuario, String senha, String nome, String endereco, String telefone) {
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() +  "// Usuario: " + getUsuario() + "// Endereco: " + getEndereco() + "// Telefone: " + getTelefone();
    }
}
