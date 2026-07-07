public class Livro implements Emprestavel {

    String titulo;
    String autor;
    int anoPublicacao;
    boolean disponivel;

    public Livro(String titulo, String autor, int anoPublicacao, boolean disponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = disponivel;
    }

    @Override
    public void emprestar() {
        if (disponivel) {
            System.out.println("Emprestando esse livro: " + titulo);
            disponivel = false;
        } else {
            System.out.println("Esse livro ja esta emprestado.");
        }
    }

    @Override
    public void devolver() {
        if (!disponivel) {
            System.out.println("O livro: " + titulo + ", foi devolvido.");
            disponivel = true;
        } else {
            System.out.println("Esse livro ja estava disponivel.");
        }
    }

    public void exibirInformacoes() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano: " + anoPublicacao);
        System.out.println("Disponível: " + disponivel);
        System.out.println("-------------------");
    }

    public String getTitulo() {
        return titulo;
    }
}