package br.com.pedromota.segundoprojeto.livros;

public class LivroFiccao extends Livro{
    private boolean eventosSobreNaturais;

    public boolean isEventosSobreNaturais() {
        return eventosSobreNaturais;
    }

    public void setEventosSobreNaturais(boolean eventosSobreNaturais) {
        this.eventosSobreNaturais = eventosSobreNaturais;
    }

    public LivroFiccao(String autor, String idLivro, String titulo, String editora, String anoDePublicacao) {
        super(autor, idLivro, titulo, editora, anoDePublicacao);
    }
    public void verificaLivro(){
        if(isEventosSobreNaturais()){
            System.out.println( "O livro " + getTitulo() + " possui eventos sobrenaturais na sua narrativa, não perca!");
        }
        else{
            System.out.println( "O livro " + getTitulo() + " não possui eventos sobrenaturais, pórem possui outros aspectos que fazem valer a pena ser lido");
        }
    }
}
