package br.com.pedromota.segundoprojeto.livros;

public class LivroRomance extends Livro{
    private boolean trianguloAmoroso;
    private boolean casal;

    public boolean isTrianguloAmoroso() {
        return trianguloAmoroso;
    }

    public void setTrianguloAmoroso(boolean trianguloAmoroso) {
        this.trianguloAmoroso = trianguloAmoroso;
    }

    public boolean isCasal() {
        return casal;
    }

    public void setCasal(boolean casal) {
        this.casal = casal;
    }

    public LivroRomance(String autor, String idLivro, String titulo, String editora, String anoDePublicacao) {
        super(autor, idLivro, titulo, editora, anoDePublicacao);
    }

    public void vefificaLivro() {
        if(isTrianguloAmoroso()){
            System.out.println("O livro "+ getTitulo() + " tem um triangulo amoroso na sua historia, não perca!");
        }
        else{
            if(isCasal()){
                System.out.println( "O livro " + getTitulo() + " conta a historia de um casal, não perca!");
            }
        }
    }
}
