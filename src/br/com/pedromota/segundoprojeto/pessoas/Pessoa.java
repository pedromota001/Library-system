package br.com.pedromota.segundoprojeto.pessoas;

public class Pessoa {
    //pessoas que vão interagir c a biblioteca, manipular permissoes atraves de subclasses de pessoas.
    private String nome;
    private String endereço;
    private String telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
