package br.com.pedromota.segundoprojeto.livros;

public class LivroAcademico extends Livro{
    private String assuntoLivro;

    public LivroAcademico(String autor, String idLivro, String titulo, String editora, String anoDePublicacao) {
        super(autor, idLivro, titulo, editora, anoDePublicacao);
    }

    public String getAssuntoLivro() {
        return assuntoLivro;
    }

    public void setAssuntoLivro(String assuntoLivro) {
        this.assuntoLivro = assuntoLivro;
    }

    @Override
    public String toString() {
        return super.toString() + " Assunto do livro academico: " + getAssuntoLivro();
    }
}
